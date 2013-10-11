package Benutzerverwaltung;

import java.util.List;

import Zugriffsschicht.OrgaEinheit;
import Zugriffsschicht.Zugriffschicht;

public class OrgaEinheitVerwaltung {
	
	private Zugriffschicht dbZugriff;
	
	
	public OrgaEinheitVerwaltung(Zugriffschicht dbZugriff){
		this.dbZugriff = dbZugriff;
	}
	
	public List<OrgaEinheit> getAlleOrgaEinheiten(){
		/*
		 * rückgabe der verschiedenen OEs. Eventuell übergabe einer OEklasse(
		 * siehe statistik) Rückgabe von idOE(DB), OEname, aktueller Inhaber und
		 * Zustand.
		 */
		return null;
	}
	
	public boolean neueOrgaEinheit(int UeberOE, String OEbezeichnung, int Inhaberberechtigung,
			int idInhaber, int Zustand){

		/*
		 * Rückgabe ist entweder true für geklappt oder false für fehlgeschlagen
		 * Fehlgeschlagen wegen follgender Gründe: -Keine Rechte zum schreiben
		 * -Datenbank offline -Andere Fehler
		 */
		return false;
	}

}
