package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import jdbc.JdbcAccess;

public class StrichbezeichnungListe {
	private JdbcAccess db;

	public StrichbezeichnungListe(JdbcAccess db) {
		this.db = db;
	}

	public List<Strichbezeichnung> getallemoeglichenStricharten() {
		ResultSet resultSet;
		List<Strichbezeichnung> a = new ArrayList<Strichbezeichnung>();
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM strichbezeichnung WHERE Zustand = 1");
			while (resultSet.next()) {
				a.add(new Strichbezeichnung(resultSet.getInt("idStrichart"),
						resultSet.getString("Strichbez"), resultSet
								.getInt("Zustand"), db));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		return a;
	}
}
