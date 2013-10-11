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
	private int idOrgaEinheit;
	private boolean Gesperrt;

	public Benutzer(ResultSet resultSet, JdbcAccess db) throws SQLException {
		this.db = db;
		werteSetzen(resultSet);
	}

	public Benutzer(String Benutzername, String Passwort, int idOrgaEinheit,
			boolean Gesperrt, JdbcAccess db) throws SQLException{
		db.executeUpdateStatement("INSERT INTO Benutzer (Benutzername, " +
				"Passwort, idOrgaEinheit, Gesperrt) " +
				"VALUES ( " + Benutzername + ", " + Passwort + ", " + idOrgaEinheit +
				", " + Gesperrt + ")");
		ResultSet resultSet = db.executeQueryStatement("SELECT * FROM Benutzer WHERE " +
				"Benutzername = " + Benutzername);
		resultSet.next();
		werteSetzen(resultSet);
		resultSet.close();
	}
	private void werteSetzen(ResultSet resultSet) throws SQLException{
		this.Benutzername = resultSet.getString("Benutzername");
		this.Passwort = resultSet.getString("Passwort");
		this.idOrgaEinheit = resultSet.getInt("AktuelleOE");
		this.Gesperrt = resultSet.getBoolean("Gesperrt");
	}
	public String getBenutzername() {
		return Benutzername;
	}

	public String getPasswort() {
		return Passwort;
	}

	public int getAktuelleOE() {
		return idOrgaEinheit;
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
		this.idOrgaEinheit = aktuelleOE;
	}

	
}
