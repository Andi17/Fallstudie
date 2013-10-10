package Benutzerverwaltung;

import Zugriffsschicht.Benutzer;
import Zugriffsschicht.Zugriffschicht;

public class Benutzerverwaltung {
	
	private Zugriffschicht dbZugriff;
	
	public Benutzerverwaltung (Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}
	
	//erstellt einen neuen Benutzer und gibt ein Objekt des entsprechenden Benutzers zurück
	//vielleicht auch einfach nur boolean als rückgabewert
	public Benutzer benutzerErstellen(String benutzername, String passwort, int oeEinheit){
		return null;
	}

	//Holt sich den entsprechenden Benutzer aus der Zugriffsschicht.
	//gibt null zurück wenn kein Benutzer mit der ID existiert.
	public Benutzer getBenutzer(int benutzerID) {
		return null;
	}
	
	//setzt das Passwort des Benutzers mit der entsprechenden benutzerID auf das neue Passwort
	public Benutzer setPasswort(int benutzerID, String neuesPasswort){
		return null;
	}
	
	
}
