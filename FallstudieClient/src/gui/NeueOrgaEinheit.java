package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class NeueOrgaEinheit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtOrgaEinheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NeueOrgaEinheit dialog = new NeueOrgaEinheit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NeueOrgaEinheit() {
		setTitle("Organisationseinheit - Anlegen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 480, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNeueOrganisationseinheit = new JLabel("Neue Organisationseinheit:");
			lblNeueOrganisationseinheit.setBounds(79, 54, 182, 16);
			contentPanel.add(lblNeueOrganisationseinheit);
		}
		{
			txtOrgaEinheit = new JTextField();
			txtOrgaEinheit.setBounds(273, 48, 134, 28);
			contentPanel.add(txtOrgaEinheit);
			txtOrgaEinheit.setColumns(10);
		}
		{
			JButton okButton = new JButton("Best\u00E4tigen");
			okButton.setBounds(253, 103, 109, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// †bergabe von "orgaEinheit" an "NeueOrgaEinheit"
					String orgaEinheit = txtOrgaEinheit.getText();
					
					
					NeueOrgaEinheitFrage NeueOrgaEinheitFrage = new NeueOrgaEinheitFrage();
					NeueOrgaEinheitFrage.setVisible(true);
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(363, 103, 111, 29);
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
