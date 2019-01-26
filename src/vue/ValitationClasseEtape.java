package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ValitationClasseEtape extends JFrame {

	private JPanel contentPane;
	private FFRAG ffrag;
	private JTable table;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValitationClasseEtape frame = new ValitationClasseEtape();
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
	public ValitationClasseEtape(FFRAG ffrag) {
		this.ffrag=ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValidationClassementEtape = new JLabel("Validation classement ¨¦tape");
		lblValidationClassementEtape.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblValidationClassementEtape.setBounds(243, 23, 267, 39);
		contentPane.add(lblValidationClassementEtape);
		
		JComboBox cBoxRallye = new JComboBox();
		cBoxRallye.setBounds(143, 76, 154, 24);
		String[] listRallye = new String[ffrag.getListRallye().size()+1];
		listRallye[0]="---choix du Rallye---";
		for(int i = 1; i <= ffrag.getListRallye().size(); i++) {
			listRallye[i] = ffrag.getListRallye().get(i-1).getNomRallye();
		}
		cBoxRallye.setModel(new DefaultComboBoxModel(listRallye));
		cBoxRallye.setEditable(true);
		cBoxRallye.setToolTipText("");
		contentPane.add(cBoxRallye);
		
		JLabel label = new JLabel("Choix ¨¦dition");
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(311, 80, 101, 18);
		contentPane.add(label);
		
		JComboBox cBoxEdition = new JComboBox();
		cBoxEdition.setBounds(412, 76, 98, 24);
		contentPane.add(cBoxEdition);
		
		JLabel label_1 = new JLabel("Choix Rallye");
		label_1.setFont(new Font("Calibri", Font.BOLD, 15));
		label_1.setBounds(64, 80, 79, 18);
		contentPane.add(label_1);
		
		JComboBox cBoxEtape = new JComboBox();

		cBoxEtape.setBounds(607, 76, 98, 24);
		contentPane.add(cBoxEtape);
		
		JLabel lblChoixEtape = new JLabel("Choix ¨¦tape");
		lblChoixEtape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChoixEtape.setBounds(523, 80, 101, 18);
		contentPane.add(lblChoixEtape);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(53, 125, 215, 481);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setBounds(409, 125, 340, 481);
		contentPane.add(table_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Calibri", Font.BOLD, 15));
		btnValider.setBounds(282, 262, 113, 27);
		contentPane.add(btnValider);
		
		cBoxRallye.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Rallye choix = ffrag.getRallye(cBoxRallye.getSelectedItem().toString());
				String[] listEdition = new String[choix.getListeEdition().size()+1];
				listEdition[0] = "---Choix ¨¦dition---";
				for(int i = 1; i <= choix.getListeEdition().size(); i++) {
					listEdition[i] = ""+choix.getListeEdition().get(i-1).getNoEdition();
				}
				cBoxEdition.setModel(new DefaultComboBoxModel(listEdition));
				cBoxEdition.setEditable(true);
				cBoxEdition.setToolTipText("");
				
			}
		});
		cBoxEdition.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()){
					Edition choix = ffrag.getRallye(cBoxRallye.getSelectedItem().toString()).getEdition(Integer.valueOf(cBoxEdition.getSelectedItem().toString()));
					String[] listEtape = new String[choix.getListEtape().size()+1];
					listEtape[0] = "---Choix ¨¦tape---";
					for(int i = 1; i <= choix.getListEtape().size(); i++) {
						listEtape[i] = ""+choix.getListEtape().get(i-1).getCodeEtape();
					}
					cBoxEtape.setModel(new DefaultComboBoxModel(listEtape));
					cBoxEtape.setEditable(true);
					cBoxEtape.setToolTipText("");
					
				}

				}
				
			});
		
		cBoxEtape.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Etape etape = null;
				Edition edition = ffrag.getRallye(cBoxRallye.getSelectedItem().toString()).getEdition(Integer.valueOf(cBoxEdition.getSelectedItem().toString()));
				for(Etape et : edition.getListEtape()) {
					if(et.getCodeEtape() == (Integer.valueOf(cBoxEtape.getSelectedItem().toString()))){
						etape = et;
					}
				}
				
				HashMap<Participant, Integer> tabParticipants = etape.getTabParticipants();
				
				Object[][] classement = new Object[etape.getTabParticipants().size()+1][2];
				classement[0][0] = "Coureur";
				classement[0][1] = "Temps";

				int i = 0;
				for(Participant p : tabParticipants.keySet()) {
					classement[i+1][0] = "" + p.getCoureur().getPrenomCoureur() + " " + p.getCoureur().getNomCoureur();
					if(tabParticipants.get(p)==null) {
						classement[i+1][1] = tabParticipants.get(p);
					}else {
						Courir c = new Courir(0,0,0,0);
						c.setMilleSeconde(tabParticipants.get(p));
						classement[i+1][1] = c.getTemps();
					}
					i = i+1;
				}
				table.setModel(new DefaultTableModel(
						classement,
						new String[] {
								"Coureur", "Temps"
						}
				));
				contentPane.add(table);
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(155);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(145);
				
				table_1 = new JTable();
				table_1.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
					},
					new String[] {
						"New column", "New column", "New column"
					}
				));
				table_1.setBounds(409, 125, 340, 481);
				contentPane.add(table_1);
			}
		});
		
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Etape etape = null;
				Edition edition = ffrag.getRallye(cBoxRallye.getSelectedItem().toString()).getEdition(Integer.valueOf(cBoxEdition.getSelectedItem().toString()));
				for(Etape et : edition.getListEtape()) {
					if(et.getCodeEtape() == (Integer.valueOf(cBoxEtape.getSelectedItem().toString()))){
						etape = et;
					}
				}

				for(Participant p : edition.getListPart()){
					etape.validerClassement(p);
				}
				etape.calculerClassement();
				
				ArrayList<HashMap.Entry<Participant, Integer>> classementEtape = etape.getClassementEtape();
				
				Object[][] classement = new Object[etape.getClassementEtape().size()+1][3];
				classement[0][0] = "Position";
				classement[0][1] = "Coureur";
				classement[0][2] = "Temps";
				
				for(int i=0;i<classementEtape.size();i++) {
					classement[i+1][0] = i+1;					
					classement[i+1][1] = "" + classementEtape.get(i).getKey().getCoureur().getPrenomCoureur() + " " + classementEtape.get(i).getKey().getCoureur().getNomCoureur();
					Courir t = new Courir(0,0,0,0);
					t.setMilleSeconde(classementEtape.get(i).getValue());
					classement[i+1][2] = t.getTemps();
				}
				table_1.setModel(new DefaultTableModel(
						classement,
						new String[] {
								"Position", "Coureur", "Temps"
						}
				));
				contentPane.add(table_1);
				table_1.getColumnModel().getColumn(0).setResizable(false);
				table_1.getColumnModel().getColumn(0).setPreferredWidth(75);
				table_1.getColumnModel().getColumn(1).setResizable(false);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(145);
			}
			
		});
	}
}
