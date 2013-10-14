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
	private Zugriffschicht dbZugriff;
	private String Benutzername;
	private String Passwort;
	private int idOrgaEinheit;
	private boolean Gesperrt;

	public Benutzer(ResultSet resultSet, JdbcAccess db, Zugriffschicht dbZugriff) throws SQLException {
		this.db = db;
		this.dbZugriff = dbZugriff;
		werteSetzen(resultSet);
	}

	public Benutzer(String Benutzername, String Passwort, int idOrgaEinheit,
			boolean Gesperrt, JdbcAccess db) throws SQLException{
		String GesperrtString = "1";
		if (Gesperrt){
			GesperrtString = "0";
		}
		db.executeUpdateStatement("INSERT INTO Benutzer (Benutzername, " +
				"Passwort, idOrgaEinheit, Gesperrt) " +
				"VALUES ( '" + Benutzername + "', '" + Passwort + "', '" + idOrgaEinheit +
				"', '" + GesperrtString + "')");
		ResultSet resultSet = db.executeQueryStatement("SELECT * FROM Benutzer WHERE " +
				"Benutzername = '" + Benutzername+"'");
		resultSet.next();
		werteSetzen(resultSet);
		resultSet.close();
	}
	private void werteSetzen(ResultSet resultSet) throws SQLException{
		this.Benutzername = resultSet.getString("Benutzername");
		this.Passwort = resultSet.getString("Passwort");
		this.idOrgaEinheit = resultSet.getInt("idOrgaEinheit");
		this.Gesperrt = resultSet.getBoolean("Gesperrt");
	}
	
	public String getOrgaEinheitBezeichnung(){
		OrgaEinheit orgaEinheit = dbZugriff.getOrgaEinheitZuidOrgaEinheit(this.idOrgaEinheit);
		if(orgaEinheit!=null)return orgaEinheit.getOrgaEinheitBez();
		else return "Keine Organisationseinheit";
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

	public boolean getGesperrt() {
		return Gesperrt;
	}

	public void setGesperrt(boolean gesperrt) {
		Gesperrt = gesperrt;
	}

	public void setBenutzername(String benutzername) throws SQLException{

		db.executeUpdateStatement("UPDATE Benutzer SET Benutzername = '" + benutzername+"' WHERE Benutzername = '"+Benutzername+"'");
		this.Benutzername = benutzername;

	}

	public void setPasswort(String passwort) throws SQLException{
		db.executeUpdateStatement("UPDATE Benutzer SET Passwort = '" + passwort+"' WHERE Benutzername = '"+Benutzername+"'");
		this.Passwort = passwort;
	}

	public void setidOrgaEinheit(int aktuelleOE) throws SQLException{
		db.executeUpdateStatement("UPDATE Benutzer SET idOrgaEinheit = '" + aktuelleOE+"' WHERE Benutzername = '"+Benutzername+"'");
		this.idOrgaEinheit = aktuelleOE;
	}

	public void loeschen() throws SQLException {
		db.executeUpdateStatement("DELETE FROM Benutzer WHERE Benutzername = '"+Benutzername+"'");
		
	}

	
}
