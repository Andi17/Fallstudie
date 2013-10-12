package Com;

public class ComBenutzer {
	private String Benutzername;
	private String Passwort;
	private int    idOrgaEinheit;
	private String OrgaEinheitBez;
	private boolean Gesperrt;
	
	
	public ComBenutzer(String Benutzername, String Passwort, int idOrgaEinheit, String OrgaEinheitBez, boolean Gesperrt){
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.idOrgaEinheit = idOrgaEinheit;
		this.OrgaEinheitBez = OrgaEinheitBez;
		this.Gesperrt = Gesperrt;
	}

}
