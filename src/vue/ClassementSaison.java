package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ClassementSaison extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassementSaison frame = new ClassementSaison();
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
	public ClassementSaison() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassementSaison = new JLabel("Classement Saison");
		lblClassementSaison.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblClassementSaison.setBounds(179, 23, 224, 36);
		contentPane.add(lblClassementSaison);
		
		JLabel lblRallye = new JLabel("Saison:");
		lblRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRallye.setBounds(61, 75, 72, 18);
		contentPane.add(lblRallye);
		
		JComboBox cBoxRallye = new JComboBox();
		cBoxRallye.setBounds(147, 72, 103, 24);
		contentPane.add(cBoxRallye);
	}

}
