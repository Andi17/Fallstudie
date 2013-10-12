package Benutzerverwaltung;

import java.util.ArrayList;
import java.util.List;

import Com.ComBenutzer;
import Optionen.Optionen;
import Zugriffsschicht.Benutzer;
import Zugriffsschicht.OrgaEinheit;
import Zugriffsschicht.Zugriffschicht;

public class Benutzerverwaltung {

	private Zugriffschicht dbZugriff;

	public Benutzerverwaltung(Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}

	// Erstellt einen neuen Benutzer und gibt einen boolschen Wert zurück,
	// welcher darstellt, ob der Benutzer erfolgreich angelegt wurde (true) oder
	// nicht (false)
	public boolean benutzerErstellen(String benutzername, String passwort,
			int oeEinheit) {

		Benutzer neu = dbZugriff.neuerBenutzerErstellen(benutzername, passwort,
				oeEinheit, Optionen.isInitialbelegungbenutzergesperrt());
		if (neu == null) {
			return false;
		} else {
			return true;
		}
	}

	// Holt sich den entsprechenden Benutzer aus der Zugriffsschicht.
	// gibt null zurück wenn kein Benutzer mit dem Benutzernamen existiert.
	public Benutzer getBenutzer(String benutzername) {
		// idBenutzer -> benutzername
		Benutzer retBenutzer = dbZugriff
				.getBenutzervonBenutzername(benutzername);
		return retBenutzer;
	}

	// Rückgabe der verschiedenen Benutzer in einer Liste.
	public List<ComBenutzer> getAlleBenutzer() {
		List<Benutzer> alleBenutzerListe = dbZugriff.getAlleBenutzer();
		List<ComBenutzer> rueckgabe = new ArrayList<ComBenutzer>();
		for (Benutzer benutzer : alleBenutzerListe){
			OrgaEinheit orgaEinheit = dbZugriff.getOrgaEinheitZuidOrgaEinheit(benutzer.getAktuelleOE());
			if (orgaEinheit == null){
				rueckgabe.add(new ComBenutzer(benutzer.getBenutzername(), benutzer.getPasswort(), benutzer.getAktuelleOE(), "Keine Organisationseinheit", benutzer.getGesperrt()));
			}
			else{
				rueckgabe.add(new ComBenutzer(benutzer.getBenutzername(), benutzer.getPasswort(), benutzer.getAktuelleOE(), orgaEinheit.getOrgaEinheitBez(), benutzer.getGesperrt()));	
			}
		}
		return rueckgabe;
	}

	// Löscht den Benuttzer mit der entsprechenden ID.
	public boolean benutzerLoeschen(String benutzername) {
		return false;
	}

	// Ändert die OrgaEinheit. Muss aus dem String die entsprechende ID
	// herrauslesen.
	public boolean orgaEinheitAendern(String benutzername, String orgaEinheit) {
		return false;
	}

	// setzt das Passwort des Benutzers mit der entsprechenden benutzerID auf
	// das neue Passwort
	public boolean setPasswort(String benutzername, String neuesPasswort) {
		return false;
	}

	// Sperrt das Passwort.
	public void passwortSperren(String benutzername) {

	}
}
