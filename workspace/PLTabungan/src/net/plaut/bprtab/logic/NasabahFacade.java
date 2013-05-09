package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;

import net.plaut.bprtab.object.AddNasabahDto;
import net.plaut.bprtab.object.UpdateNasabahDto;

public class NasabahFacade {
	private static NasabahFacade instance;

	private NasabahFacade(){
	}

	public static NasabahFacade getInstance(){
		if(instance == null){
			instance = new NasabahFacade(); 
		}
		return instance;
	}
	
	public void createNewNasabah(Connection con, AddNasabahDto dto) throws SQLException{
		NasabahLogic logic = NasabahLogic.getInstance();
		logic.insertNasabah(con, dto);
	}
	
	public void updateNasabah(Connection con, UpdateNasabahDto dto) throws SQLException{
		NasabahLogic logic = NasabahLogic.getInstance();
		logic.updateNasabah(con, dto);
	}
	
	public void deleteUser(Connection con, String noRekening) throws SQLException{
		NasabahLogic logic = NasabahLogic.getInstance();
		logic.deleteUser(con, noRekening);
	}
	
}
