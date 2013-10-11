package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import jdbc.JdbcAccess;

public class Benutzer {
	private JdbcAccess db;
	private String Benutzername;
	private String Passwort;
	private int AktuelleOE;
	private boolean Gesperrt;

	public Benutzer(JdbcAccess db) {
		this.db = db;
	}

	public Benutzer(ResultSet resultSet, JdbcAccess db) throws SQLException {
		this.db = db;
		werteSetzen(resultSet);
	}

	public Benutzer(String Benutzername, String Passwort, int aktuelleOE,
			boolean Gesperrt, JdbcAccess db) {
		this.db = db;
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.AktuelleOE = aktuelleOE;
		this.Gesperrt = Gesperrt;
	}
	private void werteSetzen(ResultSet resultSet) throws SQLException{
		this.Benutzername = resultSet.getString("Benutzername");
		this.Passwort = resultSet.getString("Passwort");
		this.AktuelleOE = resultSet.getInt("AktuelleOE");
		this.Gesperrt = resultSet.getBoolean("Gesperrt");
	}
	public String getBenutzername() {
		return Benutzername;
	}

	public String getPasswort() {
		return Passwort;
	}

	public int getAktuelleOE() {
		return AktuelleOE;
	}

	public boolean isGesperrt() {
		return Gesperrt;
	}

	public void setGesperrt(boolean gesperrt) {
		Gesperrt = gesperrt;
	}

	public void setBenutzername(String benutzername) {
		this.Benutzername = benutzername;
	}

	public void setPasswort(String passwort) {
		this.Passwort = passwort;
	}

	public void setAktuelleOE(int aktuelleOE) {
		this.AktuelleOE = aktuelleOE;
	}

	
}
