package Zugriffsschicht;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcAccess;

public class Strichart {
	private JdbcAccess db;
	private int idStrichart;
	private String Strichbez;
	private boolean zustand;

	public Strichart(JdbcAccess db) {
		this.db = db;
	}

	public Strichart(int idStrichart, String Strichbez, boolean zustand,
			JdbcAccess db) {
		this.idStrichart = idStrichart;
		this.Strichbez = Strichbez;
		this.zustand = zustand;
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

	public boolean getZustand() {
		return zustand;
	}

	public void setZustand(boolean zustand) {
		this.zustand = zustand;
	}

}
