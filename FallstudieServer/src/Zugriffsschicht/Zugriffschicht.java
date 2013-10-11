package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcAccess;

public class Zugriffschicht{
	
	private JdbcAccess db;
	
	public Zugriffschicht(JdbcAccess db){
		this.db = db;
	}
	/*
	 *                BENUTZER
	 */
	public Benutzer getBenutzer(){
		return new Benutzer(db);
	}
	public Benutzer getBenutzervonBenutzername(String Benutzername){
		Benutzer rueckgabe = null;
		try{
			ResultSet resultSet;
			resultSet = db
					.executeQueryStatement("SELECT * FROM Benutzer WHERE Benutzername = '"
							+ Benutzername + "'");
			resultSet.next();
			rueckgabe = new Benutzer(resultSet, db);
			resultSet.close();
		}
		catch(SQLException e){
		}
		return rueckgabe;
	}
	
	public Benutzer neuerbenutzerErstellen(String Benutzername, String Passwort,
			int idOrgaEinheit, boolean Gesperrt){
		Benutzer rueckgabe = null;
		rueckgabe = new Benutzer(Benutzername,Passwort,idOrgaEinheit,Gesperrt,db);
		if(rueckgabe.writeBenutzerDB()){
			return rueckgabe;
		}
		else{
			return null;
		}
	}
	public List<Benutzer> AlleBenutzerListeAusgeben() {
		ResultSet resultSet;
		List<Benutzer> rueckgabe = new ArrayList<Benutzer>();
		try {
			resultSet = db.executeQueryStatement("SELECT * FROM Benutzer");
			while (resultSet.next()) {
				rueckgabe.add(new Benutzer(resultSet, db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return rueckgabe;
	}
	
	public List<String> getAlleMoeglichenStricharten() {
		ResultSet resultSet;
		List<String> listeStricharten = new ArrayList<String>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM strichbezeichnung WHERE Zustand = true");
			while (resultSet.next()) {
				listeStricharten.add(resultSet.getString("Strichbezeichnung"));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return listeStricharten;
	}
	
	/*
	 * Berechtigung
	 */
	public Berechtigung getBerechtigungzuidBerechtigung(int idBerechtigung){
		Berechtigung rueckgabe = null;
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM Berechtigung WHERE idBerechtigung = '"
							+ idBerechtigung + "'");
			resultSet.next();
			rueckgabe = new Berechtigung(resultSet, db);
			resultSet.close();
		}
		catch(SQLException e){
			
		}
		return rueckgabe;
	}
	
	public List<Berechtigung> getBerechtigungzuLeitername(Benutzer Leiter) {
		ResultSet resultSet;
		List<Berechtigung> a = new ArrayList<Berechtigung>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT b.* FROM OrgaEinheiten a, Berechtigung b WHERE a.idLeiterBerechtigung = b.idBerechtigung AND a.Leitername = '"
							+ Leiter.getBenutzername() + "'");
			while (resultSet.next()) {
				a.add(new Berechtigung(resultSet, db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return a;
	}
	
	public List<Berechtigung> getBerechtigungzuIdWebservice(int IdWebservice) {
		ResultSet resultSet;
		List<Berechtigung> a = new ArrayList<Berechtigung>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT b.* FROM Berechtigung_Webmethode a, Berechtigung b WHERE a.idBerechtigung = b.idBerechtigung AND a.idWebmethode = '"
							+ IdWebservice + "'");
			while (resultSet.next()) {
				a.add(new Berechtigung(resultSet, db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return a;
	}
	

	
	public List<OrgaEinheit> getOEzuInhaber(int IdInhaber) {
		/*
		 * Organisationseinheitsdaten werden durch Identifikationsnummer idOE
		 * ermittelt.
		 */
		List<OrgaEinheit> ret = new ArrayList<OrgaEinheit>();
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM oe WHERE idInhaber = '"
							+ IdInhaber + "'");
			while (resultSet.next()) {
				ret.add(new OrgaEinheit(resultSet.getInt("idOE"), resultSet
						.getInt("idUeberOE"), resultSet.getString("OEbez"),
						resultSet.getInt("idInhaber"), resultSet
								.getInt("idInhaberberechtigung"), resultSet
								.getInt("Zustand"), db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return ret;
	}
	
	public void disconnect() throws SQLException{
		db.disconnect();
	}

}
