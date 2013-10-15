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

	public Berechtigung(ResultSet resultSet, JdbcAccess db) throws SQLException {
		werteSetzen(resultSet);
		this.db = db;
	}
	/*
	public Berechtigung(int idBerechtigung, String Berechtigungbez, JdbcAccess db) throws SQLException{
		//TODO?
		//einfügen von berechtigungen noch unnötig
	}*/
	
	
	public void werteSetzen(ResultSet resultSet) throws SQLException{
		this.idBerechtigung = resultSet.getInt("idBerechtigung");
		this.Berechtigungbez = resultSet.getString("Berechtigungbez");
	}

	public int getIdBerechtigung() {
		return idBerechtigung;
	}

	public void setIdBerechtigung(int idBerechtigung) {
		this.idBerechtigung = idBerechtigung;
	}

	public String getBerechtigungbez() {
		return Berechtigungbez;
	}

	public void setBerechtigungbez(String berechtigungbez) {
		Berechtigungbez = berechtigungbez;
	}

}
