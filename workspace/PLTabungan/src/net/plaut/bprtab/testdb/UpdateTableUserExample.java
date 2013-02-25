package net.plaut.bprtab.testdb;

import java.sql.Connection;
import java.sql.SQLException;

import net.plaut.bprtab.constant.DbConstant;
import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.bprtab.util.SystemInformation;
import net.plaut.dbutil.db.DbConnection;

public class UpdateTableUserExample {
	
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
			 buat objek update condition, contohnya BpaUserUpdCond.
			 Kelas ini bertugas sebagai penyimpan informasi kondisi update,
			 untuk pembuatan where xxx di update SQL String
			 seperti contoh di bawah ini sama seperti where username='arifganteng4'
			 */
			BpaUserSrcCond updateCondition = new BpaUserSrcCond();
			updateCondition.setUsername("arifganteng4");
			
			/*
			 Kelas record adalah kelas yang menampung data satu record dari database.
			 atribut di kelas record menyatakan field di tabel database.
			 Setiap kelas record seperti BpaUserTableRecord merupakan turunan dari kelas TableRecord.
			 */
			BpaUserTableRecord updateRecord = new BpaUserTableRecord();
			
			/*
			 set nilai yg mau diinsert
			 */
			updateRecord.setPassword("taralaku");
			updateRecord.setGroup(DbConstant.USER_GROUP_TELLER);
			
			/*
			 lakukan update
			 */
			dao.update(con, updateRecord, updateCondition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
