package Administration;

import Zugriffsschicht.Zugriffschicht;

public class StrichArtVerwaltung {
	
private Zugriffschicht dbZugriff;
	
	
	public StrichArtVerwaltung(Zugriffschicht dbZugriff){
		this.dbZugriff = dbZugriff;
	}
	
	public boolean strichArtHinzufuegen(String strichbezeichnung){
		return false;
	}
	
	public boolean strichArtBezeichnungAendern(String bezeichnungAlt, String bezeichnungNeu){
		return false;
	}

	public boolean gibtEsStrichelBezeichnung(
			String strichelBezeichnungBezeichnung) {
		return false;
	}

}
