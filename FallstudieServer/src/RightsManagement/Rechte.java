package RightsManagement;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import jdbc.JdbcAccess;
import Zugriffsschicht.Benutzer;
import Zugriffsschicht.Berechtigung;
import Zugriffsschicht.OrgaEinheit;
import Zugriffsschicht.Zugriffschicht;

//Anforderung 4.2.8 wird hier realisiert.

public class Rechte {
	private JdbcAccess db;
	private Zugriffschicht dbZugriff;

	public Rechte(JdbcAccess db, Zugriffschicht dbZugriff) {
		this.db = db;
	}

	private boolean login(String Benutzername, String Passwort) {
		/*
		 * Überprüfung ob die Logindaten übereinstimmen: Passt Passwort zu
		 * Benutzername.
		 */
		Benutzer Ben = new Benutzer(db);
		Ben.getBenutzerfromBenutzername(Benutzername);
		if (Passwort.equals(Ben.getPasswort())) {
			return true;
		}
		return false;
	}

	private int[] getRechte(String Benutzername) {
		/*
		 * Ermittelt sämtliche Rechte für den Benutzer Achtung: ebenfalls rechte
		 * wenn man OE-Inhaber ist!
		 */
		int[] ret = null;
		Benutzer Ben = new Benutzer(db);
		Ben.getBenutzerfromBenutzername(Benutzername);
		int IdBenutzer = Ben.getIdBenutzer();
		boolean zuruekok = true;
		List<OrgaEinheit> b = dbZugriff.getOEzuInhaber(IdBenutzer);
		int[] retb = null;
		if (b == null || b.isEmpty()) {
			zuruekok = false;
		} else {
			retb = new int[b.size()];
			int zaehlerb = 0;
			for (OrgaEinheit B : b) {
				retb[zaehlerb] = B.getInhaberberechtigung();
				zaehlerb++;
			}
		}

		Collection<Berechtigung> a = new LinkedList<>();
		int[] reta = null;
		a = dbZugriff.getBerechtigungzuIdBenutzer(IdBenutzer);
		if (a == null || a.isEmpty()) {
			zuruekok = false;
		} else {
			reta = new int[a.size()];
			int zaehler = 0;
			for (Berechtigung B : a) {
				reta[zaehler] = B.getIdBerechtigung();
				zaehler++;
			}
		}
		if (zuruekok) {
			if (reta != null && retb != null) {
				ret = new int[reta.length + retb.length];
				for (int z = 0; z < reta.length; z++) {
					ret[z] = reta[z];
				}
				for (int z = 0; z < retb.length; z++) {
					ret[reta.length + z] = retb[z];
				}
			}
		} else {
			if (reta == null) {
				ret = retb;
			}
			if (retb == null) {
				ret = reta;
			}
		}

		return ret;
	}

	private int[] getRechtemoeglich(int Vorgang) {
		/*
		 * gibt alle Rechte zum Webservice zurück.
		 */
		int[] ret = null;
		List<Berechtigung> a = dbZugriff
				.getBerechtigungzuIdWebservice(Vorgang);
		if (a == null || a.isEmpty()) {
		} else {
			ret = new int[a.size()];
			int zaehler = 0;
			for (Berechtigung B : a) {
				ret[zaehler] = B.getIdBerechtigung();
				zaehler++;
			}
		}
		return ret;
	}

	public boolean vorgangMoeglich(String Benutzername, String Passwort,
			int Vorgang) {
		/*
		 * überprüfung ob login gültig ist rechte suchen vergleichen ob Vorgang
		 * mit erhaltenen rechten möglich ist.
		 */
		if (login(Benutzername, Passwort)) {
			if (Vorgang == 1) {
				return true;
			}
			else {
				int[] Rechte = this.getRechte(Benutzername);
				int[] Rechtemoeglich = this.getRechtemoeglich(Vorgang);
				if (Rechte != null && Rechtemoeglich != null) {
					for (int i = 0; i < Rechte.length; i++) {
						for (int a = 0; a < Rechtemoeglich.length; a++) {
							if (Rechte[i] == Rechtemoeglich[a]) {
								return true;
							}
						}
					}
				}
			}	
		}
		return false;
	}

	public char[] erlaubteAnzeigen() {
		// TODO Auto-generated method stub
		return null;
	}

}
