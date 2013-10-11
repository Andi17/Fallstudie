package Benutzerverwaltung;

import java.util.List;

import Zugriffsschicht.Benutzer;
import Zugriffsschicht.Zugriffschicht;

public class Benutzerverwaltung {
	
	private Zugriffschicht dbZugriff;
	
	public Benutzerverwaltung (Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}
	
	//erstellt einen neuen Benutzer und gibt ein Objekt des entsprechenden Benutzers zur�ck
	//vielleicht auch einfach nur boolean als r�ckgabewert
	public boolean benutzerErstellen(String benutzername, String passwort, int oeEinheit){
		return false;
	}

	//Holt sich den entsprechenden Benutzer aus der Zugriffsschicht.
	//gibt null zur�ck wenn kein Benutzer mit der ID existiert.
	public Benutzer getBenutzer(String benutzername) {
		return null;
	}
	
	public List<Benutzer> getAlleBenutzer(){
		/*
		 * r�ckgabe der verschiedenen Benutzer. Eventuell �bergabe einer
		 * Benutzerklasse( siehe statistik) R�ckgabe von idBenutzer(DB),
		 * Benutzername, aktuelle OE.
		 */
		return null;
	}
	
	//L�scht den Benuttzer mit der entsprechenden ID.
	public boolean benutzerLoeschen(String benutzername){
		return false;
	}
	
	//�ndert die OrgaEinheit. Muss aus dem String die entsprechende ID herrauslesen.
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
