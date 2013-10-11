package Benutzerverwaltung;

import java.util.List;

import Zugriffsschicht.Benutzer;
import Zugriffsschicht.Zugriffschicht;

public class Benutzerverwaltung {
	
	private Zugriffschicht dbZugriff;
	
	public Benutzerverwaltung (Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}
	
	//erstellt einen neuen Benutzer und gibt ein Objekt des entsprechenden Benutzers zurück
	//vielleicht auch einfach nur boolean als rückgabewert
	public boolean benutzerErstellen(String benutzername, String passwort, int oeEinheit){
		return false;
	}

	//Holt sich den entsprechenden Benutzer aus der Zugriffsschicht.
	//gibt null zurück wenn kein Benutzer mit der ID existiert.
	public Benutzer getBenutzer(String benutzername) {
		return null;
	}
	
	public List<Benutzer> getAlleBenutzer(){
		/*
		 * rückgabe der verschiedenen Benutzer. Eventuell übergabe einer
		 * Benutzerklasse( siehe statistik) Rückgabe von idBenutzer(DB),
		 * Benutzername, aktuelle OE.
		 */
		return null;
	}
	
	//Löscht den Benuttzer mit der entsprechenden ID.
	public boolean benutzerLoeschen(String benutzername){
		return false;
	}
	
	//Ändert die OrgaEinheit. Muss aus dem String die entsprechende ID herrauslesen.
	public boolean orgaEinheitAendern(String benutzername, String orgaEinheit){
		return false;
	}
	
	//setzt das Passwort des Benutzers mit der entsprechenden benutzerID auf das neue Passwort
	public boolean setPasswort(String benutzername, String neuesPasswort){
		return false;
	}
	
	public void passwortSperren(String benutzername){
		
	}
	
	
}
