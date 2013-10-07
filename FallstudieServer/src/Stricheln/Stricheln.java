package Stricheln;

import java.util.Date;

import Zugriffsschicht.Benutzer;
import Zugriffsschicht.WocheBenutzer;
import jdbc.JdbcAccess;

public class Stricheln {

	private JdbcAccess db;

	public Stricheln(JdbcAccess db) {
		this.db = db;
	}

	public int[] getmoeglicheStrichart() {
		/*
		 * Rückgabe aller Stricharten die anzeigbar sind
		 */
		return null;
	}

	public String getstrichbezeichnung(int Strichart) {
		/*
		 * Rückgabe Strichbezeichnung
		 */
		return null;
	}

	public boolean schreibeStrichInBW(String Benutzername, Date Datum,
			int Strichart, int Strichzahl) {
		/*
		 * Strich in die Datenbank schreiben.
		 */
		Benutzer Ben = new Benutzer(db);
		Ben.getBenutzerfromBenutzername(Benutzername);

		WocheBenutzer WB = new WocheBenutzer(Ben.getIdBenutzer(),
				Ben.getAktuelleOE(), Datum, Strichart, Strichzahl, db);

		return false;
	}

}
