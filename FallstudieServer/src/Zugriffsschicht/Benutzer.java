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
	private int IdBenutzer;
	private String Benutzername;
	private String Passwort;
	private int AktuelleOE;

	public Benutzer(JdbcAccess db) {
		this.db = db;
	}

	public Benutzer(int idBenutzer, JdbcAccess db) {
		this.db = db;
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM benutzer WHERE idBenutzer = '"
							+ idBenutzer + "'");
			resultSet.next();
			this.IdBenutzer = resultSet.getInt("IdBenutzer");
			this.Benutzername = resultSet.getString("Benutzername");
			this.Passwort = resultSet.getString("Passwort");
			this.AktuelleOE = resultSet.getInt("AktuelleOE");
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public Benutzer(int idBenutzer, String Benutzername, String Passwort,
			int aktuelleOE, JdbcAccess db) {
		this.db = db;
		this.IdBenutzer = idBenutzer;
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.AktuelleOE = aktuelleOE;
	}

	public int getIdBenutzer() {
		return IdBenutzer;
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

	public void setIdBenutzer(int idBenutzer) {
		this.IdBenutzer = idBenutzer;
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

	public boolean writeBenutzerDB() {
		/*
		 * Aktuelles objekt in die Datenbank schreiben. wenn idBenutzer = null
		 * -> Insert wenn idBenutzer != null -> update
		 */
		return false;
	}

	public boolean getBenutzerfromBenutzername(String Benutzername) {
		/*
		 * benutzerdaten werden durch Benutzername ermittelt.
		 */
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM benutzer WHERE Benutzername = '"
							+ Benutzername + "'");
			resultSet.next();
			this.IdBenutzer = resultSet.getInt("IdBenutzer");
			this.Benutzername = resultSet.getString("Benutzername");
			this.Passwort = resultSet.getString("Passwort");
			this.AktuelleOE = resultSet.getInt("AktuelleOE");
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
