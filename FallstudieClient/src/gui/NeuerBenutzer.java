package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class NeuerBenutzer extends JDialog {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBenutzername;
	private JTextField txtPasswort;
	private JTextField txtOrgaEinheit;



	/**
	 * Create the dialog.
	 */
	public NeuerBenutzer(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}
	private void initialize(){
		setTitle("Benutzer - Anlegen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtPasswort = new JTextField();
			txtPasswort.setBounds(217, 49, 134, 28);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
		}
		{
			txtBenutzername = new JTextField();
			txtBenutzername.setBounds(217, 21, 134, 28);
			contentPanel.add(txtBenutzername);
			txtBenutzername.setColumns(10);
		}
		{
			txtOrgaEinheit = new JTextField();
			txtOrgaEinheit.setBounds(217, 77, 134, 28);
			contentPanel.add(txtOrgaEinheit);
			txtOrgaEinheit.setColumns(10);
		}
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(50, 21, 150, 16);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblOrgaEinheit = new JLabel("OrganisationsEinheit");
			lblOrgaEinheit.setBounds(50, 77, 150, 16);
			contentPanel.add(lblOrgaEinheit);
		}
		{
			JLabel lblPasswort = new JLabel("Passwort:");
			lblPasswort.setBounds(50, 49, 150, 16);
			contentPanel.add(lblPasswort);
		}
		{
			JButton okButton = new JButton("Best\u00E4tigen");
			okButton.setBounds(222, 123, 109, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion	
					// †bergabe von "benutzer", "benutzername" und "passwort" an "NeuerBenutzerFrage"

					String neuerbenutzername = txtBenutzername.getText();
					String neuespasswort = txtPasswort.getText();
					
					
					NeuerBenutzerFrage NeuerBenutzerFrage = new NeuerBenutzerFrage(Benutzername, Passwort, port, txtBenutzername.getText(), txtPasswort.getText(), Integer.parseInt(txtOrgaEinheit.getText()));
					NeuerBenutzerFrage.setVisible(true);
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(343, 123, 111, 29);
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
