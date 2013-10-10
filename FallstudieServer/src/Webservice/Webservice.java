package Webservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import jdbc.JdbcAccess;

import RightsManagement.Rechte;
import Benutzerverwaltung.Benutzerverwaltung;
import Optionen.Optionen;
import Stricheln.Stricheln;
import Zugriffsschicht.Statistik;
import Zugriffsschicht.Strichart;
import Zugriffsschicht.Zugriffschicht;

/* 
 * Aus dieser *.java-Datei wurden die *.class-Dateien mit folgender Anweisung generiert:
 * c:\eclipseWorkspace\WebServiceDemo>wsgen -cp bin -s src -d bin de.integrata.SimpleWS
 * Hinweis: wsgen ist nicht unbedingt n�tig, bei �nderung des Interfaces von SimpleWS
 *          generiert der Compiler dynamisch die n�tigen Klassen und das WSDL File
 */
/**
 * Diese Klasse realisiert einen einfachen Web-Service mit 4 Methoden - die WSDL
 * Datei kann �ber http://localhost:8888/WSExample/simple?wsdl angezeigt werden
 * - �nderungen werden erst nach Recompile und Neustart dieses Programms wirksam
 */
@WebService
public class Webservice {
	
	
	private JdbcAccess jdbc;
	private Zugriffschicht dbZugriff;
	private Rechte rightsManagement;
	private Benutzerverwaltung benutzerverwaltung;
	private Stricheln stricheln;
	
