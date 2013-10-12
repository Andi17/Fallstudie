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
		setBounds(100, 100, 500, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(50, 20, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblPasswort = new JLabel("Passwort:");
			lblPasswort.setBounds(50, 50, 150, 30);
			contentPanel.add(lblPasswort);
		}
		{
			JLabel lblOrgaEinheit = new JLabel("OrganisationsEinheit");
			lblOrgaEinheit.setBounds(50, 80, 150, 30);
			contentPanel.add(lblOrgaEinheit);
		}
		{
			txtBenutzername = new JTextField();
			txtBenutzername.setBounds(201, 20, 150, 30);
			contentPanel.add(txtBenutzername);
			txtBenutzername.setColumns(10);
		}
		{
			txtPasswort = new JTextField();
			txtPasswort.setBounds(201, 50, 150, 30);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
		}
		{
			txtOrgaEinheit = new JTextField();
			txtOrgaEinheit.setBounds(201, 80, 150, 30);
			contentPanel.add(txtOrgaEinheit);
			txtOrgaEinheit.setColumns(10);
		}

		{
			JButton okButton = new JButton("Best\u00E4tigen");
			okButton.setBounds(201, 120, 100, 30);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion	
					// �bergabe von "benutzer", "benutzername" und "passwort" an "NeuerBenutzerFrage"

					String neuerbenutzername = txtBenutzername.getText();
					String neuespasswort = txtPasswort.getText();
					int orgaEinheit = 0;
					try{
						orgaEinheit = Integer.parseInt(txtOrgaEinheit.getText());
						if (port.gibtesBenutzerschon(Benutzername, Passwort, neuerbenutzername)){
							txtBenutzername.setText("");
							txtPasswort.setText("");
							
						}
						else{
							
						
						
						NeuerBenutzerFrage NeuerBenutzerFrage = new NeuerBenutzerFrage(Benutzername, Passwort, port, txtBenutzername.getText(), txtPasswort.getText(), orgaEinheit);
						NeuerBenutzerFrage.setVisible(true);
						dispose();
						}
					}
					catch (NumberFormatException a){
						txtOrgaEinheit.setText("");
					}
					
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(351, 120, 100, 30);
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
