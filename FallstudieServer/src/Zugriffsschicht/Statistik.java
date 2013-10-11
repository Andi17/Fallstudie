package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class Statistik {
	private JdbcAccess db;
	private int idStatistik;
	private int idOrgaEinheit;
	private int kalendarWoche;
	private int jahr;
	private int idStrichart;
	private int strichzahl;

	// Konstruktor wenn die Statistik schon existiert.
	public Statistik(ResultSet resultSet, JdbcAccess db) throws SQLException {
		werteSetzen(resultSet);
		this.db = db;
	}

	// Konstruktor bei Neuanlegen
	public Statistik(int idOrgaEinheit, int kalendarwoche, int jahr,
			int idStrichart, int strichanzahl, JdbcAccess db)
			throws SQLException {
		db.executeUpdateStatement("INSERT INTO Statistiken (idOrgaEinheit, " +
				"Kalendarwoche, Jahr, idStrichart, Strichzahl) " +
				"VALUES ( " + idOrgaEinheit + ", " + kalendarwoche + ", " + jahr +
				", " + idStrichart + ", " + strichanzahl + ")");
		ResultSet resultSet = db.executeQueryStatement("SELECT * FROM Statistiken WHERE " +
				"idOrgaEinheit = " + idOrgaEinheit + ", " +
				"Kalendarwoche = " + kalendarwoche + ", " +
				"Jahr = " + jahr + ", " +
				"idStrichart = " + idStrichart + ", " +
				"Strichzahl = " + strichanzahl);
		resultSet.next();
		werteSetzen(resultSet);
	}
	
	//Methode nur um Kurs zu sparen
	private void werteSetzen(ResultSet resultSet) throws SQLException{
		this.idStatistik = resultSet.getInt("idStatistik");
		this.idOrgaEinheit = resultSet.getInt("idOrgaEinheit");
		this.kalendarWoche = resultSet.getInt("KalendarWoche");
		this.jahr = resultSet.getInt("Jahr");
		this.idStrichart = resultSet.getInt("idStrichart");
		this.strichzahl = resultSet.getInt("Strichzahl");
	}

	public int getIDStatistik() {
		return idStatistik;
	}

	public int getOrgaEinheit() {
		return idOrgaEinheit;
	}

	public int getKalendarWoche() {
		return kalendarWoche;
	}

	public int getJahr() {
		return jahr;
	}

	public int getStrichart() {
		return idStrichart;
	}

	public int getStrichanzahl() {
		return strichzahl;
	}

}
