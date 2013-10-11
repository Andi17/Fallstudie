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
			System.out.println(e);
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
			resultSet.next();
			rueckgabe = new Benutzer(resultSet, db);
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
				rueckgabe.add(new Benutzer(resultSet, db));
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
	public Berechtigung getBerechtigungzuLeitername(String Benutzername) {
		ResultSet resultSet;
		Berechtigung rueckgabe = null;
		try {
			resultSet = db
					.executeQueryStatement("SELECT b.* FROM OrgaEinheiten a, Berechtigung b WHERE"
							+ " a.idLeiterBerechtigung = b.idBerechtigung AND a.Leitername = '"
							+ Benutzername + "'");
			resultSet.next();
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
					.executeQueryStatement("SELECT b.* FROM OrgaEinheiten a, Berechtigung b, Benutzer c WHERE"
							+ " a.idMitarbeiterBerechtigung = b.idBerechtigung "
							+ "AND c.idOrgeEinheit = a.idOrgaEinheit "
							+ "AND c.Benutzername = '" + Benutzername + "'");
			resultSet.next();
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
					.executeQueryStatement("SELECT a.* FROM Berechtigung a, Berechtigung_Webmethode b "
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
					.executeQueryStatement("SELECT * FROM Berechtigung WHERE idBerechtigung = '"
							+ idBerechtigung + "'");
			resultSet.next();
			rueckgabe = new Berechtigung(resultSet, db);
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
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
			idLeiterBerechtigung, Zustand, idMitarbeiterBerechtigung, db);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return rueckgabe;
	}

	public OrgaEinheit getOrgaEinheitZuidOrgaEinheit(int idOrgaEinheit){
		ResultSet resultSet;
		OrgaEinheit rueckgabe = null;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM OrgaEinheit WHERE idOrgaEinheit = '"
							+ idOrgaEinheit + "'");
			resultSet.next();
			rueckgabe = new OrgaEinheit(resultSet, db);
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
					.executeQueryStatement("SELECT * FROM OrgaEinheit WHERE Leitername = '"
							+ Leitername + "'");
			resultSet.next();
			rueckgabe = new OrgaEinheit(resultSet, db);
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
