package Com;

public class ComOrgaEinheit {
	private int idOrgaEinheit;
	private int UeberOrgaEinheit;
	private String OrgaEinheitBez;
	private String Leitername;
	private int idLeiterBerechtigung;
	private String LeiterBerechtigungBez;
	private int idMitarbeiterBerechtigung;
	private String MitarbeiterBerechtigungBez;

	public ComOrgaEinheit(int idOrgaEinheit, int UeberOrgaEinheit,
			String OrgaEinheitBez, String Leitername, int idLeiterBerechtigung,
			String LeiterBerechtigungBez, int idMitarbeiterBerechtigung,
			String MitarbeiterBerechtigungBez) {
		this.idOrgaEinheit = idOrgaEinheit;
		this.UeberOrgaEinheit = UeberOrgaEinheit;
		this.OrgaEinheitBez = OrgaEinheitBez;
		this.Leitername = Leitername;
		this.idLeiterBerechtigung = idLeiterBerechtigung;
		this.LeiterBerechtigungBez = LeiterBerechtigungBez;
		this.idMitarbeiterBerechtigung = idMitarbeiterBerechtigung;
		this.MitarbeiterBerechtigungBez = MitarbeiterBerechtigungBez;
	}

	public int getIdOrgaEinheit() {
		return idOrgaEinheit;
	}

	public int getUeberOrgaEinheit() {
		return UeberOrgaEinheit;
	}

	public String getOrgaEinheitBez() {
		return OrgaEinheitBez;
	}

	public String getLeitername() {
		return Leitername;
	}

	public int getIdLeiterBerechtigung() {
		return idLeiterBerechtigung;
	}

	public String getLeiterBerechtigungBez() {
		return LeiterBerechtigungBez;
	}

	public int getIdMitarbeiterBerechtigung() {
		return idMitarbeiterBerechtigung;
	}

	public String getMitarbeiterBerechtigungBez() {
		return MitarbeiterBerechtigungBez;
	}

	public void setIdOrgaEinheit(int idOrgaEinheit) {
		this.idOrgaEinheit = idOrgaEinheit;
	}

	public void setUeberOrgaEinheit(int ueberOrgaEinheit) {
		UeberOrgaEinheit = ueberOrgaEinheit;
	}

	public void setOrgaEinheitBez(String orgaEinheitBez) {
		OrgaEinheitBez = orgaEinheitBez;
	}

	public void setLeitername(String leitername) {
		Leitername = leitername;
	}

	public void setIdLeiterBerechtigung(int idLeiterBerechtigung) {
		this.idLeiterBerechtigung = idLeiterBerechtigung;
	}

	public void setLeiterBerechtigungBez(String leiterBerechtigungBez) {
		LeiterBerechtigungBez = leiterBerechtigungBez;
	}

	public void setIdMitarbeiterBerechtigung(int idMitarbeiterBerechtigung) {
		this.idMitarbeiterBerechtigung = idMitarbeiterBerechtigung;
	}

	public void setMitarbeiterBerechtigungBez(String mitarbeiterBerechtigungBez) {
		MitarbeiterBerechtigungBez = mitarbeiterBerechtigungBez;
	}
}
