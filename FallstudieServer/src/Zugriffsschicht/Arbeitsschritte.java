package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcAccess;

public class Arbeitsschritte {
	private JdbcAccess db;
	private int idBW;
	private int idBenutzer;
	private int idOE;
	private Date Datum;
	private int idStrichart;
	private int Strichzahl;

	public Arbeitsschritte(JdbcAccess db) {
		this.db = db;
	}

	public Arbeitsschritte(int idBW, JdbcAccess db) {
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM WocheBenutzer WHERE idBW = '"
							+ idBW + "'");
			resultSet.next();
			this.idBW = resultSet.getInt("idBW");
			this.idBenutzer = resultSet.getInt("idBenutzer");
			this.idOE = resultSet.getInt("idOE");
			this.Datum = sqlTimestampToDate(resultSet.getTimestamp("Timestamp"));
			this.idStrichart = resultSet.getInt("idStrichart");
			this.Strichzahl = resultSet.getInt("Strichzahl");
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		this.db = db;
	}

	public Arbeitsschritte(int Benutzer, int idOE, Date Datum, int idStrichart,
			int Strichzahl, JdbcAccess db) {
		this.idBenutzer = Benutzer;
		this.idOE = idOE;
		this.Datum = Datum;
		this.idStrichart = idStrichart;
		this.Strichzahl = Strichzahl;
		this.db = db;
	}

	public boolean schreibeWBinDB() {
		ResultSet resultSet;
		if (idBW == 0) {
			System.out.println("Update eines Benutzer-Woche-Objekts mit einer idBW");
		} else {

			if (Datum == null) {
				try {
					resultSet = db
							.executeQueryStatement("INSERT INTO benutzerwoche (idBenutzer ,idOE ,idStrichart ,Strichzahl)VALUES ("
									+ idBenutzer
									+ ", "
									+ idOE
									+ ", "
									+ dateToSqlTimestamp(Datum)
									+ ", "
									+ idStrichart + ", " + Strichzahl + ")");
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					resultSet = db
							.executeQueryStatement("INSERT INTO benutzerwoche (idBenutzer ,idOE ,Timestamp , idStrichart ,Strichzahl)VALUES ("
									+ idBenutzer
									+ ", "
									+ idOE
									+ ", "
									+ idStrichart + ", " + Strichzahl + ")");
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		return false;
	}

	public boolean getWocheBenutzerfromidBW(int idBW) {
		/*
		 * WocheBenutzerdaten werden durch Identifikationsnummer idBW ermittelt.
		 */
		ResultSet resultSet;
		try {
			resultSet = db
					.executeQueryStatement("SELECT * FROM WocheBenutzer WHERE idBW = '"
							+ idBW + "'");
			resultSet.next();
			this.idBW = resultSet.getInt("idBW");
			this.idBenutzer = resultSet.getInt("Benutzer");
			this.idOE = resultSet.getInt("idOE");
			this.Datum = sqlTimestampToDate(resultSet.getTimestamp("Timestamp"));
			this.idStrichart = resultSet.getInt("idStrichart");
			this.Strichzahl = resultSet.getInt("Strichzahl");
			resultSet.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public int getIDBW() {
		return idBW;
	}

	public int getBenutzer() {
		return idBenutzer;
	}

	public int getIDOE() {
		return idOE;
	}

	public Date getDatum() {
		return Datum;
	}

	public int getIDStrichart() {
		return idStrichart;
	}

	public int getStrichzahl() {
		return Strichzahl;
	}

	public int setIDBW() {
		return this.idBW;
	}

	public int setBenutzer() {
		return this.idBenutzer;
	}

	public int setIDOE() {
		return this.idOE;
	}

	public Date setDatum() {
		return this.Datum;
	}

	public int setIDStrichart() {
		return this.idStrichart;
	}

	public int setStrichzahl() {
		return this.Strichzahl;
	}

	public Date sqlTimestampToDate(Timestamp timestamp) {
		Date date = new Date(timestamp.getTime());
		return date;
	}

	public Timestamp dateToSqlTimestamp(Date date) {
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}
}
