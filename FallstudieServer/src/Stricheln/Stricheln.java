package Stricheln;

import java.util.List;

import Com.ComStrichart;
import Zugriffsschicht.Strichart;
import Zugriffsschicht.Zugriffschicht;

public class Stricheln {

	private Zugriffschicht dbZugriff;

	public Stricheln(Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}

	public List<ComStrichart> getMoeglicheStricharten() {
		/*
		 * Rückgabe aller Stricharten die anzeigbar sind
		 *//*
		 * rückgabe der verschiedenen Strichelmöglichkeiten. Eventuell übergabe
		 * einer Strichelklasse( siehe statistik) Rückgabe von Strichelart(DB)
		 * und bezeichnung sofern Zustand vorhanden ist.
		 */
		return null;
	}

	public String getstrichbezeichnung(int Strichart) {
		/*
		 * Rückgabe Strichbezeichnung
		 */
		return null;
	}

	//gibt true zurück wenn erfolgreich, speichert strich in datenbank
	public boolean schreibeStrichInDatenbank(String Benutzername, int Strichart, 
			boolean aktuelleWoche, int jahr) {
		
		
		return false;
	}

}
