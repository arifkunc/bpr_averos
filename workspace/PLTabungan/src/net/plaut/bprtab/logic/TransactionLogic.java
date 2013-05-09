package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;

import net.plaut.bprtab.dao.BpaTransaksiTableDao;
import net.plaut.bprtab.dao.BpaTransaksiTableRecord;
import net.plaut.bprtab.dao.condition.BpaTransaksiSrcCond;
import net.plaut.bprtab.object.AddTransactionDto;
import net.plaut.bprtab.object.UpdateTransactionDto;
import net.plaut.bprtab.util.DbCommand;

public class TransactionLogic {
	private static TransactionLogic instance;

	private TransactionLogic(){
	}

	public static TransactionLogic getInstance(){
		if(instance == null){
			instance = new TransactionLogic(); 
		}
		return instance;
	}
	
	public void insertTransaction(AddTransactionDto dto) throws SQLException{
		Connection con = DbCommand.getConnection();

		BpaTransaksiTableRecord record = new BpaTransaksiTableRecord();
		record.setId(dto.getId());
		record.setKodeTransaksi(dto.getKodeTransaksi());
		record.setTglTransaksi(dto.getTglTransaksi());
		record.setNoRekening(dto.getNoRekening());
		record.setNominal(dto.getNominal());
		record.setSaldo(dto.getSaldo());
		record.setUsername(dto.getUsername());
		BpaTransaksiTableDao userDao = BpaTransaksiTableDao.getInstance();
		userDao.insert(con, record);
		con.close();
	}
	
	public void updateTransaction(UpdateTransactionDto dto) throws SQLException{
		Connection con = DbCommand.getConnection();

		BpaTransaksiTableRecord record = new BpaTransaksiTableRecord();
		record.setId(dto.getId());
		record.setKodeTransaksi(dto.getKodeTransaksi());
		record.setTglTransaksi(dto.getTglTransaksi());
		record.setNoRekening(dto.getNoRekening());
		record.setNominal(dto.getNominal());
		record.setSaldo(dto.getSaldo());
		record.setUsername(dto.getUsername());
		
		BpaTransaksiTableDao userDao = BpaTransaksiTableDao.getInstance();
		BpaTransaksiSrcCond cond = new BpaTransaksiSrcCond();
		cond.setId(dto.getOldId());
		userDao.update(con, record, cond);
		con.close();
	}
	
	public void deleteTransaction(int id) throws SQLException{
		Connection con = DbCommand.getConnection();

		BpaTransaksiTableDao userDao = BpaTransaksiTableDao.getInstance();
		BpaTransaksiSrcCond cond = new BpaTransaksiSrcCond();
		cond.setId(id);
		userDao.delete(con, cond);
		con.close();
	}
}
