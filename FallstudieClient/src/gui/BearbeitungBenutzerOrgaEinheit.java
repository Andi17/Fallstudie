package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class BearbeitungBenutzerOrgaEinheit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBenutzername;
	private JTextField txtNeuOrganisationseinheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BearbeitungBenutzerOrgaEinheit dialog = new BearbeitungBenutzerOrgaEinheit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BearbeitungBenutzerOrgaEinheit() {
		setTitle("Benutzer - Organisationseinheit \u00E4ndern");
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtBenutzername = new JTextField();
			txtBenutzername.setColumns(10);
			txtBenutzername.setBounds(249, 30, 134, 28);
			contentPanel.add(txtBenutzername);
		}
		{
			JLabel label = new JLabel("Benutzername:");
			label.setBounds(77, 36, 107, 16);
			contentPanel.add(label);
		}
		{
			JLabel lblNeueOrganisationseinheit = new JLabel("Neue Organisationseinheit:");
			lblNeueOrganisationseinheit.setBounds(77, 64, 173, 16);
			contentPanel.add(lblNeueOrganisationseinheit);
		}
		{
			txtNeuOrganisationseinheit = new JTextField();
			txtNeuOrganisationseinheit.setColumns(10);
			txtNeuOrganisationseinheit.setBounds(249, 58, 134, 28);
			contentPanel.add(txtNeuOrganisationseinheit);
		}
		{
			JButton button = new JButton("\u00C4ndern");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// †bergeben von "benutzername" und "neuOrganisationseinheit" an "BearbeitungBenutzerOrgaEinheitFrage"
					String benutzername = txtBenutzername.getText();
					String neuOrganisationseinheit = txtNeuOrganisationseinheit.getText();
								
					BearbeitungBenutzerOrgaEinheitFrage BearbeitungBenutzerOrgaEinheitFrage = new BearbeitungBenutzerOrgaEinheitFrage();
					BearbeitungBenutzerOrgaEinheitFrage.setVisible(true);
					dispose();
				}
			});
			button.setActionCommand("OK");
			button.setBounds(77, 96, 134, 29);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Abbrechen");
			button.setActionCommand("Cancel");
			button.setBounds(262, 95, 134, 29);
			contentPanel.add(button);
		}
		{
			JComboBox comboBoxBenutzername = new JComboBox();
			comboBoxBenutzername.setBounds(377, 32, 77, 27);
			contentPanel.add(comboBoxBenutzername);
		}
		{
			JComboBox comboBoxOrganisationseinheit = new JComboBox();
			comboBoxOrganisationseinheit.setBounds(377, 60, 77, 27);
			contentPanel.add(comboBoxOrganisationseinheit);
		}
	}

}
