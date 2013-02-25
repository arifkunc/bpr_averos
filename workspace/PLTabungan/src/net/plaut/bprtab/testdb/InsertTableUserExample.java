package net.plaut.bprtab.testdb;

import java.sql.Connection;
import java.sql.SQLException;

import net.plaut.bprtab.constant.DbConstant;
import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.util.SystemInformation;
import net.plaut.dbutil.db.DbConnection;

public class InsertTableUserExample {
	public static void main(String []args){
		Connection con;
		try {
			/*
			 Buat objek koneksi database
			 */
			con = DbConnection.createConnection(SystemInformation.getConnectionInformation());
			
			/*
			buat objek dao, contohnya BpaUserTableDao. Kelas ini yang bertugas untuk 
			operasi database select, insert, update, dan delete.
			Setiap pengoperasian database selalu memakai kelas ini.
			Untuk satu tabel di database mempunyai satu kelas dao.
			Setiap kelas dao seperti BpaUserTableDao merupakan turunan dari kelas TableDao.
			*/
			BpaUserTableDao dao = new BpaUserTableDao();
			
			/*
			 Kelas record adalah kelas yang menampung data satu record dari database.
			 atribut di kelas record menyatakan field di tabel database.
			 Setiap kelas record seperti BpaUserTableRecord merupakan turunan dari kelas TableRecord.
			 */
			BpaUserTableRecord record = new BpaUserTableRecord();
			
			/*
			 set nilai yg mau diinsert
			 */
			record.setUsername("arifganteng4");
			record.setPassword("pangaruh");
			record.setGroup(DbConstant.USER_GROUP_SUPER_ADMIN);
			
			/*
			 lakukan insert
			 */
			dao.insert(con, record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
