package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BearbeitungBenutzerFrage extends JDialog {

	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private String aenderungBenutzername;
	private String NeuerBenutzername;
	private String NeuesPasswort;
	private int idOrgaEinheit;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 * 
	 * @param neuerBenutzername
	 */
	public BearbeitungBenutzerFrage(String Benutzername, String Passwort,
			Webservice port, String aenderungBenutzername,
			String NeuesPasswort, String neuerBenutzername, int idOrgaEinheit) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.aenderungBenutzername = aenderungBenutzername;

		if (NeuesPasswort.equals("")) {
			this.NeuesPasswort = null;
		} else {
			this.NeuesPasswort = NeuesPasswort;
		}
		if (neuerBenutzername.equals("")) {
			this.NeuerBenutzername = null;
		} else {
			this.NeuerBenutzername = neuerBenutzername;
		}
		this.idOrgaEinheit = idOrgaEinheit;
		initialize();
	}

	private void initialize() {
		setTitle("Benutzer - Passwort \u00E4ndern");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 500, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Ja");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Aktion
					// TODO Exception Abfrage durch RŸckgabewert der DB
					// Methodenname - †bergabewerte - RŸckgabewert
					// neuesPasswortSetzen - String benutzer, String passwort,
					// String betroffenerBenutzer, String neuesPasswort -
					// boolean
					boolean passwortgeaendert = true;
					boolean orgageaendert = true;
					boolean neuername = true;
					if (NeuesPasswort != null) {
						passwortgeaendert = port.neuesPasswortSetzen(
								Benutzername, Passwort, aenderungBenutzername,
								NeuesPasswort);
					}
					if (idOrgaEinheit != 0) {
						orgageaendert = port.benutzerOrgaEinheitAendern(
								Benutzername, Passwort, aenderungBenutzername,
								idOrgaEinheit);
					}
					if (NeuerBenutzername != null) {
						neuername = port.benutzernameAendern(Benutzername,
								Passwort, aenderungBenutzername,
								NeuerBenutzername);
					}
					if (passwortgeaendert && orgageaendert && neuername) {
						ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
						ErfolgEingabe.setVisible(true);
						dispose();
					}
				}
			});
			okButton.setBounds(100, 180, 100, 30);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Nein");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(300, 180, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JTextPane txtBenutzername = new JTextPane();
			txtBenutzername.setText("Zu Aendernder Benutzer: "
					+ aenderungBenutzername);
			txtBenutzername.setBounds(50, 30, 400, 30);
			contentPanel.add(txtBenutzername);
		}
		if (NeuerBenutzername != null) {
			JTextPane txtBenutzername = new JTextPane();
			txtBenutzername.setText("Neuer Benutzername: " + NeuerBenutzername);
			txtBenutzername.setBounds(50, 60, 400, 30);
			contentPanel.add(txtBenutzername);
		}
		if (NeuesPasswort != null) {
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setText("Passwort wird geaendert");
			txtPasswort.setBounds(50, 90, 400, 30);
			contentPanel.add(txtPasswort);
		}
		if (idOrgaEinheit != 0) {
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setText("Organisationseinheit: " + idOrgaEinheit);
			txtPasswort.setBounds(50, 120, 400, 30);
			contentPanel.add(txtPasswort);
		}
		{
			JTextPane txtFrage = new JTextPane();
			txtFrage.setText("Benutzer aendern?");
			txtFrage.setBounds(50, 150, 400, 30);
			contentPanel.add(txtFrage);
		}
	}

}
