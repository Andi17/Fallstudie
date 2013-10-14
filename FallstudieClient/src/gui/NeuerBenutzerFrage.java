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
public class NeuerBenutzerFrage extends JDialog {
	
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private String NeuerBenutzername;
	private String NeuesPasswort;
	private int idOrgaEinheit;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public NeuerBenutzerFrage(String Benutzername, String Passwort, Webservice port, String NeuerBenutzername, String NeuesPasswort, int idOrgaEinheit) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.NeuerBenutzername = NeuerBenutzername;
		this.NeuesPasswort = NeuesPasswort;
		this.idOrgaEinheit = idOrgaEinheit;
		initialize();
	}
	private void initialize(){
		setTitle("Benutzer - Anlegen");
		setBackground(Color.WHITE);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Ja");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					//TODO Exception Abfrage durch R�ckgabewert der DB
					// Methodenname - �bergabewerte - R�ckgabewete
					// benutzerErstellen - String benutzer, String passwort, String benutzername, String neuerBenutzerPasswort, int idOE - boolean
					if(port.benutzerErstellen(Benutzername, Passwort, NeuerBenutzername, NeuesPasswort, idOrgaEinheit)){
					ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
					ErfolgEingabe.setVisible(true);
					dispose();
					}
					else{
		        		AnwendungAbbruch frmAnwendungAbbruch = new AnwendungAbbruch();
		    			frmAnwendungAbbruch.setVisible(true); 
		    			dispose();
					}
				}
			});
			okButton.setBounds(103, 220, 100, 30);
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
			cancelButton.setBounds(303, 220, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JTextPane txtBenutzername = new JTextPane();
			txtBenutzername.setText("Benutzername:         "+NeuerBenutzername);
			txtBenutzername.setBounds(50, 30, 400, 30);
			contentPanel.add(txtBenutzername);
		}
		{
			JTextPane txtPasswort = new JTextPane();
			txtPasswort.setText("Organisationseinheit: "+idOrgaEinheit);
			txtPasswort.setBounds(50, 60, 400, 30);
			contentPanel.add(txtPasswort);
		}
		{
			JTextPane txtFrage = new JTextPane();
			txtFrage.setText("Benutzer erstellen?");
			txtFrage.setBounds(193, 122, 117, 30);
			contentPanel.add(txtFrage);
		}
	}

}
