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
	private int HierarchieStufe;

	public ComOrgaEinheit(int idOrgaEinheit, int UeberOrgaEinheit,
			String OrgaEinheitBez, String Leitername, int idLeiterBerechtigung, String LeiterBerechtigungBez,
			int idMitarbeiterBerechtigung, String MitarbeiterBerechtigungBez, int HierarchieStufe) {
		this.idOrgaEinheit = idOrgaEinheit;
		this.UeberOrgaEinheit = UeberOrgaEinheit;
		this.OrgaEinheitBez = OrgaEinheitBez;
		this.Leitername = Leitername;
		this.idLeiterBerechtigung = idLeiterBerechtigung;
		this.LeiterBerechtigungBez = LeiterBerechtigungBez;
		this.idMitarbeiterBerechtigung = idMitarbeiterBerechtigung;
		this.MitarbeiterBerechtigungBez = MitarbeiterBerechtigungBez;
		this.HierarchieStufe = HierarchieStufe;
	}
}
