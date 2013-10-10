package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class OrgaEinheit {
	private JdbcAccess db;
	private int idOrgaEinheit;
	private int idUeberOrgaEinheit;
	private String OrgaEinheitBez;
	private int idLeiter;
	private int idLeiterBerechtigung;
	private int Zustand;
	private int idMitarbeiterBerechtigung;

	public OrgaEinheit(JdbcAccess db) {
		this.db = db;
	}

	public OrgaEinheit(int idOE, JdbcAccess db) {
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM oe WHERE idOE = '"
							+ idOE + "'");
			resultSet.next();
			this.idOrgaEinheit = resultSet.getInt("idOE");
			this.idUeberOrgaEinheit = resultSet.getInt("idUeberOE");
			this.OrgaEinheitBez = resultSet.getString("OEbez");
			this.idLeiter = resultSet.getInt("idInhaber");
			this.idLeiterBerechtigung = resultSet
					.getInt("idInhaberberechtigung");
			this.Zustand = resultSet.getInt("Zustand");
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		this.db = db;
	}

	public OrgaEinheit(int idOE, int idUeberOE, String OEbez, int idInhaber,
			int idInhaberberechtigung, int zustand, JdbcAccess db) {

		this.idOrgaEinheit = idOE;
		this.idUeberOrgaEinheit = idUeberOE;
		this.OrgaEinheitBez = OEbez;
		this.idLeiter = idInhaber;
		this.idLeiterBerechtigung = idInhaberberechtigung;
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
			this.idOrgaEinheit = resultSet.getInt("idOE");
			this.idUeberOrgaEinheit = resultSet.getInt("idUeberOE");
			this.OrgaEinheitBez = resultSet.getString("OEbez");
			this.idLeiter = resultSet.getInt("idInhaber");
			this.idLeiterBerechtigung = resultSet
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
		return idOrgaEinheit;
	}

	public int getUeberOE() {
		return idUeberOrgaEinheit;
	}

	public String getOEBezeichnung() {
		return OrgaEinheitBez;
	}

	public int getInhaber() {
		return idLeiter;
	}

	public int getInhaberberechtigung() {
		return idLeiterBerechtigung;
	}

	public int getZustand() {
		return Zustand;
	}

	public int setIDOE() {
		return this.idOrgaEinheit;
	}

	public int setUeberOE() {
		return this.idUeberOrgaEinheit;
	}

	public String setOEBezeichnung() {
		return this.OrgaEinheitBez;
	}

	public int setInhaber() {
		return this.idLeiter;
	}

	public int setInhaberberechtigung() {
		return this.idLeiterBerechtigung;
	}

	public int setZustand() {
		return this.Zustand;
	}
}
