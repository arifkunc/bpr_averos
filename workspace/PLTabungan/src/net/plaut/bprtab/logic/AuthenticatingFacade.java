package net.plaut.bprtab.logic;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthenticatingFacade {
	private static AuthenticatingFacade instance;

	private AuthenticatingFacade() {
	}

	public static AuthenticatingFacade getInstance() {
		if (instance == null) {
			instance = new AuthenticatingFacade();
		}
		return instance;
	}
	
	public int login(Connection con, String username, String password) throws SQLException{
		AuthenticatingLogic logic = AuthenticatingLogic.getInstance();
		return logic.login(con, username, password);
	}
}
