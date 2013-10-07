package Zugriffsschicht;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import jdbc.JdbcAccess;

public class BerechtigungListe {
	private JdbcAccess db;

	public BerechtigungListe(JdbcAccess db) {
		this.db = db;
	}

	public Collection<Berechtigung> getBerechtigungzuIdBenutzer(int IdBenutzer) {
		ResultSet resultSet;
		LinkedList<Berechtigung> a = new LinkedList<Berechtigung>();
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

	public LinkedList<Berechtigung> getBerechtigungzuIdWebservice(
			int IdWebservice) {
		ResultSet resultSet;
		LinkedList<Berechtigung> a = new LinkedList<Berechtigung>();
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
}
