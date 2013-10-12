package Statistikausgabe;

import java.util.List;

import Com.ComStatistik;
import Zugriffsschicht.Statistik;
import Zugriffsschicht.Zugriffschicht;

//Anforderung 4.2.9 Anonymität des Erfassers muss berücksichtigt werden.

public class Statistikausgabe {
	
	private Zugriffschicht dbZugriff;
	
	public Statistikausgabe (Zugriffschicht dbZugriff){
		this.dbZugriff = dbZugriff;
	}
	
	public List<ComStatistik> getStatistik(String benutzername, int kalendarwoche, int jahr){
		return null;
	}
	
	public Statistik statistikErstellen (int idOE){
		return null;
	}

}
