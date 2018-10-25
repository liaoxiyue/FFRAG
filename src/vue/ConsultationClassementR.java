package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;

import javax.swing.DefaultComboBoxModel;

public class ConsultationClassementR extends JFrame {

	private JPanel contentPane;
	private JTable tableFinal;
	private FFRAG ffrag;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultationClassementR frame = new ConsultationClassementR();
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
	public ConsultationClassementR(FFRAG ffrag) {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 977, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxRallye = new JComboBox();
		String[] listRallye = new String[ffrag.getListRallye().size()+1];
		listRallye[0] = "---Choix de Rallye---";
		for(int i = 0; i < ffrag.getListRallye().size(); i++) {
			listRallye[i+1] = ffrag.getListRallye().get(i).getNomRallye();
		}
		comboBoxRallye.setModel(new DefaultComboBoxModel(listRallye));
		comboBoxRallye.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBoxRallye.setBounds(65, 60, 101, 30);
		contentPane.add(comboBoxRallye);
		
		JLabel lblConsultationClassement = new JLabel("Consultation Classement");
		lblConsultationClassement.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblConsultationClassement.setBounds(114, 21, 225, 30);
		contentPane.add(lblConsultationClassement);
		
		JLabel lblRallye = new JLabel("Rallye");
		lblRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRallye.setBounds(10, 69, 45, 15);
		contentPane.add(lblRallye);
		
		JComboBox comboBoxEdition = new JComboBox();
		comboBoxEdition.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBoxEdition.setBounds(326, 60, 101, 30);
		contentPane.add(comboBoxEdition);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEdition.setBounds(271, 68, 45, 15);
		contentPane.add(lblEdition);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 116, 373, 266);
		contentPane.add(scrollPane);
		
		tableFinal = new JTable();
		tableFinal.setModel(new DefaultTableModel(
			new Object[][] {
				{"Position", "Coureur", "Temps"},
			},
			new String[] {
				"Position", "Coureur", "Temps"
			}
		));
		scrollPane.setColumnHeaderView(tableFinal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(547, 116, 373, 266);
		contentPane.add(scrollPane_1);
		
		JLabel lblEtape = new JLabel("Etape");
		lblEtape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEtape.setBounds(547, 69, 45, 15);
		contentPane.add(lblEtape);
		
		JComboBox comboBoxEtape = new JComboBox();
		comboBoxEtape.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBoxEtape.setBounds(602, 60, 101, 30);
		contentPane.add(comboBoxEtape);
		
		comboBoxRallye.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Rallye choix = ffrag.getRallye(comboBoxRallye.getSelectedItem().toString());		
				String[] listEdition = new String[choix.getListeEdition().size()+1];
				listEdition[0] = "---Choix Edition---";
				for(int i = 1; i <= choix.getListeEdition().size(); i++) {
					listEdition[i] = ""+choix.getListeEdition().get(i-1).getNoEdition();
				}
				comboBoxEdition.setModel(new DefaultComboBoxModel(listEdition));				
			}
		});
		comboBoxEdition.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Edition choix = ffrag.getRallye(comboBoxRallye.getSelectedItem().toString()).getEdition(Integer.valueOf(comboBoxEdition.getSelectedItem().toString()));
				String[] listEtape = new String[choix.getListEtape().size()+1];
				listEtape[0] = "---Choix Etape---";
				for(int i = 1; i <= choix.getListEtape().size(); i++) {
					listEtape[i] = "" + choix.getListEtape().get(i-1).getCodeEtape();
				}
				comboBoxEtape.setModel(new DefaultComboBoxModel(listEtape));
				int finalEtape = choix.getListEtape().size();
				choix.calculerClassement(finalEtape);
				ArrayList<HashMap.Entry<Participant, Integer>> classementDefinitif = choix.getClassementGeneral();
				
				Object[][] classement = new Object[choix.getClassementGeneral().size()+1][3];
				for(int i=0;i<choix.getListEtape().size();i++) {
					classement[i+1][0] = classementDefinitif.get(i).getKey().getPosition();					
					classement[i+1][1] = "" + classementDefinitif.get(i).getKey().getCoureur().getPrenomCoureur() + classementDefinitif.get(i).getKey().getCoureur().getNomCoureur();
					Courir t = new Courir(0,0,0,0);
					t.setMilleSeconde(classementDefinitif.get(i).getKey().getTempsFinal());
					classement[i+1][2] = t.getTemps();
				}
				tableFinal.setModel(new DefaultTableModel(classement,
						new String[] {
								"Etape", "Distance"
				}));
				tableFinal.setBounds(27, 242, 338, 64);
				contentPane.add(scrollPane);
				scrollPane.add(tableFinal);
			}
		});
	}
}
