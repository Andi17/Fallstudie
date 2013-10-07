package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import jdbc.JdbcAccess;

public class OEListe {
	private JdbcAccess db;

	public OEListe(JdbcAccess db) {
		this.db = db;
	}

	public Collection<OE> getOEzuInhaber(int IdInhaber) {
		/*
		 * Organisationseinheitsdaten werden durch Identifikationsnummer idOE
		 * ermittelt.
		 */
		LinkedList<OE> ret = new LinkedList<OE>();
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM oe WHERE idInhaber = '"
							+ IdInhaber + "'");
			while (resultSet.next()) {
				ret.add(new OE(resultSet.getInt("idOE"), resultSet
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
}
