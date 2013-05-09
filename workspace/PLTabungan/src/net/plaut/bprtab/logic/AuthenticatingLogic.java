package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import net.plaut.bprtab.dao.BpaUserGroupTableDao;
import net.plaut.bprtab.dao.BpaUserGroupTableRecord;
import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.dao.condition.BpaUserGroupSrcCond;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.bprtab.util.LoginInformation;

public class AuthenticatingLogic {
	private static AuthenticatingLogic instance;

	private AuthenticatingLogic() {
	}

	public static AuthenticatingLogic getInstance() {
		if (instance == null) {
			instance = new AuthenticatingLogic();
		}
		return instance;
	}
	
	public int login(Connection con, String username, String password) throws SQLException{
		BpaUserTableDao uDao = BpaUserTableDao.getInstance();
		BpaUserSrcCond srcCond = new BpaUserSrcCond();
		srcCond.setUsername(username);
		srcCond.setPassword(password);
		ArrayList<BpaUserTableRecord> list;
		list = uDao.executeQuery(con, srcCond);
		if (list.size() == 1) {
			// login success
			BpaUserGroupTableDao guDao = BpaUserGroupTableDao.getInstance();
			BpaUserGroupSrcCond userGroupCond = new BpaUserGroupSrcCond();
			userGroupCond.setId(list.get(0).getGroupId());
			ArrayList<BpaUserGroupTableRecord> ugList = guDao.executeQuery(con, userGroupCond);
			String groupId = ugList.get(0).getId();
			LoginInformation loginInfo = LoginInformation.getInstance();
			loginInfo.setLogin(true);
			loginInfo.setUsername(username);
			loginInfo.setPassword(password);
			loginInfo.setUserGroup(groupId);
			return 1;
		} else {
			return 0;
		}
	}
}
