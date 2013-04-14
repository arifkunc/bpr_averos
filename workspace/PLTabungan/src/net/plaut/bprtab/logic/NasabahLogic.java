package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.plaut.bprtab.dao.BpaNasabahTableDao;
import net.plaut.bprtab.dao.BpaNasabahTableRecord;
import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.dao.condition.BpaNasabahSrcCond;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.bprtab.object.AddNasabahDto;
import net.plaut.bprtab.object.AddUserDto;
import net.plaut.bprtab.object.UpdateNasabahDto;
import net.plaut.bprtab.object.UpdateUserDto;
import net.plaut.bprtab.util.DbCommand;
import net.plaut.bprtab.util.SystemInformation;
import net.plaut.common.util.DateUtil;
import net.plaut.dbutil.db.DbConnection;

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

	public void addNasabah(AddNasabahDto dto) throws SQLException{
		Connection con = DbCommand.getConnection();

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
		
		BpaNasabahTableDao nasabahDao = new BpaNasabahTableDao();
		nasabahDao.insert(con, record);
		con.close();
	}
	
	public void updateNasabah(UpdateNasabahDto dto) throws SQLException{
		Connection con = DbCommand.getConnection();

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
		
		BpaNasabahTableDao nasabahDao = new BpaNasabahTableDao();
		BpaNasabahSrcCond cond = new BpaNasabahSrcCond();
		cond.setNoRekening(dto.getOldNoRekening());
		nasabahDao.update(con, record, cond);
		con.close();
	}
	
	public void deleteUser(String noRekening) throws SQLException{
		Connection con = DbCommand.getConnection();

		BpaNasabahTableDao nasabahDao = new BpaNasabahTableDao();
		BpaNasabahSrcCond cond = new BpaNasabahSrcCond();
		cond.setNoRekening(noRekening);
		nasabahDao.delete(con, cond);
		con.close();
	}

	public boolean checkNoRekeningExist(String noRekening) throws SQLException{
		Connection con = DbCommand.getConnection();
		BpaNasabahTableDao nasabahDao = new BpaNasabahTableDao();
		BpaNasabahSrcCond cond = new BpaNasabahSrcCond();
		cond.setNoRekening(noRekening);
		List list = nasabahDao.executeQuery(con, cond);
		if(list.isEmpty()){
			return false;
		}
		return true;
	}
}
