package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import Webservice.Webservice;

import java.awt.Color;

@SuppressWarnings("serial")
public class LoescheBenutzerFrage extends JDialog {
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	private String loescheBenutzer;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public LoescheBenutzerFrage(String Benutzername, String Passwort,
			Webservice port, String loescheBenutzer) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		this.loescheBenutzer = loescheBenutzer;
		initialize();
	}
	private void initialize(){
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnWollenSieDen = new JTextPane();
			txtpnWollenSieDen.setEditable(false);
			txtpnWollenSieDen.setText("Wollen Sie den folgenden Benutzer wirklich loeschen?");
			txtpnWollenSieDen.setBounds(59, 20, 383, 22);
			contentPanel.add(txtpnWollenSieDen);
		}
		{
			JLabel lblBenutzername = new JLabel(loescheBenutzer);
			lblBenutzername.setBounds(186, 69, 101, 16);
			contentPanel.add(lblBenutzername);
		}
		{
			JButton okButton = new JButton("Ja");
			okButton.setBounds(292, 123, 75, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					//TODO Aktion
					//TODO Exception Abfrage durch R�ckgabewert der DB
					// Methodenname - �bergabewerte - R�ckgabewert
					// benutzerLoeschen - String benutzer, String passwort, String zuLoeschenderBenutzer - boolean
					if (port.benutzerLoeschen(Benutzername, Passwort, loescheBenutzer)){
						System.out.println("Benutzer gel�scht");
					}
					else{
						System.out.println("Benutzer nicht gel�scht");
					}
						
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Nein");
			cancelButton.setBounds(379, 123, 75, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
	}

}
