package Administration;

import java.util.ArrayList;
import java.util.List;

import Com.ComBerechtigung;
import Zugriffsschicht.Berechtigung;
import Zugriffsschicht.Zugriffschicht;

public class Berechtigungsverwaltung {

	private Zugriffschicht dbZugriff;

	public Berechtigungsverwaltung(Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}
	
	public List<ComBerechtigung> getAlleBerechtigung (){
		List<Berechtigung> listeBerechtigung = dbZugriff.getAlleBerechtigungen();
		List<ComBerechtigung> rueckgabe = new ArrayList<ComBerechtigung>();
		for (Berechtigung berechtigung : listeBerechtigung){
				rueckgabe.add(new ComBerechtigung(berechtigung.getIdBerechtigung(), berechtigung.getBerechtigungbez()));
		}
		return rueckgabe;
	}
}
