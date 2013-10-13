package Com;

public class ComBerechtigung {
	private int idBerechtigung;
	private String BerechtigungBez;
	
	public ComBerechtigung(int idBerechtigung, String BerechtigungBez){
		this.idBerechtigung = idBerechtigung;
		this.BerechtigungBez = BerechtigungBez;
	}

	public int getIdBerechtigung() {
		return idBerechtigung;
	}

	public String getBerechtigungBez() {
		return BerechtigungBez;
	}

	public void setIdBerechtigung(int idBerechtigung) {
		this.idBerechtigung = idBerechtigung;
	}

	public void setBerechtigungBez(String berechtigungBez) {
		BerechtigungBez = berechtigungBez;
	}

}
