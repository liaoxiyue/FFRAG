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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationEdition frame = new CreationEdition();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		String[] listRallye = new String[]{};
		for(int i = 0; i < ffrag.getListRallye().size(); i++) {
			listRallye[i] = ffrag.getListRallye().get(i).getNomRallye();
		}
		comboBox.setModel(new DefaultComboBoxModel(listRallye));
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 39, 141, 30);
		contentPane.add(comboBox);
	}
}