	public Webservice() {
		try {
			jdbc = new JdbcAccess(Optionen.getJdbcurl(), Optionen.getJdbcuser(),
					Optionen.getJdbcpw());
			dbZugriff = new Zugriffschicht(jdbc);
			rightsManagement = new Rechte(jdbc, dbZugriff);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@WebMethod
	public boolean login(String Benutzername, String Passwort) {
		/*
		 * return true wenn login geklappt hat (erstmal so lassen)
		 * eventuell char zur�ckgeben, dann aber noch recht.login() �ndern oder vorgangMoeglich()
		 */
		return rightsManagement.vorgangMoeglich(Benutzername, Passwort, 1);
	}

	//Gibt ein Array aus char zur�ck, je nachdem welche Fenster angezeigt werden sollen.
	@WebMethod
	public char[] anzeige(String Benutzer, String Passwort) {
		/*
		 * 'd'->Dash/Strichelfenster 
		 * 'b'->Adminrechte
		 * 's'->Statistikfenster
		 * 
		 */
		char[] ret = null;
		if (rightsManagement.vorgangMoeglich(Benutzer, Passwort, 2)) {
			ret = rightsManagement.erlaubteAnzeigen();
		}
		return ret;
	}

	//Statistik erst einmal nur Grundfunktionalit�t. Muss noch erweitert werden.
	@WebMethod
	public List<Statistik> getStatistik(String Benutzer, String Passwort, int kalendarwoche, int jahr) {
		/*
		 * TODO : Anstatt String[] als �bergabewert die Klasse Statistik
		 * �bergeben. bei mehreren Statistiken :
		 * List<Statistik> Der Server sucht die OE des Benutzers und gibt alle
		 * Statistiken dazu aus.
		 */
		if (rightsManagement.vorgangMoeglich(Benutzer, Passwort, 3)) {

		}
		return null;
	}

	
	@WebMethod
	public List<Strichart> getStrichelArt(String Benutzer, String Passwort) {
		/*
		 * r�ckgabe der verschiedenen Strichelm�glichkeiten. Eventuell �bergabe
		 * einer Strichelklasse( siehe statistik) R�ckgabe von Strichelart(DB)
		 * und bezeichnung sofern Zustand vorhanden ist.
		 */
		List<Strichart> ret = new ArrayList<Strichart>();
		if (rightsManagement.vorgangMoeglich(Benutzer, Passwort, 4)) {
			ret = dbZugriff.getAlleMoeglichenStricharten();
		}
		return ret;
	}

	@WebMethod
	public boolean sendStricheln(String Benutzer, String Passwort,
			int Strichart, int Strichzahl, Date Datum) {
		/*
		 * Datum eventuell anderes Format. Wenn datum null -> Systemwert
		 * verwenden
		 * 
		 * Wird f�r jede strichart seperat aufgerufen. R�ckgabe ist entweder
		 * true f�r geklappt oder false f�r fehlgeschlagen Fehlgeschlagen wegen
		 * follgender Gr�nde: -Keine Rechte zum schreiben -Datenbank offline
		 * -Andere Fehler
		 */
		if (rightsManagement.vorgangMoeglich(Benutzer, Passwort, 5)) {
			Stricheln Strich = new Stricheln(jdbc);
			if (Strich.schreibeStrichInBW(Benutzer, Datum, Strichart,
					Strichzahl)) {
				return true;
			}
		}
		return false;
	}

	//das w�r dann doch nur eine Methode f�r den admin??
	//das mit dem alle benutzer einer einheit haben wir ja in Zugriffschicht
	@WebMethod
	public String[] getBenutzer(String Benutzer, String Passwort) {
		/*
		 * r�ckgabe der verschiedenen Benutzer. Eventuell �bergabe einer
		 * Benutzerklasse( siehe statistik) R�ckgabe von idBenutzer(DB),
		 * Benutzername, aktuelle OE.
		 */
		return null;
	}

	//Methode nur f�r Admin.
	@WebMethod
	public boolean benutzerErstellen(String Benutzer, String Passwort,
			int idBenutzer, String Benutzername, String BenutzerPasswort,
			int idOE) {
		/*
		 * Wenn idBenutzer = null -> neuanlage Wenn idBenutzer = existiert ->
		 * update Wird f�r jeden Benutzer seperat aufgerufen. Passwort (wenn
		 * null) bei neuanlage auf Default:"TODO : Was f�r ein Dafaultwert?"
		 * R�ckgabe ist entweder true f�r geklappt oder false f�r fehlgeschlagen
		 * Fehlgeschlagen wegen follgender Gr�nde: -Keine Rechte zum schreiben
		 * -Datenbank offline -Andere Fehler -Kein Datensatz vorhanden
		 */
		return false;
	}

	@WebMethod
	public boolean sendNeuesPasswort(String Benutzer, String Passwort,
			String NeuesPasswort) {
		/*
		 * R�ckgabe ist entweder true f�r geklappt oder false f�r fehlgeschlagen
		 * Fehlgeschlagen wegen follgender Gr�nde: -Keine Rechte zum schreiben
		 * -Datenbank offline -Andere Fehler
		 */
		return false;
	}

	//Methode f�r Admin? oder wie soll die identifizierung ablaufen?
	@WebMethod
	public boolean sendPasswortzuruecksetzen(String Benutzer, String Passwort,
			int idBenutzer) {
		/*
		 * R�ckgabe ist entweder true f�r geklappt oder false f�r fehlgeschlagen
		 * Fehlgeschlagen wegen follgender Gr�nde: -Keine Rechte zum schreiben
		 * -Datenbank offline -Andere Fehler
		 */
		return false;
	}

	//Wie w�rs wenn wir die Organisationseinheit einfach beim Login mit �bergeben?
	@WebMethod
	public String[] getOE(String Benutzer, String Passwort) {
		/*
		 * r�ckgabe der verschiedenen OEs. Eventuell �bergabe einer OEklasse(
		 * siehe statistik) R�ckgabe von idOE(DB), OEname, aktueller Inhaber und
		 * Zustand.
		 */
		return null;
	}

	//Methode f�r admin.
	@WebMethod
	public boolean sendOE(String Benutzer, String Passwort, int idOE,
			int UeberOE, String OEbezeichnung, int Inhaberberechtigung,
			int idInhaber, int Zustand) {
		/*
		 * R�ckgabe ist entweder true f�r geklappt oder false f�r fehlgeschlagen
		 * Fehlgeschlagen wegen follgender Gr�nde: -Keine Rechte zum schreiben
		 * -Datenbank offline -Andere Fehler
		 */
		return false;
	}

	//was ist mit zustand gemeint? braucht man idStrichart �berhaupt? eig reicht ja strichart
	@WebMethod
	public String[] getStrichelarten(String Benutzer, String Passwort) {
		/*
		 * r�ckgabe der verschiedenen Stricharten. Eventuell �bergabe einer
		 * Strichklasse( siehe statistik) R�ckgabe von idStrichart(DB),
		 * Strichname(DB) und Zustand(DB).
		 */
		return null;
	}

	
	@WebMethod
	public boolean sendStrichelart(String Benutzer, String Passwort,
			int idStrichart, String Strichbezeichnung, int StrichZustand) {
		/*
		 * Wenn idStrichart = null -> neuanlage des Datensatzes Wenn idStrichart
		 * = existierender wert -> Datensatz updaten R�ckgabe ist entweder true
		 * f�r geklappt oder false f�r fehlgeschlagen Fehlgeschlagen wegen
		 * follgender Gr�nde: -Kein DB-eintrag mit der id -Keine Rechte zum
		 * schreiben -Datenbank offline -Andere Fehler
		 */
		return false;
	}
	
	//beendet den Access auf die Datenbank
	private void dbZugriffBeenden(){
		try {
			jdbc.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Den Service mittels in Java 6 enthaltenen HTTP-Server ver�ffentlichen
	 */
	public static void main(String[] args) {

		Webservice webservice = new Webservice();
		Endpoint endpoint = Endpoint.publish(
				Optionen.getWebserverURL(), webservice);
		// Hier wartet der Server
		System.out.println("web service server running ... press key to stop");

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		endpoint.stop();
		webservice.dbZugriffBeenden();
		System.out.println("Web service Server stopped");
	}

}
