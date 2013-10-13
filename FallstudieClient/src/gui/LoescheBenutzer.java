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
import Webservice.Webservice;

@SuppressWarnings("serial")
public class LoescheBenutzer extends JDialog {
	
	private String Benutzername;
	private String Passwort;
	private Webservice port;
	
	private String loeschenBenutzer;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBenutzername;
	private String[] Combobezeichnung;
	private JComboBox comboBoxBenutzername;


	/**
	 * Create the dialog.
	 */
	public LoescheBenutzer(String Benutzername, String Passwort,
			Webservice port) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.port = port;
		initialize();
	}
	public void initialize(){
		setTitle("Benutzer - Loeschen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtBenutzername = new JTextField();
			txtBenutzername.setBounds(200, 30, 100, 30);
			contentPanel.add(txtBenutzername);
			txtBenutzername.setColumns(10);
		}
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(50, 30, 150, 30);
			contentPanel.add(lblBenutzername);
		}
		{
			JButton okButton = new JButton("Loeschen!");
			okButton.setBounds(200, 100, 100, 30);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// †bergabe von "benutzername" an "LoescheBenutzerFrage"
					loeschenBenutzer = txtBenutzername.getText();
					if ( port.gibtesBenutzerschon(Benutzername, Passwort, loeschenBenutzer)){
					
					LoescheBenutzerFrage LoescheBenutzerFrage = new LoescheBenutzerFrage(Benutzername, Passwort, port, loeschenBenutzer);
					LoescheBenutzerFrage.setVisible(true);
					dispose();
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(300, 100, 100, 30);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		List<ComBenutzer> BenutzerListe = port.getBenutzer(Benutzername,
				Passwort);
		Combobezeichnung = new String[BenutzerListe.size()];
		int zaehler = 0;
		for (ComBenutzer Ben : BenutzerListe) {
			Combobezeichnung[zaehler] = Ben.getBenutzername();
			zaehler++;
		}
		comboBoxBenutzername = new JComboBox(Combobezeichnung);
		comboBoxBenutzername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBenutzername.setText(Combobezeichnung[comboBoxBenutzername
						.getSelectedIndex()]);
			}
		});
		comboBoxBenutzername.setBounds(350, 30, 100, 30);
		contentPanel.add(comboBoxBenutzername);
	}

}
