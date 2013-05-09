package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.plaut.bprtab.dao.BpaNasabahTableDao;
import net.plaut.bprtab.dao.BpaNasabahTableRecord;
import net.plaut.bprtab.dao.condition.BpaNasabahSrcCond;
import net.plaut.bprtab.object.AddNasabahDto;
import net.plaut.bprtab.object.UpdateNasabahDto;
import net.plaut.common.util.DateUtil;

public class NasabahLogic {

	private static NasabahLogic instance;

	private NasabahLogic(){
	}

	public static NasabahLogic getInstance(){
		if(instance == null){
			instance = new NasabahLogic(); 
		}
		return instance;
	}

	public void insertNasabah(Connection con, AddNasabahDto dto) throws SQLException{
		BpaNasabahTableRecord record = new BpaNasabahTableRecord();
		record.setNoRekening(dto.getNoRekening());
		record.setNamaLengkap(dto.getNamaLengkap());
		record.setNis(dto.getNis());
		record.setKelas(dto.getKelas());
		record.setGender(dto.getGender());
		record.setAlamat(dto.getAlamat());
		record.setNamaOrangTua(dto.getNamaOrangTua());
		record.setNoKontak(dto.getTelepon());
		record.setSaldo(dto.getSaldo());
		record.setTglDaftar(DateUtil.toSqlDate(dto.getTanggalDaftar()));
		record.setKet(dto.getKet());
		
		BpaNasabahTableDao nasabahDao = BpaNasabahTableDao.getInstance();
		nasabahDao.insert(con, record);
		con.close();
	}
	
	public void updateNasabah(Connection con, UpdateNasabahDto dto) throws SQLException{
		BpaNasabahTableRecord record = new BpaNasabahTableRecord();
		record.setNamaLengkap(dto.getNamaLengkap());
		record.setNis(dto.getNis());
		record.setKelas(dto.getKelas());
		record.setGender(dto.getGender());
		record.setAlamat(dto.getAlamat());
		record.setNamaOrangTua(dto.getNamaOrangTua());
		record.setNoKontak(dto.getTelepon());
		record.setSaldo(dto.getSaldo());
		record.setTglDaftar(DateUtil.toSqlDate(dto.getTanggalDaftar()));
		record.setKet(dto.getKet());
		
		BpaNasabahTableDao nasabahDao = BpaNasabahTableDao.getInstance();
		BpaNasabahSrcCond cond = new BpaNasabahSrcCond();
		cond.setNoRekening(dto.getRekeningNo());
		nasabahDao.update(con, record, cond);
		con.close();
	}
	
	public void deleteUser(Connection con, String noRekening) throws SQLException{
		BpaNasabahTableDao nasabahDao = BpaNasabahTableDao.getInstance();
		BpaNasabahSrcCond cond = new BpaNasabahSrcCond();
		cond.setNoRekening(noRekening);
		nasabahDao.delete(con, cond);
		con.close();
	}

	public boolean checkRekeningExist(Connection con, String noRekening) throws SQLException{
		BpaNasabahTableDao nasabahDao = BpaNasabahTableDao.getInstance();
		BpaNasabahSrcCond cond = new BpaNasabahSrcCond();
		cond.setNoRekening(noRekening);
		List list = nasabahDao.executeQuery(con, cond);
		if(list.isEmpty()){
			return false;
		}
		return true;
	}
	
	public double getNasabahSaldo(Connection con, String rekeningNo) throws SQLException{
		if(rekeningNo == null){
			return 0;
		}
		BpaNasabahTableDao dao = BpaNasabahTableDao.getInstance();
		BpaNasabahSrcCond cond = new BpaNasabahSrcCond();
		cond.setNoRekening(rekeningNo);
		List<BpaNasabahTableRecord> recList = dao.executeQuery(con, cond);
		BpaNasabahTableRecord rec = recList.get(0);
		return rec.getSaldo().doubleValue();
	}
}
