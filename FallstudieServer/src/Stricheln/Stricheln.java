package Stricheln;

import java.util.List;

import Zugriffsschicht.Strichart;
import Zugriffsschicht.Zugriffschicht;

public class Stricheln {

	private Zugriffschicht dbZugriff;

	public Stricheln(Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}

	public List<String> getMoeglicheStricharten() {
		/*
		 * R�ckgabe aller Stricharten die anzeigbar sind
		 *//*
		 * r�ckgabe der verschiedenen Strichelm�glichkeiten. Eventuell �bergabe
		 * einer Strichelklasse( siehe statistik) R�ckgabe von Strichelart(DB)
		 * und bezeichnung sofern Zustand vorhanden ist.
		 */
		return null;
	}

	public String getstrichbezeichnung(int Strichart) {
		/*
		 * R�ckgabe Strichbezeichnung
		 */
		return null;
	}

	//gibt true zur�ck wenn erfolgreich, speichert strich in datenbank
	public boolean schreibeStrichInDatenbank(String Benutzername, int Strichart, 
			boolean aktuelleWoche, int jahr) {
		
		
		return false;
	}

}
