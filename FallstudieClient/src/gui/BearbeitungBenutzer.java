package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;

import Webservice.ComBenutzer;
import Webservice.ComOrgaEinheit;
import Webservice.Webservice;

@SuppressWarnings("serial")
public class BearbeitungBenutzer extends JDialog {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	
	private int idOrgaEinheit;
	private String benutzername;
	private String passwort;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPasswort;
	private JTextField txtBenutzername;
	private JTextField txtOrgaEinheit;
	private JComboBox comboBoxBenutzername;
	private String[] Combobezeichnung;
	private JComboBox comboBoxOrgaEinheit;
	private String[] CoboBezeichnungOrgaEinheit;
	private List<ComOrgaEinheit> OrgaEinheitListe;


	/**
	 * Create the dialog.
	 */
	public BearbeitungBenutzer(String Benutzername, String Passwort, Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}
	private void initialize(){
		
		setTitle("Benutzer - Passwort \u00E4ndern");
		setBackground(Color.WHITE);
		setResizable(false);
		setBounds(100, 100, 500, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtPasswort = new JTextField();
			txtPasswort.setBounds(250, 60, 100, 30);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
		}
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(50, 30, 200, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Neues Passwort:");
			lblNeuesPasswort.setBounds(50, 60, 200, 30);
			contentPanel.add(lblNeuesPasswort);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Neue OrganisationsEinheit:");
			lblNeuesPasswort.setBounds(50, 90, 200, 30);
			contentPanel.add(lblNeuesPasswort);
		}
		
		
		txtBenutzername = new JTextField();
		txtBenutzername.setBounds(250, 30, 100, 30);
		contentPanel.add(txtBenutzername);
		txtBenutzername.setColumns(1);
		txtOrgaEinheit = new JTextField();
		txtOrgaEinheit.setBounds(250, 90, 100, 30);
		contentPanel.add(txtOrgaEinheit);
		txtOrgaEinheit.setColumns(1);
		{
			JButton okButton = new JButton("\u00C4ndern");
			okButton.setBounds(50, 120, 100, 30);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// �bergeben von "benutzername" und "passwort" an "BearbeitungBenutzerFrage"
					benutzername = txtBenutzername.getText();
					passwort = txtPasswort.getText();
					try{
						idOrgaEinheit = Integer.parseInt(txtOrgaEinheit.getText());
						if (false == port.gibtesBenutzerschon(Benutzername, Passwort, benutzername)){
							txtBenutzername.setText("");
							txtPasswort.setText("");
							
						}
						else{ 
							BearbeitungBenutzerFrage BearbeitungBenutzerFrage = new BearbeitungBenutzerFrage(Benutzername, Passwort, port, benutzername, passwort, idOrgaEinheit);
							BearbeitungBenutzerFrage.setVisible(true);
							dispose();
						}
					}
					catch (NumberFormatException a){
						if (!port.gibtesBenutzerschon(Benutzername, Passwort, benutzername)){
							txtBenutzername.setText("");
							txtPasswort.setText("");
							
						}
						txtOrgaEinheit.setText("");
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(350, 120, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		List<ComBenutzer> BenutzerListe = port.getBenutzer(Benutzername, Passwort);
		Combobezeichnung = new String[BenutzerListe.size()];
		int zaehler = 0;
		for (ComBenutzer Ben : BenutzerListe){
			Combobezeichnung[zaehler] = Ben.getBenutzername();
			zaehler++;
		}
		comboBoxBenutzername = new JComboBox(Combobezeichnung);
		comboBoxBenutzername.addActionListener(new  ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtBenutzername.setText(Combobezeichnung[comboBoxBenutzername.getSelectedIndex()]);
				}
			});
		comboBoxBenutzername.setBounds(350, 30, 100, 30);
		contentPanel.add(comboBoxBenutzername);
		OrgaEinheitListe = port.getOrgaEinheiten(Benutzername, Passwort);
		CoboBezeichnungOrgaEinheit = new String[OrgaEinheitListe.size()];
		int zaehler2 = 0;
		for (ComOrgaEinheit Orga : OrgaEinheitListe){
			CoboBezeichnungOrgaEinheit[zaehler2] = Orga.getOrgaEinheitBez();
			zaehler2++;
		}
		comboBoxOrgaEinheit = new JComboBox(CoboBezeichnungOrgaEinheit);
		comboBoxOrgaEinheit.addActionListener(new  ActionListener() {
				public void actionPerformed(ActionEvent c) {
					txtOrgaEinheit.setText(""+OrgaEinheitListe.get(comboBoxOrgaEinheit.getSelectedIndex()).getIdOrgaEinheit());
				}
			});
		comboBoxOrgaEinheit.setBounds(350, 90, 100, 30);
		contentPanel.add(comboBoxOrgaEinheit);
	}
}
