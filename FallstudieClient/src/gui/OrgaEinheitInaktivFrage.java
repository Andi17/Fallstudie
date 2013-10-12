package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class OrgaEinheitInaktivFrage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrgaEinheitInaktivFrage dialog = new OrgaEinheitInaktivFrage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrgaEinheitInaktivFrage() {
		setTitle("Organisationseinheit - Deaktivieren");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblOrgaeinheit = new JLabel("OrgaEinheit");
			lblOrgaeinheit.setBounds(178, 59, 153, 16);
			contentPanel.add(lblOrgaeinheit);
		}
		{
			JTextPane txtpnWollenSieDie = new JTextPane();
			txtpnWollenSieDie.setEditable(false);
			txtpnWollenSieDie.setBackground(Color.WHITE);
			txtpnWollenSieDie.setText("Wollen Sie die folgende Organisationseinheit wirklich deaktivieren?");
			txtpnWollenSieDie.setBounds(19, 22, 435, 109);
			contentPanel.add(txtpnWollenSieDie);
		}
		{
			JButton btnJa = new JButton("Ja");
			btnJa.setBounds(292, 123, 75, 29);
			contentPanel.add(btnJa);
			{
				JButton okButton = new JButton("Nein");
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
			btnJa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					//TODO Exception Abfrage durch RŸckgabewert der DB
					ErfolgEingabe ErfolgEingabe = new ErfolgEingabe();
					ErfolgEingabe.setVisible(true);
		
					dispose();
				}
			});
		}
	}

}
