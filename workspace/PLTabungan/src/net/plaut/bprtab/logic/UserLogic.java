package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.bprtab.object.AddUserDto;
import net.plaut.bprtab.object.UpdateUserDto;
import net.plaut.bprtab.util.DbCommand;

public class UserLogic {

	private static UserLogic instance;

	private UserLogic(){
	}

	public static UserLogic getInstance(){
		if(instance == null){
			instance = new UserLogic(); 
		}
		return instance;
	}

	public void insertUser(Connection con, AddUserDto dto) throws SQLException{
		BpaUserTableRecord record = new BpaUserTableRecord();
		record.setUsername(dto.getUsername());
		record.setPassword(dto.getPassword());
		record.setGroupId(dto.getGroupLevelId());
		BpaUserTableDao userDao = BpaUserTableDao.getInstance();
		userDao.insert(con, record);
		con.close();
	}
	
	public void updateUser(Connection con, UpdateUserDto dto) throws SQLException{
		BpaUserTableRecord record = new BpaUserTableRecord();
		record.setUsername(dto.getUsername());
		record.setPassword(dto.getPassword());
		record.setGroupId(dto.getGroupLevelId());
		BpaUserTableDao userDao = BpaUserTableDao.getInstance();
		BpaUserSrcCond cond = new BpaUserSrcCond();
		cond.setUsername(dto.getOldUsername());
		userDao.update(con, record, cond);
		con.close();
	}
	
	public void deleteUser(Connection con, String username) throws SQLException{
		BpaUserTableDao userDao = BpaUserTableDao.getInstance();
		BpaUserSrcCond cond = new BpaUserSrcCond();
		cond.setUsername(username);
		userDao.delete(con, cond);
		con.close();
	}

	public boolean checkUserExist(Connection con, String username) throws SQLException{
		BpaUserTableDao userDao = BpaUserTableDao.getInstance();
		BpaUserSrcCond cond = new BpaUserSrcCond();
		cond.setUsername(username);
		List list = userDao.executeQuery(con, cond);
		if(list.isEmpty()){
			return false;
		}
		return true;
	}
}
