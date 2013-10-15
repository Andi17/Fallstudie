package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcAccess;

public class Zugriffschicht {

	private JdbcAccess db;

	public Zugriffschicht(JdbcAccess db) {
		this.db = db;
	}

	/*
	 * BENUTZER
	 */
	public Benutzer neuerBenutzerErstellen(String Benutzername,
			String Passwort, int idOrgaEinheit, boolean Gesperrt) {
		Benutzer rueckgabe = null;
		try {
			rueckgabe = new Benutzer(Benutzername, Passwort, idOrgaEinheit,
					Gesperrt, db);
		} catch (SQLException e) {
			System.out.println("Zugriffschicht: neuerBenutzerErstellen: "+e);
		}
		return rueckgabe;
	}
	public Benutzer getBenutzervonBenutzername(String Benutzername) {
		Benutzer rueckgabe = null;
		try {
			ResultSet resultSet;
			resultSet = db
					.executeQueryStatement("SELECT * FROM Benutzer WHERE Benutzername = '"
							+ Benutzername + "'");
			if(resultSet.next())
			rueckgabe = new Benutzer(resultSet, db, this);
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}



	public List<Benutzer> getAlleBenutzer() {
		ResultSet resultSet;
		List<Benutzer> rueckgabe = new ArrayList<Benutzer>();
		try {
			resultSet = db.executeQueryStatement("SELECT * FROM Benutzer");
			while (resultSet.next()) {
				rueckgabe.add(new Benutzer(resultSet, db, this));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return rueckgabe;
	}

	/*
	 * Statistik
	 */
	public Statistik neueStatistikErstellen(int idOrgaEinheit,
			int kalenderWoche, int jahr, int idStrichart, int strichanzahl) {
		Statistik rueckgabe = null;
		try {
			rueckgabe = new Statistik(idOrgaEinheit, kalenderWoche, jahr,
					idStrichart, strichanzahl, db);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}

	public List<Statistik> getStatistikzuOrgaEinheitinKWundJahr(int idOrgaEinheit,
			int kalenderWoche, int jahr) {
		ResultSet resultSet;
		List<Statistik> rueckgabe = new ArrayList<Statistik>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM Statistik WHERE idOrgaEinheit = '"
							+ idOrgaEinheit
							+ "' AND KalenderWoche = '"
							+ kalenderWoche + "' AND Jahr = '" + jahr + "'");
			while (resultSet.next()) {
				rueckgabe.add(new Statistik(resultSet, db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return rueckgabe;
	}

	/*
	 * Berechtigung
	 */
	public List<Berechtigung> getAlleBerechtigungen(){
		return null;
	}
	
	public Berechtigung getBerechtigungzuLeitername(String Benutzername) {
		ResultSet resultSet;
		Berechtigung rueckgabe = null;
		try {
			resultSet = db
					.executeQueryStatement("SELECT b.* FROM OrgaEinheiten a, Berechtigungen b WHERE"
							+ " a.idLeiterBerechtigung = b.idBerechtigung AND a.Leitername = '"
							+ Benutzername + "'");
			if(resultSet.next())
			rueckgabe = new Berechtigung(resultSet, db);
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}

	public Berechtigung getBerechtigungzuMitarbeiter(String Benutzername) {
		ResultSet resultSet;
		Berechtigung rueckgabe = null;
		try {
			resultSet = db
					.executeQueryStatement("SELECT b.* FROM Berechtigungen b, OrgaEinheiten c, Benutzer a WHERE b.idBerechtigung = c.idMitarbeiterBerechtigung AND c.idOrgaEinheit = a.idOrgaEinheit AND a.Benutzername = '" + Benutzername+ "'");
			if(resultSet.next())
			rueckgabe = new Berechtigung(resultSet, db);
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}

	public List<Berechtigung> getBerechtigungenZuWebmethode(int Webmethode) {
		ResultSet resultSet;
		List<Berechtigung> rueckgabe = new ArrayList<Berechtigung>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT a.* FROM Berechtigungen a, Berechtigung_Webmethode b "
							+ "WHERE a.idBerechtigung = b.idBerechtigung AND b.idWebmethode = '"
							+ Webmethode + "'");
			while (resultSet.next()) {
				rueckgabe.add(new Berechtigung(resultSet, db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return rueckgabe;
	}

	public Berechtigung getBerechtigungzuidBerechtigung(int idBerechtigung) {
		Berechtigung rueckgabe = null;
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM Berechtigungen WHERE idBerechtigung = '"
							+ idBerechtigung + "'");
			if(resultSet.next())
			rueckgabe = new Berechtigung(resultSet, db);
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Zugriffschicht/getBerechtigungzuidBerechtigung :"+e);
		}
		return rueckgabe;
	}
	
	/*
	 * ORGAEINHEIT
	 */
	
	public OrgaEinheit erstelleOrgaEinheit(int idUeberOrgaEinheit, String OrgaEinheitBez, String Leitername,
			int idLeiterBerechtigung, boolean Zustand, int idMitarbeiterBerechtigung){
		OrgaEinheit rueckgabe = null;
		try {
			rueckgabe = new OrgaEinheit(idUeberOrgaEinheit, OrgaEinheitBez, Leitername,
			idLeiterBerechtigung, Zustand, idMitarbeiterBerechtigung, db, this);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}
	
	public OrgaEinheit getOrgaEinheitvonBezeichnung(String bezeichnung){
		OrgaEinheit rueckgabe = null;
		try {
			ResultSet resultSet = db.executeQueryStatement("SELECT * FROM OrgaEinheiten WHERE OrgaEinheitBez = '" + bezeichnung + "'");

			if(resultSet.next())
				rueckgabe = new OrgaEinheit(resultSet, db, this);
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rueckgabe;
	}
	
	public List<OrgaEinheit> getOrgaEinheiten(){
		ResultSet resultSet;
		List<OrgaEinheit> rueckgabe = new ArrayList<OrgaEinheit>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM OrgaEinheiten ORDER BY OrgaEinheitBez");
			while(resultSet.next()){
			rueckgabe.add(new OrgaEinheit(resultSet, db, this));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}
	public OrgaEinheit getOrgaEinheitZuidOrgaEinheit(int idOrgaEinheit){
		ResultSet resultSet;
		OrgaEinheit rueckgabe = null;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM OrgaEinheiten WHERE idOrgaEinheit = '"
							+ idOrgaEinheit + "'");
			if(resultSet.next())
			rueckgabe = new OrgaEinheit(resultSet, db, this);
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}
	public OrgaEinheit getOrgaEinheitZuLeitername(String Leitername) {
		OrgaEinheit rueckgabe = null;
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM OrgaEinheiten WHERE Leitername = '"
							+ Leitername + "'");
			if(resultSet.next())
			rueckgabe = new OrgaEinheit(resultSet, db, this);
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);

		}
		return rueckgabe;
	}
	
	/*
	 * Strichart
	 */
	public List<Strichart> getAlleMoeglichenStricharten() {
		ResultSet resultSet;
		List<Strichart> listeStricharten = new ArrayList<Strichart>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM Stricharten WHERE Zustand = true");
			while (resultSet.next()) {
				listeStricharten.add(new Strichart(resultSet, db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return listeStricharten;
	}
	public List<Strichart> getAlleStricharten() {
		ResultSet resultSet;
		List<Strichart> listeStricharten = new ArrayList<Strichart>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM Stricharten");
			while (resultSet.next()) {
				listeStricharten.add(new Strichart(resultSet, db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return listeStricharten;
	}

	

	

	public void disconnect() throws SQLException {
		db.disconnect();
	}

}
