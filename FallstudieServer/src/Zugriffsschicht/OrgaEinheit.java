package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class OrgaEinheit {
	private JdbcAccess db;
	private int idOrgaEinheit;
	private int idUeberOrgaEinheit;
	private String OrgaEinheitBez;
	private String Leitername;
	private int idLeiterBerechtigung;
	private boolean Zustand;
	private int idMitarbeiterBerechtigung;


	public OrgaEinheit(ResultSet resultSet, JdbcAccess db) throws SQLException{
		werteSetzen(resultSet);
		this.db = db;
	}

	public OrgaEinheit(int idUeberOrgaEinheit, String OrgaEinheitBez, String Leitername,
			int idLeiterBerechtigung, boolean Zustand, int idMitarbeiterBerechtigung, JdbcAccess db) throws SQLException{
		db.executeUpdateStatement("INSERT INTO OrgaEinheit (" +
				"idUeberOrgaEinheit, OrgaEinheitBez, Leitername, idLeiterBerechtigung, Zustand, idMitarbeiterBerechtigung) " +
				"VALUES (" + idUeberOrgaEinheit + ", " + OrgaEinheitBez + ", " + Leitername +
				", " + idLeiterBerechtigung + ", " + Zustand +", " + idMitarbeiterBerechtigung +")");
		ResultSet resultSet = db.executeQueryStatement("SELECT * FROM OrgaEinheit WHERE " +
				"idUeberOrgaEinheit = " + idUeberOrgaEinheit +" AND "+
				"OrgaEinheitBez = " + OrgaEinheitBez +" AND "+
				"Leitername = " + Leitername +" AND "+
				"idLeiterBerechtigung = " + idLeiterBerechtigung +" AND "+
				"Zustand = " + Zustand +" AND "+
				"idMitarbeiterBerechtigung = " + idMitarbeiterBerechtigung +" AND ");
		resultSet.next();
		werteSetzen(resultSet);
		resultSet.close();
	}
	public void werteSetzen(ResultSet resultSet) throws SQLException{
		this.idOrgaEinheit = resultSet.getInt("idOrgaEinheit");
		this.idUeberOrgaEinheit = resultSet.getInt("idUeberOrgaEinheit");
		this.OrgaEinheitBez = resultSet.getString("OrgaEinheitBez");
		this.Leitername = resultSet.getString("Leitername");
		this.idLeiterBerechtigung = resultSet
				.getInt("idLeiterBerechtigung");
		this.Zustand = resultSet.getBoolean("Zustand");
		this.idMitarbeiterBerechtigung = resultSet.getInt("idMitarbeiterBerechtigung");
	}

	public int getIdOrgaEinheit() {
		return idOrgaEinheit;
	}

	public void setIdOrgaEinheit(int idOrgaEinheit) {
		this.idOrgaEinheit = idOrgaEinheit;
	}

	public int getIdUeberOrgaEinheit() {
		return idUeberOrgaEinheit;
	}

	public void setIdUeberOrgaEinheit(int idUeberOrgaEinheit) {
		this.idUeberOrgaEinheit = idUeberOrgaEinheit;
	}

	public String getOrgaEinheitBez() {
		return OrgaEinheitBez;
	}

	public void setOrgaEinheitBez(String orgaEinheitBez) {
		OrgaEinheitBez = orgaEinheitBez;
	}

	public String getLeitername() {
		return Leitername;
	}

	public void setLeitername(String leitername) {
		Leitername = leitername;
	}

	public int getIdLeiterBerechtigung() {
		return idLeiterBerechtigung;
	}

	public void setIdLeiterBerechtigung(int idLeiterBerechtigung) {
		this.idLeiterBerechtigung = idLeiterBerechtigung;
	}

	public boolean isZustand() {
		return Zustand;
	}

	public void setZustand(boolean zustand) {
		Zustand = zustand;
	}

	public int getIdMitarbeiterBerechtigung() {
		return idMitarbeiterBerechtigung;
	}

	public void setIdMitarbeiterBerechtigung(int idMitarbeiterBerechtigung) {
		this.idMitarbeiterBerechtigung = idMitarbeiterBerechtigung;
	}

}
