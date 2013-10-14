package Benutzerverwaltung;

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

	// TODO HierarchieStufe einbauen!!!!!!
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
							Mitarbeiterber.getBerechtigungbez(), 0));
				} else {
					rueckgabe.add(new ComOrgaEinheit(orga.getIdOrgaEinheit(),
							orga.getIdUeberOrgaEinheit(), orga
									.getOrgaEinheitBez(), orga.getLeitername(),
							orga.getIdLeiterBerechtigung(), Leiterber
									.getBerechtigungbez(), orga
									.getIdMitarbeiterBerechtigung(),
							"Keine Berechtigung", 0));
				}
			} else {
				if (Mitarbeiterber != null) {
					rueckgabe.add(new ComOrgaEinheit(orga.getIdOrgaEinheit(),
							orga.getIdUeberOrgaEinheit(), orga
									.getOrgaEinheitBez(), orga.getLeitername(),
							orga.getIdLeiterBerechtigung(),
							"Keine Berechtigung", orga
									.getIdMitarbeiterBerechtigung(),
							Mitarbeiterber.getBerechtigungbez(), 0));
				} else {
					rueckgabe.add(new ComOrgaEinheit(orga.getIdOrgaEinheit(),
							orga.getIdUeberOrgaEinheit(), orga
									.getOrgaEinheitBez(), orga.getLeitername(),
							orga.getIdLeiterBerechtigung(),
							"Keine Berechtigung", orga
									.getIdMitarbeiterBerechtigung(),
							"Keine Berechtigung", 0));
				}
			}
		}
		return rueckgabe;
	}

	public boolean neueOrgaEinheit(int UeberOE, String OEbezeichnung,
			int Inhaberberechtigung, int idInhaber, int Zustand) {

		/*
		 * Rückgabe ist entweder true für geklappt oder false für fehlgeschlagen
		 * Fehlgeschlagen wegen follgender Gründe: -Keine Rechte zum schreiben
		 * -Datenbank offline -Andere Fehler
		 */
		return false;
	}
	
	public boolean gibtEsOrgaEinheit(String bezeichnung){
		return false;
	}

}
