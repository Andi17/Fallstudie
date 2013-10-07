package Zugriffsschicht;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import jdbc.JdbcAccess;

public class BenutzerListe {

	private JdbcAccess db;

	public BenutzerListe(JdbcAccess db) {
		this.db = db;
	}

	public Collection<Benutzer> BenuterListeausgeben() {
		ResultSet resultSet;
		Collection<Benutzer> a = new LinkedList<Benutzer>();
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
}
