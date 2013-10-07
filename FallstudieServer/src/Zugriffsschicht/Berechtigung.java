package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import jdbc.JdbcAccess;

public class Berechtigung {
	private JdbcAccess db;
	private int idBerechtigung;
	private String Berechtigungbez;

	public Berechtigung(JdbcAccess db) {
		this.db = db;
	}

	public Berechtigung(int idBerechtigung, JdbcAccess db) {
		this.db = db;
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM Berechtigung WHERE idBerechtigung = '"
							+ idBerechtigung + "'");
			resultSet.next();
			this.idBerechtigung = resultSet.getInt("idBerechtigung");
			this.Berechtigungbez = resultSet.getString("Berechtigungbez");
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public Berechtigung(int IdBerechtigung, String Bezeichnung, JdbcAccess db) {
		this.idBerechtigung = IdBerechtigung;
		this.Berechtigungbez = Bezeichnung;
		this.db = db;
	}

	public int getIdBerechtigung() {
		return idBerechtigung;
	}

	public void setIdBerechtigung(int idBerechtigung) {
		this.idBerechtigung = idBerechtigung;
	}

	public String getBezeichnung() {
		return Berechtigungbez;
	}

	public void setBezeichnung(String Berichtigungbez) {
		this.Berechtigungbez = Berechtigungbez;
	}

}
