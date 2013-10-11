package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcAccess;

public class Arbeitsschritte {
	private JdbcAccess db;
	private int idArbeitsschritt;
	private int idOrgaEinheit;
	private Date Datum;
	private int idStrichart;
	private int Strichzahl;

	public Arbeitsschritte(ResultSet resultSet, JdbcAccess db)
			throws SQLException {
		werteSetzen(resultSet);
		this.db = db;
	}
//TODO
	// DATUM Currentdate().... Select muss mit datum statfinden... vor der implementierung datum abfragen und eintragen
	public Arbeitsschritte(int idOrgaEinheit, Date Datum, int idStrichart,
			int Strichzahl, JdbcAccess db) throws SQLException {
		db.executeUpdateStatement("INSERT INTO Arbeitsschritte ("
				+ "idOrgaEinheit, Timestamp, idStrichart, Strichzahl) "
				+ "VALUES ( " + idOrgaEinheit + ", "
				+ dateToSqlTimestamp(Datum) + ", "+
				+ idStrichart + ", "+
				+ Strichzahl + ")");
		ResultSet resultSet = db
				.executeQueryStatement("SELECT * FROM Arbeitsschritte WHERE "
						+ "idOrgaEinheit = " + idOrgaEinheit + "AND Timestamp = "+ dateToSqlTimestamp(Datum)+ " AND " + "idStrichart = "
						+ idStrichart + " AND Strichzahl = "+ Strichzahl+ "");
		resultSet.next();
		werteSetzen(resultSet);
		resultSet.close();
	}

	public void werteSetzen(ResultSet resultSet) throws SQLException {
		this.idArbeitsschritt = resultSet.getInt("idArbeitsschritt");
		this.idOrgaEinheit = resultSet.getInt("idOrgaEinheit");
		this.idStrichart = resultSet.getInt("idStrichart");
		this.Datum = sqlTimestampToDate(resultSet.getTimestamp("Timestamp"));
		this.Strichzahl = resultSet.getInt("Strichzahl");
	}


	public Date sqlTimestampToDate(Timestamp timestamp) {
		Date date = new Date(timestamp.getTime());
		return date;
	}

	public Timestamp dateToSqlTimestamp(Date date) {
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}
	public int getIdArbeitsschritt() {
		return idArbeitsschritt;
	}
	public void setIdArbeitsschritt(int idArbeitsschritt) {
		this.idArbeitsschritt = idArbeitsschritt;
	}
	public int getIdOrgaEinheit() {
		return idOrgaEinheit;
	}
	public void setIdOrgaEinheit(int idOrgaEinheit) {
		this.idOrgaEinheit = idOrgaEinheit;
	}
	public Date getDatum() {
		return Datum;
	}
	public void setDatum(Date datum) {
		Datum = datum;
	}
	public int getIdStrichart() {
		return idStrichart;
	}
	public void setIdStrichart(int idStrichart) {
		this.idStrichart = idStrichart;
	}
	public int getStrichzahl() {
		return Strichzahl;
	}
	public void setStrichzahl(int strichzahl) {
		Strichzahl = strichzahl;
	}
}
