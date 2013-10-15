package Administration;

import java.util.List;

import Com.ComBerechtigung;
import Zugriffsschicht.Zugriffschicht;

public class Berechtigungsverwaltung {

	private Zugriffschicht dbZugriff;

	public Berechtigungsverwaltung(Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}
	
	public List<ComBerechtigung> getAlleBerechtigung (){
		return null;
	}
}
