package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.Coureur;
import FFRAG.FFRAG;
import RunRallye.CSV;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CoureurIns extends JFrame {

	private JPanel contentPane;
	private FFRAG ffrag;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtDateNe;
	private JTextField txtNat;
	private JTextField txtSan;
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoureurIns frame = new CoureurIns();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CoureurIns(FFRAG ffrag) {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIncriptionDeCoureur = new JLabel("Incription d'un coureur");
		lblIncriptionDeCoureur.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblIncriptionDeCoureur.setBounds(135, 25, 201, 38);
		contentPane.add(lblIncriptionDeCoureur);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNom.setBounds(53, 85, 51, 18);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPrenom.setBounds(53, 118, 70, 18);
		contentPane.add(lblPrenom);
		
		JLabel lblDatenassaince = new JLabel("DateNassaince :");
		lblDatenassaince.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblDatenassaince.setBounds(53, 156, 110, 18);
		contentPane.add(lblDatenassaince);
		
		JLabel lblNationalite = new JLabel("Nationalite :");
		lblNationalite.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNationalite.setBounds(53, 195, 110, 18);
		contentPane.add(lblNationalite);
		
		JLabel lblSanguin = new JLabel("Sanguin :");
		lblSanguin.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSanguin.setBounds(53, 234, 110, 18);
		contentPane.add(lblSanguin);
		
		txtNom = new JTextField();
		txtNom.setBounds(176, 81, 177, 24);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(176, 114, 177, 24);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtDateNe = new JTextField();
		txtDateNe.setText("yyyy-MM-dd");
		txtDateNe.setColumns(10);
		txtDateNe.setBounds(176, 152, 177, 24);
		contentPane.add(txtDateNe);
		
		txtNat = new JTextField();
		txtNat.setColumns(10);
		txtNat.setBounds(176, 191, 177, 24);
		contentPane.add(txtNat);
		
		txtSan = new JTextField();
		txtSan.setColumns(10);
		txtSan.setBounds(176, 230, 177, 24);
		contentPane.add(txtSan);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String date = txtDateNe.getText();
				String nat = txtNat.getText();
				String san = txtSan.getText();
				
				java.util.Date dateNe = null;
				try {
					dateNe = dateformat.parse(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
				
				Coureur coureur = new Coureur(nom,prenom,dateNe,nat,san);
				ffrag.getListCoureur().add(coureur);
				CSV.enregistreCoureur(ffrag, ffrag.getCsvPath());
				dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LogCoureur frame = new LogCoureur(ffrag);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

			}
		});
		btnSinscrire.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnSinscrire.setBounds(161, 280, 113, 27);
		contentPane.add(btnSinscrire);
	}

}
