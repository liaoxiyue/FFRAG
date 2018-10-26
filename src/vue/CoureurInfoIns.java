package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.Coureur;
import FFRAG.Edition;
import FFRAG.FFRAG;
import FFRAG.Rallye;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoureurInfoIns extends JFrame {

	private JPanel contentPane;
	private FFRAG ffrag;
	private Coureur coureur;
	private JTable table;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoureurInfoIns frame = new CoureurInfoIns();
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
	public CoureurInfoIns(FFRAG ffrag, Coureur coureur) {
		this.ffrag = ffrag;
		this.coureur = coureur;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHomeFor = new JLabel("Home for");
		lblHomeFor.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblHomeFor.setBounds(55, 40, 91, 30);
		contentPane.add(lblHomeFor);
		
		JLabel lblNomC = new JLabel(""+coureur.getNomCoureur()+" "+coureur.getPrenomCoureur());
		lblNomC.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblNomC.setBounds(144, 40, 297, 30);
		contentPane.add(lblNomC);
		
		JLabel lblInformationsParticipation = new JLabel("Informations participation:");
		lblInformationsParticipation.setFont(new Font("Calibri", Font.BOLD, 15));
		lblInformationsParticipation.setBounds(55, 133, 235, 18);
		contentPane.add(lblInformationsParticipation);
		
		JButton btnNewButton = new JButton("Inscrire un nouveau Rallye");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Inscription frame = new Inscription(ffrag, coureur);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNewButton.setBounds(53, 91, 201, 27);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		Object[][] infoPart = new Object[coureur.getListParticipation().size()+1][4];
		infoPart[0][0]="Rallye";infoPart[0][1]="NumEdition";infoPart[0][2]="NumInscription";infoPart[0][3]="V\u00E9hicule";
		for(int i =0; i<coureur.getListParticipation().size();i++) {
			for(Rallye r: ffrag.getListRallye()) {
				for(Edition e: r.getListeEdition()) {
					if(e.getListPart().contains(coureur.getListParticipation().get(i))) {
						infoPart[i+1][0]=r.getNomRallye();
						infoPart[i+1][1]=e.getNoEdition();
					}
				}
			}
			infoPart[i+1][2]=coureur.getListParticipation().get(i).getNoInscription();
			infoPart[i+1][3]=coureur.getListParticipation().get(i).getVehicule().getModele();
		}
		table.setModel(new DefaultTableModel(
			infoPart,
			new String[] {
				"Rallye", "NoEdition", "NoInscription", "V\u00E9hicule"
			}
		));
		table.setBounds(55, 164, 405, 170);
		contentPane.add(table);
	}
}
