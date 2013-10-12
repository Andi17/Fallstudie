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
public class AnmeldungFalsch extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AnmeldungFalsch dialog = new AnmeldungFalsch();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AnmeldungFalsch() {
		setTitle("Login - Fehlgeschlagen");
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 460, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnDieAnmeldungWar = new JTextPane();
			txtpnDieAnmeldungWar.setEditable(false);
			txtpnDieAnmeldungWar.setBackground(Color.WHITE);
			txtpnDieAnmeldungWar.setBounds(6, 6, 438, 89);
			//TODO Inhalt
			txtpnDieAnmeldungWar.setText("\n\n    Die Anmeldung war fehlerhaft. Versuchen Sie es erneut\n    oder wenden Sie sich an Ihren Systemadministrator.");
			contentPanel.add(txtpnDieAnmeldungWar);
		}
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
		{
			JButton button = new JButton("?");
			button.setBounds(6, 123, 29, 29);
			contentPanel.add(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AnmeldungFalschHilfe frmAnmeldungFalschHilfe = new AnmeldungFalschHilfe();
		        	frmAnmeldungFalschHilfe.setVisible(true); 
				}
			});
		}
	}

}
