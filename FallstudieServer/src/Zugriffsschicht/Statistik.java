package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class Statistik {
	private JdbcAccess db;
	private int idStatistik;
	private int idOE;
	private int KW;
	private int Jahr;
	private int idStrichart;
	private int Strichzahl;

	public Statistik(int idStatistik, int idOE, int KW, int Jahr,
			int idStrichart, int Strichwert, JdbcAccess db) {
		this.idStatistik = idStatistik;
		this.idOE = idOE;
		this.KW = KW;
		this.Jahr = Jahr;
		this.idStrichart = idStrichart;
		this.Strichzahl = Strichwert;
		this.db = db;
	}

	public Statistik(JdbcAccess db) {
		this.db = db;
	}

	public boolean getStatistikfromidStatistik(int idStatistik, JdbcAccess db) {
		/*
		 * Statistikdaten werden durch Identifikationsnummer idStatistik
		 * ermittelt.
		 */
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM Statistik WHERE idStatistik = '"
							+ idStatistik + "'");
			resultSet.next();
			this.idStatistik = resultSet.getInt("idStatistik");
			this.idOE = resultSet.getInt("idOE");
			this.KW = resultSet.getInt("KW");
			this.Jahr = resultSet.getInt("Jahr");
			this.idStrichart = resultSet.getInt("idStrichart");
			this.Strichzahl = resultSet.getInt("Strichwert");
			resultSet.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public int getIDStatistik() {
		return idStatistik;
	}

	public int getIDOEt() {
		return idOE;
	}

	public int getKW() {
		return KW;
	}

	public int getJahr() {
		return Jahr;
	}

	public int getIDStrichart() {
		return idStrichart;
	}

	public int getStrichwert() {
		return Strichzahl;
	}

	public int setIDStatistik() {
		return this.idStatistik;
	}

	public int setIDOE() {
		return this.idOE;
	}

	public int setKW() {
		return this.KW;
	}

	public int setJahr() {
		return this.Jahr;
	}

	public int setIDStrichart() {
		return this.idStrichart;
	}

	public int setStrichwert() {
		return this.Strichzahl;
	}
}
