package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BearbeitungBenutzerOrgaEinheitFrage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BearbeitungBenutzerOrgaEinheitFrage dialog = new BearbeitungBenutzerOrgaEinheitFrage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BearbeitungBenutzerOrgaEinheitFrage() {
		setTitle("Benutzer - Organisationseinheit \u00E4ndern");
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
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
					//TODO Exception Abfrage durch RŸckgabewert der DB
					// Methodenname - †bergabewerte - RŸckgabewert
					// benutzerOrgaEinheit Aendern - String benutzer, String passwort - boolean
					
					ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
					ErfolgEingabe.setVisible(true);
					dispose();
				}
			});
			okButton.setBounds(292, 123, 75, 29);
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
			cancelButton.setBounds(379, 123, 75, 29);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JTextPane txtpnWollenSieWirklich = new JTextPane();
			txtpnWollenSieWirklich.setText("Wollen Sie wirklich die Organisationseinheit \u00E4ndern?");
			txtpnWollenSieWirklich.setBounds(58, 16, 336, 22);
			contentPanel.add(txtpnWollenSieWirklich);
		}
		{
			JLabel lblBenutzername = new JLabel("Benutzername:");
			lblBenutzername.setBounds(58, 39, 117, 16);
			contentPanel.add(lblBenutzername);
		}
		{
			JLabel lblAlteOrganisationseinheit = new JLabel("Alte Organisationseinheit:");
			lblAlteOrganisationseinheit.setBounds(60, 67, 177, 16);
			contentPanel.add(lblAlteOrganisationseinheit);
		}
		{
			JLabel lblNeueOrganisationseinheit = new JLabel("Neue Organisationseinheit:");
			lblNeueOrganisationseinheit.setBounds(60, 95, 171, 16);
			contentPanel.add(lblNeueOrganisationseinheit);
		}
		{
			JLabel lblFiller = new JLabel("Filler");
			lblFiller.setBounds(244, 39, 61, 16);
			contentPanel.add(lblFiller);
		}
		{
			JLabel lblFiller_1 = new JLabel("Filler");
			lblFiller_1.setBounds(244, 67, 61, 16);
			contentPanel.add(lblFiller_1);
		}
		{
			JLabel lblFiller_2 = new JLabel("Filler");
			lblFiller_2.setBounds(243, 95, 61, 16);
			contentPanel.add(lblFiller_2);
		}
	}

}
