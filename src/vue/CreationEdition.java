package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.FFRAG;
import FFRAG.Rallye;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreationEdition extends JFrame {

	private JPanel contentPane;
	private FFRAG ffrag;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CreationEdition(FFRAG ffrag) {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrationEdition = new JLabel("Cr\u00E9ation Edition");
		lblCrationEdition.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblCrationEdition.setBounds(10, 10, 159, 21);
		contentPane.add(lblCrationEdition);
		
		JComboBox comboBox = new JComboBox();
		String[] listRallye = new String[ffrag.getListRallye().size()+1];
		for(int i = 1; i <= ffrag.getListRallye().size(); i++) {
			listRallye[i] = ffrag.getListRallye().get(i-1).getNomRallye();
		}
		comboBox.setModel(new DefaultComboBoxModel(listRallye));
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 39, 141, 30);
		contentPane.add(comboBox);
	}
}
