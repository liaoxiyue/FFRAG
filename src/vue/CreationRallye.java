package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreationRallye extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomRallye;
	private JTextField txtVille;
	private JTextField txtPays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationRallye frame = new CreationRallye();
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
	public CreationRallye() {
		setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrationRallye = new JLabel("Cr\u00E9ation Rallye");
		lblCrationRallye.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblCrationRallye.setBounds(10, 10, 140, 36);
		contentPane.add(lblCrationRallye);
		
		JLabel lblNomRallye = new JLabel("Nom Rallye");
		lblNomRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNomRallye.setBounds(20, 90, 76, 30);
		contentPane.add(lblNomRallye);
		
		JLabel lblVillePrincipale = new JLabel("Ville Principale");
		lblVillePrincipale.setFont(new Font("Calibri", Font.BOLD, 15));
		lblVillePrincipale.setBounds(20, 147, 104, 30);
		contentPane.add(lblVillePrincipale);
		
		JLabel lblPaysPrincipale = new JLabel("Pays Principale");
		lblPaysPrincipale.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPaysPrincipale.setBounds(20, 202, 104, 30);
		contentPane.add(lblPaysPrincipale);
		
		txtNomRallye = new JTextField();
		txtNomRallye.setBounds(154, 90, 151, 30);
		contentPane.add(txtNomRallye);
		txtNomRallye.setColumns(10);
		
		txtVille = new JTextField();
		txtVille.setColumns(10);
		txtVille.setBounds(154, 147, 151, 30);
		contentPane.add(txtVille);
		
		txtPays = new JTextField();
		txtPays.setColumns(10);
		txtPays.setBounds(154, 206, 151, 30);
		contentPane.add(txtPays);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(new Font("Calibri", Font.BOLD, 15));
		btnEnregistrer.setForeground(Color.BLACK);
		btnEnregistrer.setBackground(Color.LIGHT_GRAY);
		btnEnregistrer.setBounds(154, 281, 109, 30);
		contentPane.add(btnEnregistrer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(Color.BLACK);
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 15));
		btnAnnuler.setBackground(Color.LIGHT_GRAY);
		btnAnnuler.setBounds(295, 281, 109, 30);
		contentPane.add(btnAnnuler);
	}
}
