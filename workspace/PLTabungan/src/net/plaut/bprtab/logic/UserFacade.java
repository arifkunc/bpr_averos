package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;

import net.plaut.bprtab.object.AddUserDto;
import net.plaut.bprtab.object.UpdateUserDto;

public class UserFacade {
	private static UserFacade instance;

	private UserFacade(){
	}

	public static UserFacade getInstance(){
		if(instance == null){
			instance = new UserFacade(); 
		}
		return instance;
	}
	
	public void createNewUser(Connection con, AddUserDto dto) throws SQLException{
		UserLogic logic = UserLogic.getInstance();
		logic.insertUser(con, dto);
	}
	
	public void updateUser(Connection con, UpdateUserDto dto) throws SQLException{
		UserLogic logic = UserLogic.getInstance();
		logic.updateUser(con, dto);
	}
	
	public void deleteUser(Connection con, String username) throws SQLException{
		UserLogic logic = UserLogic.getInstance();
		logic.deleteUser(con, username);
	}
	
}
