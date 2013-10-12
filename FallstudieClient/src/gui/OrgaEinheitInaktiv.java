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
public class OrgaEinheitInaktiv extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtOrgaEinheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrgaEinheitInaktiv dialog = new OrgaEinheitInaktiv();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrgaEinheitInaktiv() {
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
			txtOrgaEinheit = new JTextField();
			txtOrgaEinheit.setBounds(224, 57, 134, 28);
			contentPanel.add(txtOrgaEinheit);
			txtOrgaEinheit.setColumns(10);
		}
		{
			JLabel lblOrganisationseinheit = new JLabel("Organisationseinheit:");
			lblOrganisationseinheit.setBounds(67, 63, 145, 16);
			contentPanel.add(lblOrganisationseinheit);
		}
		{
			JButton okButton = new JButton("Inaktiv setzen");
			okButton.setBounds(199, 123, 132, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					//TODO Aktion
					String orgaEinheit = txtOrgaEinheit.getText();
					
					OrgaEinheitInaktivFrage OrgaEinheitInaktiv = new OrgaEinheitInaktivFrage();
					OrgaEinheitInaktiv.setVisible(true);
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(343, 123, 111, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JComboBox comboBoxOrgaEinheit = new JComboBox();
			comboBoxOrgaEinheit.setBounds(370, 59, 77, 27);
			contentPanel.add(comboBoxOrgaEinheit);
		}
	}

}
