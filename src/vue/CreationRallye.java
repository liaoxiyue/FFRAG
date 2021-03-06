package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.FFRAG;
import RunRallye.CSV;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class CreationRallye extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomRallye;
	private JTextField txtVille;
	private JTextField txtPays;
	private FFRAG ffrag;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public CreationRallye(FFRAG ffrag) {
		this.ffrag = ffrag;
		setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblVillePrincipale = new JLabel("Ville principale");
		lblVillePrincipale.setFont(new Font("Calibri", Font.BOLD, 15));
		lblVillePrincipale.setBounds(20, 147, 104, 30);
		contentPane.add(lblVillePrincipale);
		
		JLabel lblPaysPrincipale = new JLabel("Pays principale");
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
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ffrag.creationRallye(txtNomRallye.getText(), txtVille.getText(), txtPays.getText());
				System.out.println("Le rallye "+ffrag.getListRallye().get(ffrag.getListRallye().size()-1).getNomRallye()+" a bien ��t�� enregistr��");
				txtNomRallye.setText("");
				txtVille.setText("");
				txtPays.setText("");
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreationEdition frame = new CreationEdition(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				try {
					CSV.enregistreNouveauRallye(ffrag,ffrag.getCsvPath(), ffrag.getListRallye().get(ffrag.getListRallye().size()-1));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEnregistrer.setFont(new Font("Calibri", Font.BOLD, 15));
		btnEnregistrer.setForeground(Color.BLACK);
		btnEnregistrer.setBackground(Color.LIGHT_GRAY);
		btnEnregistrer.setBounds(154, 281, 109, 30);
		contentPane.add(btnEnregistrer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setForeground(Color.BLACK);
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 15));
		btnAnnuler.setBackground(Color.LIGHT_GRAY);
		btnAnnuler.setBounds(295, 281, 109, 30);
		contentPane.add(btnAnnuler);
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}



