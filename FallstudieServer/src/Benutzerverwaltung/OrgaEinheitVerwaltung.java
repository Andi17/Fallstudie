package Benutzerverwaltung;

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

	// TODO HierarchieStufe  f�r Statistik einbauen!!!!!!
	//Noch unvollst�ndig!!!!
	public List<ComOrgaEinheit> getAlleOrgaEinheiten() {
		/*
		 * List<OrgaEinheit> ListOrga = dbZugriff.getOrgaEinheiten();
		 * List<ComOrgaEinheit> rueckgabe = new ArrayList<ComOrgaEinheit>(); for
		 * (OrgaEinheit orga : ListOrga) { Berechtigung Leiterber = dbZugriff
		 * .getBerechtigungzuidBerechtigung(orga .getIdLeiterBerechtigung());
		 * Berechtigung Mitarbeiterber = dbZugriff
		 * .getBerechtigungzuidBerechtigung(orga
		 * .getIdMitarbeiterBerechtigung()); if (Leiterber != null) { if
		 * (Mitarbeiterber != null) { rueckgabe.add(new
		 * ComOrgaEinheit(orga.getIdOrgaEinheit(), orga.getIdUeberOrgaEinheit(),
		 * orga .getOrgaEinheitBez(), orga.getLeitername(),
		 * orga.getIdLeiterBerechtigung(), Leiterber .getBerechtigungbez(), orga
		 * .getIdMitarbeiterBerechtigung(), Mitarbeiterber.getBerechtigungbez(),
		 * 0)); } else { rueckgabe.add(new
		 * ComOrgaEinheit(orga.getIdOrgaEinheit(), orga.getIdUeberOrgaEinheit(),
		 * orga .getOrgaEinheitBez(), orga.getLeitername(),
		 * orga.getIdLeiterBerechtigung(), Leiterber .getBerechtigungbez(), orga
		 * .getIdMitarbeiterBerechtigung(), "Keine Berechtigung", 0)); } } else
		 * { if (Mitarbeiterber != null) { rueckgabe.add(new
		 * ComOrgaEinheit(orga.getIdOrgaEinheit(), orga.getIdUeberOrgaEinheit(),
		 * orga .getOrgaEinheitBez(), orga.getLeitername(),
		 * orga.getIdLeiterBerechtigung(), "Keine Berechtigung", orga
		 * .getIdMitarbeiterBerechtigung(), Mitarbeiterber.getBerechtigungbez(),
		 * 0)); } else { rueckgabe.add(new
		 * ComOrgaEinheit(orga.getIdOrgaEinheit(), orga.getIdUeberOrgaEinheit(),
		 * orga .getOrgaEinheitBez(), orga.getLeitername(),
		 * orga.getIdLeiterBerechtigung(), "Keine Berechtigung", orga
		 * .getIdMitarbeiterBerechtigung(), "Keine Berechtigung", 0)); } } }
		 * return rueckgabe;
		 */
		List<ComOrgaEinheit> rueckgabe = new ArrayList<ComOrgaEinheit>();
		try {
			boolean wiederholen = true;
			int hierarchieEbene = 1;
			OrgaEinheit hoechsteOrgaEinheit = dbZugriff
					.getHoechsteOrgaEinheit();
			rueckgabe
					.add(new ComOrgaEinheit(hoechsteOrgaEinheit
							.getIdOrgaEinheit(), hoechsteOrgaEinheit
							.getIdUeberOrgaEinheit(), hoechsteOrgaEinheit
							.getOrgaEinheitBez(), hoechsteOrgaEinheit
							.getLeitername(), hoechsteOrgaEinheit
							.getIdLeiterBerechtigung(), hoechsteOrgaEinheit
							.getLeiterBerechtigungBezeichnung(),
							hoechsteOrgaEinheit.getIdMitarbeiterBerechtigung(),
							hoechsteOrgaEinheit
									.getMitarbeiterBerechtigungBezeichnung(),
							hierarchieEbene));
			while (wiederholen) {

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
		try {
			orgaEinheit = dbZugriff.getOrgaEinheitvonBezeichnung(bezeichnung);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (orgaEinheit == null)
			return false;
		else
			return true;
	}

}
