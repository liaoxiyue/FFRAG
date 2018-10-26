package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import FFRAG.Coureur;
import FFRAG.Edition;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;
import FFRAG.Vehicule;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private FFRAG ffrag;
	private Coureur coureur;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
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
	public Inscription(FFRAG ffrag, Coureur coureur) {
		this.ffrag = ffrag;
		this.coureur = coureur;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInscriptionEdition = new JLabel("Inscription Edition");
		lblInscriptionEdition.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblInscriptionEdition.setBounds(126, 13, 198, 40);
		contentPane.add(lblInscriptionEdition);
		
		JComboBox cBoxRallye = new JComboBox();
		cBoxRallye.setBounds(204, 66, 120, 24);String[] listRallye = new String[ffrag.getListRallye().size()+1];
		listRallye[0]="---choix du Rallye---";
		for(int i = 1; i <= ffrag.getListRallye().size(); i++) {
			listRallye[i] = ffrag.getListRallye().get(i-1).getNomRallye();
		}
		cBoxRallye.setModel(new DefaultComboBoxModel(listRallye));
		cBoxRallye.setEditable(true);
		cBoxRallye.setToolTipText("");
		contentPane.add(cBoxRallye);
		
		JLabel lblRallye = new JLabel("Rallye:");
		lblRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRallye.setBounds(92, 69, 72, 18);
		contentPane.add(lblRallye);
		
		JLabel lblEdition = new JLabel("Edition:");
		lblEdition.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEdition.setBounds(92, 100, 72, 18);
		contentPane.add(lblEdition);
		
		JComboBox cBoxEdition = new JComboBox();
		cBoxEdition.setBounds(204, 96, 120, 24);
		contentPane.add(cBoxEdition);
		
		cBoxRallye.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Rallye choix = ffrag.getRallye(cBoxRallye.getSelectedItem().toString());
				String[] listEdition = new String[choix.getListeEdition().size()+1];
				listEdition[0] = "---Choix Edition---";
				for(int i = 1; i <= choix.getListeEdition().size(); i++) {
					listEdition[i] = ""+choix.getListeEdition().get(i-1).getNoEdition();
				}
				cBoxEdition.setModel(new DefaultComboBoxModel(listEdition));
				cBoxEdition.setEditable(true);
				cBoxEdition.setToolTipText("");
								
			}
		});
		
		JLabel lblVhicule = new JLabel("V\u00E9hicule:");
		lblVhicule.setFont(new Font("Calibri", Font.BOLD, 15));
		lblVhicule.setBounds(92, 157, 72, 18);
		contentPane.add(lblVhicule);
		
		JComboBox cBoxVehicule = new JComboBox();
		cBoxVehicule.setBounds(204, 153, 120, 24);
		contentPane.add(cBoxVehicule);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rallye rallye = ffrag.getRallye(cBoxRallye.getSelectedItem().toString());
				Edition edition = rallye.getEdition(Integer.valueOf(cBoxEdition.getSelectedItem().toString()));
				//Vehicule vehicule = ffrag.getVehicule(cBoxVehicule.getSelectedItem().toString());
				//Participant part = new Participant(coureur, vehicule);
				//edition.organiserPart(part);
			}
		});
		btnEnregistrer.setFont(new Font("Calibri", Font.BOLD, 15));
		btnEnregistrer.setBounds(158, 202, 113, 27);
		contentPane.add(btnEnregistrer);
	}
}
