package Stricheln;

import java.util.Date;
import java.util.List;

import Zugriffsschicht.Benutzer;
import Zugriffsschicht.Strichart;
import Zugriffsschicht.Arbeitsschritte;
import jdbc.JdbcAccess;

public class Stricheln {

	private JdbcAccess db;

	public Stricheln(JdbcAccess db) {
		this.db = db;
	}

	public List<Strichart> getmoeglicheStrichart() {
		/*
		 * R�ckgabe aller Stricharten die anzeigbar sind
		 */
		return null;
	}

	public String getstrichbezeichnung(int Strichart) {
		/*
		 * R�ckgabe Strichbezeichnung
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

		Arbeitsschritte WB = new Arbeitsschritte(Ben.getIdBenutzer(),
				Ben.getAktuelleOE(), Datum, Strichart, Strichzahl, db);

		return false;
	}

}
