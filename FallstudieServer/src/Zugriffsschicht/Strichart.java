package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class Strichart {
	private JdbcAccess db;
	private int idStrichart;
	private String StrichBez;
	private boolean Zustand;

	public Strichart(String StrichBez, boolean Zustand,
			JdbcAccess db) throws SQLException {
		db.executeUpdateStatement("INSERT INTO Stricharten (StrichBez, " +
				"Zustand) " +
				"VALUES ( " + StrichBez + ", " + Zustand + ")");
		ResultSet resultSet = db.executeQueryStatement("SELECT * FROM Stricharten WHERE " +
				"StrichBez = " + StrichBez +" AND "+
				"Zustand = " + Zustand );
		resultSet.next();
		werteSetzen(resultSet);
		resultSet.close();
	}
	public Strichart(ResultSet resultSet, JdbcAccess db)throws SQLException{
		werteSetzen(resultSet);
		this.db = db;
	}
	
	public void werteSetzen(ResultSet resultSet) throws SQLException{
		this.idStrichart = resultSet.getInt("idStrichart");
		this.StrichBez = resultSet.getString("StrichBez");
		this.Zustand = resultSet.getBoolean("Zustand");
	}

	public int getIdStrichart() {
		return idStrichart;
	}

	public void setIdStrichart(int idStrichart) {
		this.idStrichart = idStrichart;
	}

	public String getStrichbez() {
		return StrichBez;
	}

	public void setStrichbez(String strichbez) {
		StrichBez = strichbez;
	}

	public boolean getZustand() {
		return Zustand;
	}

	public void setZustand(boolean zustand) {
		this.Zustand = zustand;
	}

}
