package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Webservice.Webservice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class NeueOrgaEinheit extends JDialog {

	private String Benutzername;
	private String Passwort;
	private Webservice port;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNeueOrgaEinheit;
	private JTextField txtNeueOrgaEinheitLeiter;
	private JTextField txtUeberOrgaEinheit;
	private JTextField txtRechteLeiter;
	private JTextField txtRechteMitarbeiter;

	/**
	 * Create the dialog.
	 * @param port 
	 * @param passwort 
	 * @param benutzername 
	 */
	public NeueOrgaEinheit(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}
		
		public void initialize(){
		setTitle("Organisationseinheit - Anlegen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 481, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNeueOrganisationseinheit = new JLabel("Neue Organisationseinheit:");
			lblNeueOrganisationseinheit.setBounds(79, 12, 182, 16);
			contentPanel.add(lblNeueOrganisationseinheit);
		}
		{
			txtNeueOrgaEinheit = new JTextField();
			txtNeueOrgaEinheit.setBounds(273, 6, 134, 28);
			contentPanel.add(txtNeueOrgaEinheit);
			txtNeueOrgaEinheit.setColumns(10);
		}
		{
			JButton okButton = new JButton("Best\u00E4tigen");
			okButton.setBounds(253, 164, 109, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// †bergabe von "orgaEinheit" an "NeueOrgaEinheit"
					
					String neueOrgaEinheit = txtNeueOrgaEinheit.getText();			
					neueOrgaEinheit = "";
					try{
						neueOrgaEinheit = txtNeueOrgaEinheit.getText();
						if (port.gibtesOrgaEinheitschon(Benutzername, Passwort, neueOrgaEinheit)){
							txtNeueOrgaEinheit.setText("");
							txtNeueOrgaEinheitLeiter.setText("");
							txtUeberOrgaEinheit.setText("");
						}
						else{											
							NeueOrgaEinheitFrage NeueOrgaEinheitFrage = new NeueOrgaEinheitFrage(Benutzername, Passwort, port, txtNeueOrgaEinheit.getText(), Integer.parseInt(txtNeueOrgaEinheitLeiter.getText()), Integer.parseInt(txtUeberOrgaEinheit.getText()), Integer.parseInt(txtRechteLeiter.getText()), Integer.parseInt(txtRechteMitarbeiter.getText()));
							NeueOrgaEinheitFrage.setVisible(true);
							dispose();
						}
					}
					catch (NumberFormatException a){
						txtNeueOrgaEinheit.setText("");
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(363, 164, 111, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			txtNeueOrgaEinheitLeiter = new JTextField();
			txtNeueOrgaEinheitLeiter.setBounds(273, 34, 134, 28);
			contentPanel.add(txtNeueOrgaEinheitLeiter);
			txtNeueOrgaEinheitLeiter.setColumns(10);
		}
		{
			txtUeberOrgaEinheit = new JTextField();
			txtUeberOrgaEinheit.setBounds(273, 63, 134, 28);
			contentPanel.add(txtUeberOrgaEinheit);
			txtUeberOrgaEinheit.setColumns(10);
		}
		{
			JLabel lblOrganisationseinheitsleiter = new JLabel("Organisationseinheitsleiter:");
			lblOrganisationseinheitsleiter.setBounds(79, 40, 182, 16);
			contentPanel.add(lblOrganisationseinheitsleiter);
		}
		{
			JLabel lblbergeordneteOrganisationseinheit = new JLabel("\u00DCbergeordnete OrganisationseinheitsID:");
			lblbergeordneteOrganisationseinheit.setBounds(6, 69, 255, 16);
			contentPanel.add(lblbergeordneteOrganisationseinheit);
		}
		{
			txtRechteLeiter = new JTextField();
			txtRechteLeiter.setBounds(273, 92, 134, 28);
			contentPanel.add(txtRechteLeiter);
			txtRechteLeiter.setColumns(10);
		}
		{
			txtRechteMitarbeiter = new JTextField();
			txtRechteMitarbeiter.setBounds(273, 124, 134, 28);
			contentPanel.add(txtRechteMitarbeiter);
			txtRechteMitarbeiter.setColumns(10);
		}
		{
			JLabel lblRechteDesLeiters = new JLabel("Rechte des Leiters:");
			lblRechteDesLeiters.setBounds(133, 97, 128, 16);
			contentPanel.add(lblRechteDesLeiters);
		}
		{
			JLabel lblRechteDerMitarbeiter = new JLabel("Rechte der Mitarbeiter:");
			lblRechteDerMitarbeiter.setBounds(108, 130, 153, 16);
			contentPanel.add(lblRechteDerMitarbeiter);
		}
	}

}
