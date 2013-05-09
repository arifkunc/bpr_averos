package net.plaut.bprtab.testdb;

import java.sql.Connection;
import java.sql.SQLException;

import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.bprtab.util.DbCommand;
import net.plaut.bprtab.util.SystemInformation;
import net.plaut.dbutil.db.DbConnection;

public class DeleteTableUserExample {
	
	public static void main(String []args){
		Connection con;
		try {
			/*
			 Buat objek koneksi database
			 */
			con = DbCommand.getConnection();
			
			/*
			buat objek dao, contohnya BpaUserTableDao. Kelas ini yang bertugas untuk 
			operasi database select, insert, update, dan delete.
			Setiap pengoperasian database selalu memakai kelas ini.
			Untuk satu tabel di database mempunyai satu kelas dao.
			Setiap kelas dao seperti BpaUserTableDao merupakan turunan dari kelas TableDao.
			*/
			BpaUserTableDao dao = BpaUserTableDao.getInstance();
			
			/*
			 buat objek delete condition, contohnya BpaUserDelCond.
			 Kelas ini bertugas sebagai penyimpan informasi kondisi delete,
			 untuk pembuatan where xxx di update SQL String
			 seperti contoh di bawah ini sama seperti where username='arifganteng4'
			 */
			BpaUserSrcCond deleteCondition = new BpaUserSrcCond();
			deleteCondition.setUsername("arifganteng4");
			
			/*
			 lakukan delete
			 */
			dao.delete(con, deleteCondition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
