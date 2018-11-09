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
	private JTable tableEtape;
	private JTable tableGeneral;

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
		setBounds(100, 100, 1357, 552);
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
		comboBoxRallye.setBounds(57, 55, 155, 30);
		contentPane.add(comboBoxRallye);
		
		JLabel lblConsultationClassement = new JLabel("Consultation Classement");
		lblConsultationClassement.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblConsultationClassement.setBounds(559, 20, 225, 30);
		contentPane.add(lblConsultationClassement);
		
		JLabel lblRallye = new JLabel("Rallye");
		lblRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRallye.setBounds(14, 63, 45, 15);
		contentPane.add(lblRallye);
		
		JComboBox comboBoxEdition = new JComboBox();
		comboBoxEdition.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBoxEdition.setBounds(293, 55, 146, 30);
		contentPane.add(comboBoxEdition);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEdition.setBounds(238, 63, 45, 15);
		contentPane.add(lblEdition);
		
		JLabel lblEtape = new JLabel("Etape");
		lblEtape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEtape.setBounds(778, 64, 45, 15);
		contentPane.add(lblEtape);
		
		JComboBox comboBoxEtape = new JComboBox();
		comboBoxEtape.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBoxEtape.setBounds(833, 55, 139, 30);
		contentPane.add(comboBoxEtape);
		
		JLabel lblClassementDfinitif = new JLabel("Classement D\u00E9finitif");
		lblClassementDfinitif.setFont(new Font("Calibri", Font.BOLD, 15));
		lblClassementDfinitif.setBounds(67, 97, 334, 18);
		contentPane.add(lblClassementDfinitif);
		
		JLabel lblClassementPattape = new JLabel("Classement pat \u00E9tape");
		lblClassementPattape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblClassementPattape.setBounds(494, 97, 334, 18);
		contentPane.add(lblClassementPattape);
		
		JLabel lblClassementGnral = new JLabel("Classement g\u00E9n\u00E9ral");
		lblClassementGnral.setFont(new Font("Calibri", Font.BOLD, 15));
		lblClassementGnral.setBounds(898, 96, 334, 18);
		contentPane.add(lblClassementGnral);
		
		JScrollPane scrollPane_Definitif = new JScrollPane();
		scrollPane_Definitif.setBounds(57, 116, 351, 364);
		contentPane.add(scrollPane_Definitif);
		
		tableFinal = new JTable();
		tableFinal.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Position", "Coureur", "Temps"
			}
		));
		tableFinal.getColumnModel().getColumn(0).setResizable(false);
		tableFinal.getColumnModel().getColumn(1).setResizable(false);
		tableFinal.getColumnModel().getColumn(1).setPreferredWidth(145);
		scrollPane_Definitif.setViewportView(tableFinal);
		
		JScrollPane scrollPane_Etape = new JScrollPane();
		scrollPane_Etape.setBounds(482, 113, 397, 367);
		contentPane.add(scrollPane_Etape);
		
		tableEtape = new JTable();
		scrollPane_Etape.setViewportView(tableEtape);
		
		JScrollPane scrollPane_General = new JScrollPane();
		scrollPane_General.setBounds(898, 116, 385, 364);
		contentPane.add(scrollPane_General);
		
		tableGeneral = new JTable();
		scrollPane_General.setViewportView(tableGeneral);
		
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
				if(ItemEvent.SELECTED == e.getStateChange()) {
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
					
					Object[][] classement = new Object[choix.getClassementGeneral().size()][3];
					
					for(int i=0;i<choix.getClassementGeneral().size();i++) {
						classement[i][0] = classementDefinitif.get(i).getKey().getPosition();					
						classement[i][1] = "" + classementDefinitif.get(i).getKey().getCoureur().getPrenomCoureur() + " " + classementDefinitif.get(i).getKey().getCoureur().getNomCoureur();
						Courir t = new Courir(0,0,0,0);
						t.setMilleSeconde(classementDefinitif.get(i).getKey().getTempsFinal());
						classement[i][2] = t.getTemps();
					}
					tableFinal.setModel(new DefaultTableModel(
							classement,
							new String[] {
									"Position", "Coureur", "Temps"
							}
					));
					contentPane.add(tableFinal);
					tableFinal.getColumnModel().getColumn(0).setResizable(false);
					tableFinal.getColumnModel().getColumn(0).setPreferredWidth(75);
					tableFinal.getColumnModel().getColumn(1).setResizable(false);
					tableFinal.getColumnModel().getColumn(1).setPreferredWidth(145);
					scrollPane_Definitif.setViewportView(tableFinal);
		
				}
			}
		});
		
		comboBoxEtape.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()) {
					Etape etape = null;
					Edition edition = ffrag.getRallye(comboBoxRallye.getSelectedItem().toString()).getEdition(Integer.valueOf(comboBoxEdition.getSelectedItem().toString()));
					for(Etape et : edition.getListEtape()) {
						if(et.getCodeEtape() == (Integer.valueOf(comboBoxEtape.getSelectedItem().toString()))){
							etape = et;
						}
					}
					
					ArrayList<HashMap.Entry<Participant, Integer>> classementEtape = etape.getClassementEtape();
					
					Object[][] classement = new Object[etape.getClassementEtape().size()][3];
					
					for(int i=0;i<classementEtape.size();i++) {
						classement[i][0] = i+1;					
						classement[i][1] = "" + classementEtape.get(i).getKey().getCoureur().getPrenomCoureur() + " " + classementEtape.get(i).getKey().getCoureur().getNomCoureur();
						Courir t = new Courir(0,0,0,0);
						t.setMilleSeconde(classementEtape.get(i).getValue());
						classement[i][2] = t.getTemps();
					}
					tableEtape.setModel(new DefaultTableModel(
							classement,
							new String[] {
									"Position", "Coureur", "Temps"
							}
					));
					contentPane.add(tableEtape);
					tableEtape.getColumnModel().getColumn(0).setResizable(false);
					tableEtape.getColumnModel().getColumn(0).setPreferredWidth(75);
					tableEtape.getColumnModel().getColumn(1).setResizable(false);
					tableEtape.getColumnModel().getColumn(1).setPreferredWidth(145);
					
					
					edition.calculerClassement(etape.getCodeEtape());
					ArrayList<HashMap.Entry<Participant, Integer>> classementGeneral = edition.getClassementGeneral();
					
					Object[][] classementG = new Object[edition.getClassementGeneral().size()][3];
					
					for(int i = 0; i < edition.getClassementGeneral().size();i++) {
						classementG[i][0] = i+1;					
						classementG[i][1] = "" + classementGeneral.get(i).getKey().getCoureur().getPrenomCoureur() + " " + classementGeneral.get(i).getKey().getCoureur().getNomCoureur();
						Courir t = new Courir(0,0,0,0);
						t.setMilleSeconde(classementGeneral.get(i).getValue());
						classementG[i][2] = t.getTemps();
					}
					tableGeneral.setModel(new DefaultTableModel(
							classementG,
							new String[] {
									"Position", "Coureur", "Temps"
							}
					));
					contentPane.add(tableGeneral);
					tableGeneral.getColumnModel().getColumn(0).setResizable(false);
					tableGeneral.getColumnModel().getColumn(0).setPreferredWidth(75);
					tableGeneral.getColumnModel().getColumn(1).setResizable(false);
					tableGeneral.getColumnModel().getColumn(1).setPreferredWidth(145);
					scrollPane_General.setViewportView(tableGeneral);
					scrollPane_Etape.setViewportView(tableEtape);
					
				}
			}
		});
	}
}
