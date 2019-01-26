package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import FFRAG.Coureur;
import FFRAG.Courir;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;

import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class ClassementSaison extends JFrame {

	private JPanel contentPane;
	private JTable tableSaison;
	private FFRAG ffrag;
	private JTable tableDetail;
	String saison;

	/**
	 * Launch the application.
	 
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
	}*/

	/**
	 * Create the frame.
	 */
	public ClassementSaison(FFRAG ffrag) {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 933, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassementSaison = new JLabel("Classement saison");
		lblClassementSaison.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblClassementSaison.setBounds(373, 23, 170, 36);
		contentPane.add(lblClassementSaison);
		
		JLabel lblRallye = new JLabel("Saison :");
		lblRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRallye.setBounds(61, 75, 72, 18);
		contentPane.add(lblRallye);
		
		JComboBox cBoxSaison = new JComboBox();
		cBoxSaison.setModel(new DefaultComboBoxModel(new String[] {"2015 / 2016", "2016 / 2017", "2017 / 2018", "2018 / 2019"}));
		cBoxSaison.setBounds(147, 72, 103, 24);
		contentPane.add(cBoxSaison);
		
		JScrollPane scrollPane_Saison = new JScrollPane();
		scrollPane_Saison.setBounds(28, 103, 408, 402);
		contentPane.add(scrollPane_Saison);
		
		tableSaison = new JTable();
		tableSaison.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Coureur", "NbPart", "MeilleurP"
			}
		));
		tableSaison.getColumnModel().getColumn(0).setPreferredWidth(160);
		tableSaison.getColumnModel().getColumn(1).setResizable(false);
		tableSaison.getColumnModel().getColumn(1).setPreferredWidth(147);
		tableSaison.getColumnModel().getColumn(2).setPreferredWidth(114);
		scrollPane_Saison.setViewportView(tableSaison);
		
		JScrollPane scrollPane_Detail = new JScrollPane();
		scrollPane_Detail.setBounds(484, 103, 399, 402);
		contentPane.add(scrollPane_Detail);
		
		tableDetail = new JTable();
		
		tableDetail.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rallye", "Position", "Temps"
			}
		));
		tableDetail.getColumnModel().getColumn(0).setResizable(false);
		tableDetail.getColumnModel().getColumn(0).setPreferredWidth(140);
		tableDetail.getColumnModel().getColumn(2).setResizable(false);
		scrollPane_Detail.setViewportView(tableDetail);
		
		tableSaison.addMouseListener((new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = tableSaison.getSelectedColumn();
				int row = tableSaison.getSelectedRow();
				String nomCoureur = tableSaison.getValueAt(row, col).toString();
				String nom = "";
				String prenom = "";
				nom = nomCoureur.substring(nomCoureur.lastIndexOf(" ")+1);
				prenom = nomCoureur.substring(0, nomCoureur.lastIndexOf(" "));
				Coureur coureur = ffrag.confirmeCoureur(nom, prenom);
				HashMap<Rallye, Participant> detail = ffrag.getDetailSaison(coureur, saison);
				int ligne = detail.size();
				Object[][] listDetail = new Object[ligne][3]; 
				
				int index = 0;
				for(Rallye r : detail.keySet()) {
					listDetail[index][0] = r.getNomRallye();
					listDetail[index][1] = detail.get(r).getPosition();
					Courir c = new Courir(0,0,0,0);
					c.setMilleSeconde(detail.get(r).getTempsFinal());
					listDetail[index][2] = c.getTemps();
					index ++;
											
				}
				
				tableDetail.setModel(new DefaultTableModel(
						listDetail,
						new String[] {
								"Rallye", "Position", "Temps"
						}
						));
				tableDetail.getColumnModel().getColumn(0).setResizable(false);
				tableDetail.getColumnModel().getColumn(0).setPreferredWidth(140);
				tableDetail.getColumnModel().getColumn(2).setResizable(false);
				contentPane.add(tableDetail);
				scrollPane_Detail.setViewportView(tableDetail);

			}
		}));
		
		cBoxSaison.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()) {
					saison = cBoxSaison.getSelectedItem().toString();
					int nbLigne = 0;
					for(Coureur coureur : ffrag.getListCoureur()) {
						if(ffrag.getNbPartSaison(coureur, saison) != 0) {
							nbLigne ++;
						}
					}
					Object[][] list = new Object[nbLigne][3];

					int index = 0;
					for(int i = 0; i < nbLigne; i++) {
						for(int j = index; j < ffrag.getListCoureur().size(); j++) {
							Coureur coureur = ffrag.getListCoureur().get(j);
							int nbPart = ffrag.getNbPartSaison(coureur, saison);
							if(nbPart != 0 ) {
								index = j + 1;
								list[i][0] = coureur.getPrenomCoureur() +" "+ coureur.getNomCoureur();
								list[i][1] = nbPart;
								list[i][2] = ffrag.getMeilleurSaison(coureur, saison);
								break;
							}
						}
					}
					tableSaison.setModel(new DefaultTableModel(
							list,
							new String[] {
									"Coureur", "Nombre de participations", "Meilleure position"
							}
							));
					tableSaison.getColumnModel().getColumn(0).setPreferredWidth(160);
					tableSaison.getColumnModel().getColumn(1).setResizable(false);
					tableSaison.getColumnModel().getColumn(1).setPreferredWidth(147);
					tableSaison.getColumnModel().getColumn(2).setPreferredWidth(114);
					contentPane.add(tableSaison);
					scrollPane_Saison.setViewportView(tableSaison);
				}
			}
		});
	}
}


