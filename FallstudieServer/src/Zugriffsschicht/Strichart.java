package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class Strichart {
	private JdbcAccess db;
	private int idStrichart;
	private String Strichbez;
	private int Zustand;

	public Strichart(JdbcAccess db) {
		this.db = db;
	}

	public Strichart(int idStrichart, String Strichbez, int Zustand,
			JdbcAccess db) {
		this.idStrichart = idStrichart;
		this.Strichbez = Strichbez;
		this.Zustand = Zustand;
		this.db = db;
	}

	public int getIdStrichart() {
		return idStrichart;
	}

	public void setIdStrichart(int idStrichart) {
		this.idStrichart = idStrichart;
	}

	public String getStrichbez() {
		return Strichbez;
	}

	public void setStrichbez(String strichbez) {
		Strichbez = strichbez;
	}

	public int getZustand() {
		return Zustand;
	}

	public void setZustand(int zustand) {
		Zustand = zustand;
	}

}
