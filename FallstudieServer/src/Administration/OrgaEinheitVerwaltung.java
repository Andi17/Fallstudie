package Administration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.ComOrgaEinheit;
import Zugriffsschicht.Berechtigung;
import Zugriffsschicht.OrgaEinheit;
import Zugriffsschicht.Zugriffschicht;

public class OrgaEinheitVerwaltung {

	private Zugriffschicht dbZugriff;

	public OrgaEinheitVerwaltung(Zugriffschicht dbZugriff) {
		this.dbZugriff = dbZugriff;
	}

	// Gibt alle OrgaEinheiten zur�ck.
	public List<ComOrgaEinheit> getAlleOrgaEinheiten() {

		List<OrgaEinheit> ListOrga = dbZugriff.getOrgaEinheiten();
		List<ComOrgaEinheit> rueckgabe = new ArrayList<ComOrgaEinheit>();
		for (OrgaEinheit orga : ListOrga) {
			Berechtigung Leiterber = dbZugriff
					.getBerechtigungzuidBerechtigung(orga
							.getIdLeiterBerechtigung());
			Berechtigung Mitarbeiterber = dbZugriff
					.getBerechtigungzuidBerechtigung(orga
							.getIdMitarbeiterBerechtigung());
			if (Leiterber != null) {
				if (Mitarbeiterber != null) {
					rueckgabe.add(new ComOrgaEinheit(orga.getIdOrgaEinheit(),
							orga.getIdUeberOrgaEinheit(), orga
									.getOrgaEinheitBez(), orga.getLeitername(),
							orga.getIdLeiterBerechtigung(), Leiterber
									.getBerechtigungbez(), orga
									.getIdMitarbeiterBerechtigung(),
							Mitarbeiterber.getBerechtigungbez()));
				} else {
					rueckgabe.add(new ComOrgaEinheit(orga.getIdOrgaEinheit(),
							orga.getIdUeberOrgaEinheit(), orga
									.getOrgaEinheitBez(), orga.getLeitername(),
							orga.getIdLeiterBerechtigung(), Leiterber
									.getBerechtigungbez(), orga
									.getIdMitarbeiterBerechtigung(),
							"Keine Berechtigung"));
				}
			} else {
				if (Mitarbeiterber != null) {
					rueckgabe.add(new ComOrgaEinheit(orga.getIdOrgaEinheit(),
							orga.getIdUeberOrgaEinheit(), orga
									.getOrgaEinheitBez(), orga.getLeitername(),
							orga.getIdLeiterBerechtigung(),
							"Keine Berechtigung", orga
									.getIdMitarbeiterBerechtigung(),
							Mitarbeiterber.getBerechtigungbez()));
				} else {
					rueckgabe.add(new ComOrgaEinheit(orga.getIdOrgaEinheit(),
							orga.getIdUeberOrgaEinheit(), orga
									.getOrgaEinheitBez(), orga.getLeitername(),
							orga.getIdLeiterBerechtigung(),
							"Keine Berechtigung", orga
									.getIdMitarbeiterBerechtigung(),
							"Keine Berechtigung"));
				}
			}
		}
		return rueckgabe;

	}

	// f�gt neue OrgaEinheit hinzu, gibt true zur�ck wenn geklappt
	public boolean neueOrgaEinheit(int idUeberOrgaEinheit,
			String OrgaEinheitBez, String Leitername, int idLeiterBerechtigung,
			boolean Zustand, int idMitarbeiterBerechtigung) {
		OrgaEinheit orga = dbZugriff.erstelleOrgaEinheit(idUeberOrgaEinheit,
				OrgaEinheitBez, Leitername, idLeiterBerechtigung, Zustand,
				idMitarbeiterBerechtigung);
		if (orga == null)
			return false;
		else
			return true;
	}

	// Gibt true zur�ck wenn es schon eine OrgaEinheit mit der Bezeichnung gibt.
	public boolean gibtEsOrgaEinheit(String bezeichnung) {
		OrgaEinheit orgaEinheit = null;
		orgaEinheit = dbZugriff.getOrgaEinheitvonBezeichnung(bezeichnung);
		if (orgaEinheit == null)
			return false;
		else
			return true;
	}

}
