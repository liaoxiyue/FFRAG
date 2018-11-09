package vue;

import FFRAG.Parieur;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.Edition;
import FFRAG.FFRAG;
import FFRAG.Parieur;
import FFRAG.Participant;
import FFRAG.Rallye;
import FFRAG.Voiture;
import RunRallye.CSV;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class InscriptionParieur extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;
	private JTextField txtMdp;
	private JTextField txtTel;
	private JTextField txtPrenom;
	private JTextField txtNf;
	private JTextField txtVille;
	private JTextField txtPays;
	private static FFRAG ffrag;
	private Parieur parieur;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
	
	
}*/
	
	/**
	 * Create the frame.
	 */
	public InscriptionParieur(FFRAG ffrag) {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMail = new JTextField();
		txtMail.setBounds(262, 225, 145, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblmail = new JLabel("Adresse mail");
		lblmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblmail.setBounds(142, 228, 106, 14);
		contentPane.add(lblmail);
		
		txtMdp = new JTextField();
		txtMdp.setBounds(262, 256, 145, 20);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		JLabel lblmdp = new JLabel("Mot de passe");
		lblmdp.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblmdp.setBounds(142, 258, 96, 17);
		contentPane.add(lblmdp);
		
		JButton btnConParieur = new JButton("S'inscrire");
		btnConParieur.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnConParieur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		btnConParieur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ffrag.getListParieur().add(
						new Parieur(txtNf.getText(), txtPrenom.getText(), txtTel.getText(), txtVille.getText(), txtPays.getText(), txtMail.getText(), txtMdp.getText()));
				System.out.println("Le parieur "+ffrag.getListParieur().get(ffrag.getListParieur().size()-1).getNom());
				txtNf.setText("");
				txtPrenom.setText("");
				txtTel.setText("");
				txtVille.setText("");
				txtPays.setText("");
				txtMail.setText("");
				txtMdp.setText("");
				dispose();
				CSV.enregistreParieur(ffrag,ffrag.getCsvPath());
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ConnexionParieur frame = new ConnexionParieur(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		btnConParieur.setBounds(185, 302, 168, 27);
		contentPane.add(btnConParieur);
		
		txtTel = new JTextField();
		txtTel.setBounds(262, 144, 145, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblTel = new JLabel("No Telephone");
		lblTel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTel.setBounds(142, 147, 138, 14);
		contentPane.add(lblTel);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPrenom.setBounds(142, 89, 96, 14);
		contentPane.add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(262, 86, 145, 20);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		JLabel lblTitreIns = new JLabel("INSCRIVEZ-VOUS POUR PARIER");
		lblTitreIns.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblTitreIns.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitreIns.setBounds(103, 24, 304, 44);
		contentPane.add(lblTitreIns);
		
		JLabel lblNom = new JLabel("Nom de famille");
		lblNom.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNom.setBounds(142, 117, 125, 14);
		contentPane.add(lblNom);
		
		txtNf = new JTextField();
		txtNf.setBounds(262, 113, 145, 20);
		contentPane.add(txtNf);
		txtNf.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblVille.setBounds(142, 178, 46, 14);
		contentPane.add(lblVille);
		
		txtVille = new JTextField();
		txtVille.setBounds(262, 175, 145, 20);
		contentPane.add(txtVille);
		txtVille.setColumns(10);
		
		JLabel lblPays = new JLabel("Pays");
		lblPays.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPays.setBounds(142, 203, 46, 14);
		contentPane.add(lblPays);
		
		txtPays = new JTextField();
		txtPays.setBounds(262, 200, 145, 20);
		contentPane.add(txtPays);
		txtPays.setColumns(10);
	}
}
