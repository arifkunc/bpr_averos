package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import net.plaut.bprtab.constant.DbConstant;
import net.plaut.bprtab.exception.SaldoNotEnoughException;
import net.plaut.bprtab.object.AddTransactionDto;
import net.plaut.bprtab.object.TransactionDto;
import net.plaut.bprtab.object.UpdateNasabahDto;
import net.plaut.bprtab.util.LoginInformation;
import net.plaut.common.util.DateUtil;
import net.plaut.common.util.PropertiesReader;

public class TransactionFacade {
	private static TransactionFacade instance;

	private TransactionFacade() {
	}

	public static TransactionFacade getInstance() {
		if (instance == null) {
			instance = new TransactionFacade();
		}
		return instance;
	}
	
	public void setorTabungan(Connection con, TransactionDto dto) throws SQLException{
		NasabahLogic nsbLogic = NasabahLogic.getInstance();
		TransactionLogic trLogic = TransactionLogic.getInstance();
		
		double beforeSaldo = nsbLogic.getNasabahSaldo(con, dto.getRekeningNo());
		double afterSaldo = beforeSaldo + dto.getNominal();
		
		// insert table BPA_TRANSAKSI
		AddTransactionDto addTrDto = new AddTransactionDto();
		addTrDto.setKodeTransaksi(DbConstant.BPA_TRANSAKSI_KODE_TRANSAKSI_SETOR);
		addTrDto.setTglTransaksi(DateUtil.toSqlDate(new Date()));
		addTrDto.setNoRekening(dto.getRekeningNo());
		addTrDto.setNominal(dto.getNominal());
		addTrDto.setSaldo(afterSaldo);
		addTrDto.setUsername(LoginInformation.getInstance().getUsername());
		trLogic.insertTransaction(addTrDto);
		
		// update table BPA_NASABAH
		UpdateNasabahDto upNsbDto = new UpdateNasabahDto();
		upNsbDto.setRekeningNo(dto.getRekeningNo());
		upNsbDto.setSaldo(afterSaldo);
		nsbLogic.updateNasabah(con, upNsbDto);
	}
	
	public void tarikTabungan(Connection con, TransactionDto dto) throws SQLException, SaldoNotEnoughException{
		NasabahLogic nsbLogic = NasabahLogic.getInstance();
		TransactionLogic trLogic = TransactionLogic.getInstance();
		
		double beforeSaldo = nsbLogic.getNasabahSaldo(con, dto.getRekeningNo());
		double afterSaldo = beforeSaldo - dto.getNominal();
		PropertiesReader prop = new PropertiesReader("prop/config.properties");
		double minSaldoLimit = Double.valueOf(prop.getProperty("min.saldo.limit")).doubleValue();
		
		if(afterSaldo < minSaldoLimit){
			throw new SaldoNotEnoughException("Saldo tidak cukup untuk melakukan penarikan");
		}
		
		// insert table BPA_TRANSAKSI
		AddTransactionDto addTrDto = new AddTransactionDto();
		addTrDto.setKodeTransaksi(DbConstant.BPA_TRANSAKSI_KODE_TRANSAKSI_TARIK);
		addTrDto.setTglTransaksi(DateUtil.toSqlDate(new Date()));
		addTrDto.setNoRekening(dto.getRekeningNo());
		addTrDto.setNominal(dto.getNominal());
		addTrDto.setSaldo(afterSaldo);
		addTrDto.setUsername(LoginInformation.getInstance().getUsername());
		trLogic.insertTransaction(addTrDto);
		
		// update table BPA_NASABAH
		UpdateNasabahDto upNsbDto = new UpdateNasabahDto();
		upNsbDto.setRekeningNo(dto.getRekeningNo());
		upNsbDto.setSaldo(afterSaldo);
		nsbLogic.updateNasabah(con, upNsbDto);
	}
	
	public void batalSetorTabungan(Connection con, TransactionDto dto) throws SQLException, SaldoNotEnoughException{
		NasabahLogic nsbLogic = NasabahLogic.getInstance();
		TransactionLogic trLogic = TransactionLogic.getInstance();
		
		double beforeSaldo = nsbLogic.getNasabahSaldo(con, dto.getRekeningNo());
		double afterSaldo = beforeSaldo - dto.getNominal();
		PropertiesReader prop = new PropertiesReader("prop/config.properties");
		double minSaldoLimit = Double.valueOf(prop.getProperty("min.saldo.limit")).doubleValue();
		
		if(afterSaldo < minSaldoLimit){
			throw new SaldoNotEnoughException("Saldo tidak cukup untuk melakukan batal penyetoran");
		}
		
		// insert table BPA_TRANSAKSI
		AddTransactionDto addTrDto = new AddTransactionDto();
		addTrDto.setKodeTransaksi(DbConstant.BPA_TRANSAKSI_KODE_TRANSAKSI_CANCEL_SETOR);
		addTrDto.setTglTransaksi(DateUtil.toSqlDate(new Date()));
		addTrDto.setNoRekening(dto.getRekeningNo());
		addTrDto.setNominal(dto.getNominal());
		addTrDto.setSaldo(afterSaldo);
		addTrDto.setUsername(LoginInformation.getInstance().getUsername());
		trLogic.insertTransaction(addTrDto);
		
		// update table BPA_NASABAH
		UpdateNasabahDto upNsbDto = new UpdateNasabahDto();
		upNsbDto.setRekeningNo(dto.getRekeningNo());
		upNsbDto.setSaldo(afterSaldo);
		nsbLogic.updateNasabah(con, upNsbDto);
	}
	
	public void batalTarikTabungan(Connection con, TransactionDto dto) throws SQLException{
		NasabahLogic nsbLogic = NasabahLogic.getInstance();
		TransactionLogic trLogic = TransactionLogic.getInstance();
		
		double beforeSaldo = nsbLogic.getNasabahSaldo(con, dto.getRekeningNo());
		double afterSaldo = beforeSaldo + dto.getNominal();
		
		// insert table BPA_TRANSAKSI
		AddTransactionDto addTrDto = new AddTransactionDto();
		addTrDto.setKodeTransaksi(DbConstant.BPA_TRANSAKSI_KODE_TRANSAKSI_CANCEL_TARIK);
		addTrDto.setTglTransaksi(DateUtil.toSqlDate(new Date()));
		addTrDto.setNoRekening(dto.getRekeningNo());
		addTrDto.setNominal(dto.getNominal());
		addTrDto.setSaldo(afterSaldo);
		addTrDto.setUsername(LoginInformation.getInstance().getUsername());
		trLogic.insertTransaction(addTrDto);
		
		// update table BPA_NASABAH
		UpdateNasabahDto upNsbDto = new UpdateNasabahDto();
		upNsbDto.setRekeningNo(dto.getRekeningNo());
		upNsbDto.setSaldo(afterSaldo);
		nsbLogic.updateNasabah(con, upNsbDto);
	}
}
