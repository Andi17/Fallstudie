package Statistikausgabe;

import java.util.List;

import Zugriffsschicht.Statistik;
import Zugriffsschicht.Zugriffschicht;

//Anforderung 4.2.9 Anonymit�t des Erfassers muss ber�cksichtigt werden.

public class Statistikausgabe {
	
	private Zugriffschicht dbZugriff;
	
	public Statistikausgabe (Zugriffschicht dbZugriff){
		this.dbZugriff = dbZugriff;
	}
	
	public List<Statistik> getStatistik(String benutzername, int kalendarwoche, int jahr){
		return null;
	}
	
	public Statistik statistikErstellen (int idOE){
		return null;
	}

}
