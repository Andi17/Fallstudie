package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class PasswortVergessen extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PasswortVergessen dialog = new PasswortVergessen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PasswortVergessen() {
		setTitle("Passwort vergessen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnSolltenSieIhr = new JTextPane();
			txtpnSolltenSieIhr.setEditable(false);
			//TODO Inhalt
			txtpnSolltenSieIhr.setText("Sollten Sie Ihr Passwort vergessen haben, kontaktieren Sie bitte Ihren Systemadministrator.  TODO");
			txtpnSolltenSieIhr.setBounds(6, 6, 438, 104);
			contentPanel.add(txtpnSolltenSieIhr);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(379, 123, 75, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}

}
