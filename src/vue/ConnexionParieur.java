package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.FFRAG;
import FFRAG.Parieur;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnexionParieur extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtMdp;
	private FFRAG ffrag;
	private Parieur parieur;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionParieur frame = new ConnexionParieur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ConnexionParieur(FFRAG ffrag) {
		this.ffrag = ffrag;
		this.parieur = null;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnexionSystemeDe = new JLabel("Connectez-vous ид votre espace");
		lblConnexionSystemeDe.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblConnexionSystemeDe.setBounds(93, 13, 249, 36);
		contentPane.add(lblConnexionSystemeDe);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(73, 80, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblMdp = new JLabel("Mdp");
		lblMdp.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblMdp.setBounds(73, 115, 72, 18);
		contentPane.add(lblMdp);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(134, 76, 194, 24);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtMdp = new JTextField();
		txtMdp.setBounds(134, 115, 194, 24);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							InscriptionParieur frame = new InscriptionParieur(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSinscrire.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnSinscrire.setBounds(75, 164, 113, 27);
		contentPane.add(btnSinscrire);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = txtEmail.getText();
				String mdp = txtMdp.getText();
				for(Parieur p: ffrag.getListParieur()) {
					if(p.getMail().equals(mail) && p.getMdp().equals(mdp)) {
						parieur = p;
						break;
					}
				}
				if(parieur==null) {
					System.out.println("Vous n'etez pas membre ? Inscrivez-vous vite !");
					dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								InscriptionParieur frame = new InscriptionParieur(ffrag);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}else {
					dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ParierFrame frame = new ParierFrame(ffrag, parieur);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnConnexion.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnConnexion.setBounds(229, 163, 113, 27);
		contentPane.add(btnConnexion);
	}

}
