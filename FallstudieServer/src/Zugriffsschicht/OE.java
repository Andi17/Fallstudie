package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class OE {
	private JdbcAccess db;
	private int idOE;
	private int idUeberOE;
	private String OEbez;
	private int idInhaber;
	private int idInhaberberechtigung;
	private int Zustand;

	public OE(JdbcAccess db) {
		this.db = db;
	}
	/*
	 * Komentar zum überprüfen von github
	 */

	public OE(int idOE, JdbcAccess db) {
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM oe WHERE idOE = '"
							+ idOE + "'");
			resultSet.next();
			this.idOE = resultSet.getInt("idOE");
			this.idUeberOE = resultSet.getInt("idUeberOE");
			this.OEbez = resultSet.getString("OEbez");
			this.idInhaber = resultSet.getInt("idInhaber");
			this.idInhaberberechtigung = resultSet
					.getInt("idInhaberberechtigung");
			this.Zustand = resultSet.getInt("Zustand");
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		this.db = db;
	}

	public OE(int idOE, int idUeberOE, String OEbez, int idInhaber,
			int idInhaberberechtigung, int zustand, JdbcAccess db) {

		this.idOE = idOE;
		this.idUeberOE = idUeberOE;
		this.OEbez = OEbez;
		this.idInhaber = idInhaber;
		this.idInhaberberechtigung = idInhaberberechtigung;
		this.Zustand = zustand;
		this.db = db;
	}

	public boolean getOEfromInhaber(int IdInhaber) {
		/*
		 * Organisationseinheitsdaten werden durch Identifikationsnummer idOE
		 * ermittelt.
		 */
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM oe WHERE idInhaber = '"
							+ IdInhaber + "'");
			resultSet.next();
			this.idOE = resultSet.getInt("idOE");
			this.idUeberOE = resultSet.getInt("idUeberOE");
			this.OEbez = resultSet.getString("OEbez");
			this.idInhaber = resultSet.getInt("idInhaber");
			this.idInhaberberechtigung = resultSet
					.getInt("idInhaberberechtigung");
			this.Zustand = resultSet.getInt("Zustand");
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public int getIDOE() {
		return idOE;
	}

	public int getUeberOE() {
		return idUeberOE;
	}

	public String getOEBezeichnung() {
		return OEbez;
	}

	public int getInhaber() {
		return idInhaber;
	}

	public int getInhaberberechtigung() {
		return idInhaberberechtigung;
	}

	public int getZustand() {
		return Zustand;
	}

	public int setIDOE() {
		return this.idOE;
	}

	public int setUeberOE() {
		return this.idUeberOE;
	}

	public String setOEBezeichnung() {
		return this.OEbez;
	}

	public int setInhaber() {
		return this.idInhaber;
	}

	public int setInhaberberechtigung() {
		return this.idInhaberberechtigung;
	}

	public int setZustand() {
		return this.Zustand;
	}
}
