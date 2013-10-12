package Benutzerverwaltung;

import java.util.List;

import Com.ComOrgaEinheit;
import Zugriffsschicht.OrgaEinheit;
import Zugriffsschicht.Zugriffschicht;

public class OrgaEinheitVerwaltung {
	
	private Zugriffschicht dbZugriff;
	
	
	public OrgaEinheitVerwaltung(Zugriffschicht dbZugriff){
		this.dbZugriff = dbZugriff;
	}
	
	public List<ComOrgaEinheit> getAlleOrgaEinheiten(){
		/*
		 * r�ckgabe der verschiedenen OEs. Eventuell �bergabe einer OEklasse(
		 * siehe statistik) R�ckgabe von idOE(DB), OEname, aktueller Inhaber und
		 * Zustand.
		 */
		return null;
	}
	
	public boolean neueOrgaEinheit(int UeberOE, String OEbezeichnung, int Inhaberberechtigung,
			int idInhaber, int Zustand){

		/*
		 * R�ckgabe ist entweder true f�r geklappt oder false f�r fehlgeschlagen
		 * Fehlgeschlagen wegen follgender Gr�nde: -Keine Rechte zum schreiben
		 * -Datenbank offline -Andere Fehler
		 */
		return false;
	}

}
