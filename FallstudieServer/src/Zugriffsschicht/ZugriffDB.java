package Zugriffsschicht;

import java.sql.SQLException;

import Optionen.Optionen;

import jdbc.JdbcAccess;

public class ZugriffDB {

	private JdbcAccess db;

	public JdbcAccess getDb() {
		return db;
	}

	public void CheckAccess() {
		if (db == null) {
			Accessanlegen();
		}
		try {
			db.connect();
		} catch (SQLException e) {
		}
	}

	private void Accessanlegen() {
		try {
			db = new JdbcAccess(Optionen.getJdbcurl(), Optionen.getJdbcuser(),
					Optionen.getJdbcpw());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
}
