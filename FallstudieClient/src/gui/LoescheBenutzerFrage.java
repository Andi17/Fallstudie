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
import java.awt.Color;

@SuppressWarnings("serial")
public class LoescheBenutzerFrage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoescheBenutzerFrage dialog = new LoescheBenutzerFrage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoescheBenutzerFrage() {
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
			JLabel lblBenutzername = new JLabel("Benutzername");
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
					//TODO Exception Abfrage durch RŸckgabewert der DB
					// Methodenname - †bergabewerte - RŸckgabewert
					// benutzerLoeschen - String benutzer, String passwort, String zuLoeschenderBenutzer - boolean
					
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
