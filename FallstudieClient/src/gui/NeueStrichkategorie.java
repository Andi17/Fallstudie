package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class NeueStrichkategorie extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStrichkategorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NeueStrichkategorie dialog = new NeueStrichkategorie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NeueStrichkategorie() {
		setTitle("Strichkategorie - Anlegen");
		//TODO Inhalt
		setResizable(false);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Strichkategorie hinzuf\u00FCgen");
			okButton.setBounds(136, 123, 202, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Aktion
					// †bergabe von "strichkategorie" an "NeueStrichkategorieFrage"
					String strichkategorie = txtStrichkategorie.getText();
					
					
					NeueStrichkategorieFrage SystemKonfigurationFrage = new NeueStrichkategorieFrage();
					SystemKonfigurationFrage.setVisible(true);
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Abbrechen");
			cancelButton.setBounds(350, 123, 104, 29);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblNeueStrichkategorie = new JLabel("Neue Strichkategorie:");
			lblNeueStrichkategorie.setBounds(55, 57, 142, 16);
			contentPanel.add(lblNeueStrichkategorie);
		}
		{
			txtStrichkategorie = new JTextField();
			txtStrichkategorie.setBounds(209, 51, 202, 28);
			contentPanel.add(txtStrichkategorie);
			txtStrichkategorie.setColumns(10);
		}
	}

}
