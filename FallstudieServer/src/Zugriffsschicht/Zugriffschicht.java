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
	
	public Benutzer getBenutzer(int idBenutzer){
		return null;
	}
	
	public Benutzer benutzerErstellen(String Benutzer, String Passwort,
			OrgaEinheit orgranisationseinheit){
		return null;
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
	
	public List<Berechtigung> getBerechtigungzuIdBenutzer(int IdBenutzer) {
		ResultSet resultSet;
		List<Berechtigung> a = new ArrayList<Berechtigung>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM benutzer_berechtigung a, berechtigung b WHERE a.idBerechtigung = b.idBerechtigung AND a.idBenutzer = '"
							+ IdBenutzer + "'");
			while (resultSet.next()) {
				a.add(new Berechtigung(resultSet.getInt("idBerechtigung"),
						resultSet.getString("Berechtigungbez"), db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return a;
	}
	
	public List<Berechtigung> getBerechtigungzuIdWebservice(
			int IdWebservice) {
		ResultSet resultSet;
		List<Berechtigung> a = new ArrayList<Berechtigung>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT b.* FROM berechtigung_webservice a, berechtigung b WHERE a.idBerechtigung = b.idBerechtigung AND a.idWebservice = '"
							+ IdWebservice + "'");
			while (resultSet.next()) {
				a.add(new Berechtigung(resultSet.getInt("idBerechtigung"),
						resultSet.getString("Berechtigungbez"), db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return a;
	}
	
	public List<Benutzer> BenutzerListeAusgeben() {
		ResultSet resultSet;
		List<Benutzer> a = new ArrayList<Benutzer>();
		try {
			resultSet = db.executeQueryStatement("SELECT * FROM benutzer");
			while (resultSet.next()) {
				a.add(new Benutzer(resultSet.getInt("idBenutzer"), resultSet
						.getString("Benutzername"), resultSet
						.getString("Passwort"), resultSet.getInt("AktuelleOE"),
						db));
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
