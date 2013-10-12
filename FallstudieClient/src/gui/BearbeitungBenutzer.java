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
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class BearbeitungBenutzer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPasswort;
	private JTextField txtBenutzername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BearbeitungBenutzer dialog = new BearbeitungBenutzer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BearbeitungBenutzer() {
		setTitle("Benutzer - Passwort \u00E4ndern");
		setBackground(Color.WHITE);
		setResizable(false);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtPasswort = new JTextField();
			txtPasswort.setBounds(222, 60, 134, 28);
			contentPanel.add(txtPasswort);
			txtPasswort.setColumns(10);
		}
		{
			JLabel lblNeuesPasswort = new JLabel("Neues Passwort:");
			lblNeuesPasswort.setBounds(103, 66, 118, 16);
			contentPanel.add(lblNeuesPasswort);
		}
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(103, 41, 107, 16);
			contentPanel.add(lblBenutzername);
		}
		
		txtBenutzername = new JTextField();
		txtBenutzername.setBounds(222, 35, 134, 28);
		contentPanel.add(txtBenutzername);
		txtBenutzername.setColumns(10);
		{
			JButton okButton = new JButton("\u00C4ndern");
			okButton.setBounds(103, 101, 109, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// †bergeben von "benutzername" und "passwort" an "BearbeitungBenutzerFrage"
					String benutzername = txtBenutzername.getText();
					String passwort = txtPasswort.getText();
					
					
					BearbeitungBenutzerFrage BearbeitungBenutzerFrage = new BearbeitungBenutzerFrage();
					BearbeitungBenutzerFrage.setVisible(true);
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(245, 101, 111, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		JComboBox comboBoxBenutzername = new JComboBox();
		comboBoxBenutzername.setBounds(368, 37, 77, 27);
		contentPanel.add(comboBoxBenutzername);
	}
}
