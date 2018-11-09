package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import FFRAG.Coureur;
import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;

import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Parier extends JFrame {

	private JPanel contentPane;
	private JTable tableProfil;
	private JTable tableParticipants;
	private JTable tableCoureur;
	private FFRAG ffrag;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
=======
	public static void main(String[] args) {
>>>>>>> b742ef2b4250920bcd46755ec841d4cbf0643d16
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parier frame = new Parier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
<<<<<<< HEAD
	*/

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Parier(FFRAG ffrag) throws ParseException {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1229, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRallye = new JLabel("Rallye");
		lblRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRallye.setBounds(26, 57, 48, 15);
		contentPane.add(lblRallye);
		
		JComboBox comboBoxRallye = new JComboBox();
		ArrayList<Edition> editionAPari = ffrag.editionAPari();
		String[] listEdition = new String[editionAPari.size()+1];
		listEdition[0] = "---Choix de Cours---";
		for(int i = 0; i < editionAPari.size(); i++) {
			listEdition[i+1] = editionAPari.get(i).getRallye().getNomRallye() + "-" + editionAPari.get(i).getSaison();
		}
		comboBoxRallye.setModel(new DefaultComboBoxModel(listEdition));
		comboBoxRallye.setBounds(69, 47, 184, 32);
		contentPane.add(comboBoxRallye);
		
		JLabel lblFaireUnPari = new JLabel("Faire un pari maintenant !");
		lblFaireUnPari.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblFaireUnPari.setBounds(328, 10, 236, 32);
		contentPane.add(lblFaireUnPari);
		
		JScrollPane scrollPane_Coureur = new JScrollPane();
		scrollPane_Coureur.setBounds(35, 94, 406, 336);
		contentPane.add(scrollPane_Coureur);
		
		tableParticipants = new JTable();
		tableParticipants.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Coureur", "Vehicule", "Cote"
			}
		));
		tableParticipants.getColumnModel().getColumn(0).setResizable(false);
		tableParticipants.getColumnModel().getColumn(0).setPreferredWidth(153);
		tableParticipants.getColumnModel().getColumn(1).setResizable(false);
		tableParticipants.getColumnModel().getColumn(1).setPreferredWidth(146);
		scrollPane_Coureur.setViewportView(tableParticipants);
		
		tableProfil = new JTable();
		tableProfil.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom", "Pr\u00E9nom", "Date de naissance", "Titres remport\u00E9s"
			}
		));
		tableProfil.setBounds(462, 94, 357, 69);
		contentPane.add(tableProfil);
		
		JScrollPane scrollPane_Detail = new JScrollPane();
		scrollPane_Detail.setBounds(462, 180, 720, 250);
		contentPane.add(scrollPane_Detail);
		
		tableCoureur = new JTable();
		tableCoureur.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, "", ""},
			},
			new String[] {
				"Rallye", "Edition", "Saison", "V\u00E9hicule", "Position", "Temps"
			}
		));
		scrollPane_Detail.setColumnHeaderView(tableCoureur);
		
		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setFont(new Font("Calibri", Font.BOLD, 15));
		lblMontant.setBounds(35, 457, 69, 15);
		contentPane.add(lblMontant);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBounds(111, 453, 90, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Calibri", Font.PLAIN, 15));
		label.setBounds(203, 457, 22, 15);
		contentPane.add(label);
		
		JButton btnPlacezUnPari = new JButton("Placez un pari");
		btnPlacezUnPari.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnPlacezUnPari.setBounds(268, 452, 160, 23);
		contentPane.add(btnPlacezUnPari);
		
		comboBoxRallye.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()) {
					String choix = comboBoxRallye.getSelectedItem().toString();
					String[] split = choix.split("-");
					String nomRallye = split[0];
					String saison = split[1];
					Rallye rallye = ffrag.getRallye(nomRallye);
					Edition edition = null;
					for(int i = 0; i < rallye.getListeEdition().size(); i++) {
						if (rallye.getListeEdition().get(i).getSaison().equals(saison)) {
							edition = rallye.getListeEdition().get(i);
						}
					}
					
					Object[][] participants = new Object[edition.getListPart().size()][3];
					for(int i=0;i<edition.getListPart().size();i++) {
						participants[i][0] = edition.getListPart().get(i).getCoureur().getPrenomCoureur() + " " + edition.getListPart().get(i).getCoureur().getNomCoureur();
						participants[i][1] = edition.getListPart().get(i).getVoiture().getModele();
						participants[i][2] = 1; // il faut une methode pour calculer la cote d'un participant dans classe Participant
					}
					tableParticipants.setModel(new DefaultTableModel(
							participants,
							new String[] {
									"Coureur", "Vehicule", "Cote"
							}
					));
					contentPane.add(tableParticipants);
					tableParticipants.getColumnModel().getColumn(0).setResizable(false);
					tableParticipants.getColumnModel().getColumn(0).setPreferredWidth(153);
					tableParticipants.getColumnModel().getColumn(1).setResizable(false);
					tableParticipants.getColumnModel().getColumn(1).setPreferredWidth(146);
					scrollPane_Coureur.setViewportView(tableParticipants);
				}
			}
		});
		
		
		tableParticipants.addMouseListener((new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = tableParticipants.getSelectedColumn();
				int row = tableParticipants.getSelectedRow();
				String nomCoureur = tableParticipants.getValueAt(row, col).toString();
				String nom = "";
				String prenom = "";
				nom = nomCoureur.substring(nomCoureur.lastIndexOf(" ")+1);
				prenom = nomCoureur.substring(0, nomCoureur.lastIndexOf(" "));
				Coureur coureur = ffrag.confirmeCoureur(nom, prenom);
				
				Object[][] profil = new Object[1][4];
				profil[0][0] = coureur.getNomCoureur();
				profil[0][1] = coureur.getPrenomCoureur();
				profil[0][2] = dateformat.format(coureur.getDateNaissanceC());
				profil[0][3] = coureur.titreRemporte();
				tableProfil.setModel(new DefaultTableModel(
						profil,
						new String[] {
							"Nom", "Pr\u00E9nom", "Date de naissance", "Titres remport\u00E9s"
						}
					));
				

				Object[][] listDetail = new Object[coureur.getListParticipation().size()][6]; 
				
				for(int i = 0; i < coureur.getListParticipation().size(); i++) {
					listDetail[i][0] = coureur.getListParticipation().get(i).getEdition().getRallye().getNomRallye();
					listDetail[i][1] = coureur.getListParticipation().get(i).getEdition().getNoEdition();
					listDetail[i][2] = coureur.getListParticipation().get(i).getEdition().getSaison();
					listDetail[i][3] = coureur.getListParticipation().get(i).getVoiture().getModele();
					listDetail[i][4] = coureur.getListParticipation().get(i).getPosition();
					Courir courir = new Courir(0,0,0,0);
					courir.setMilleSeconde(coureur.getListParticipation().get(i).getTempsFinal());
					listDetail[i][5] = courir.getTemps();
					
				}
				
				tableCoureur.setModel(new DefaultTableModel(
						listDetail,
						new String[] {
							"Rallye", "Edition", "Saison", "V\u00E9hicule", "Position", "Temps"
						}
					));
					scrollPane_Detail.setColumnHeaderView(tableCoureur);
			}
		}));
		
		
		btnPlacezUnPari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez entrer le montant", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				}
			}
		});
	}
}
