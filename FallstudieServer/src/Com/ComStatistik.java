package Com;

public class ComStatistik {
	private int idOrgaEinheit;
	private String OrgaEinheitBez;
	private int KalenderWoche;
	private int Jahr;
	private String StrichBez;
	private int Strichzahl;
	private int Hierarchiestufe;
	
	public ComStatistik(int idOrgaEinheit, String OrgaEinheitBez, int KalenderWoche, int Jahr, String StrichBez, int Strichzahl, int Hierarchiestufe){
		this.idOrgaEinheit = idOrgaEinheit;
		this.OrgaEinheitBez = OrgaEinheitBez;
		this.KalenderWoche = KalenderWoche;
		this.Jahr = Jahr;
		this.StrichBez = StrichBez;
		this.Strichzahl = Strichzahl;
		this.Hierarchiestufe = Hierarchiestufe;
	}

	public int getIdOrgaEinheit() {
		return idOrgaEinheit;
	}

	public void setIdOrgaEinheit(int idOrgaEinheit) {
		this.idOrgaEinheit = idOrgaEinheit;
	}

	public String getOrgaEinheitBez() {
		return OrgaEinheitBez;
	}

	public int getKalenderWoche() {
		return KalenderWoche;
	}

	public int getJahr() {
		return Jahr;
	}

	public String getStrichBez() {
		return StrichBez;
	}

	public int getStrichzahl() {
		return Strichzahl;
	}

	public int getHierarchiestufe() {
		return Hierarchiestufe;
	}

	public void setOrgaEinheitBez(String orgaEinheitBez) {
		OrgaEinheitBez = orgaEinheitBez;
	}

	public void setKalenderWoche(int kalenderWoche) {
		KalenderWoche = kalenderWoche;
	}

	public void setJahr(int jahr) {
		Jahr = jahr;
	}

	public void setStrichBez(String strichBez) {
		StrichBez = strichBez;
	}

	public void setStrichzahl(int strichzahl) {
		Strichzahl = strichzahl;
	}

	public void setHierarchiestufe(int hierarchiestufe) {
		Hierarchiestufe = hierarchiestufe;
	}

}
