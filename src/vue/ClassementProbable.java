package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;

public class ClassementProbable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private FFRAG ffrag;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassementProbable frame = new ClassementProbable(ffrag);
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
	 * @throws ParseException 
	 */
	public ClassementProbable(FFRAG ffrag) throws ParseException {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultationclassementprobale = new JLabel("Consultation classement probable");
		lblConsultationclassementprobale.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblConsultationclassementprobale.setBounds(60, 13, 317, 41);
		contentPane.add(lblConsultationclassementprobale);
		
		JLabel lblRallye = new JLabel("Rallye :");
		lblRallye.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblRallye.setBounds(60, 66, 72, 18);
		contentPane.add(lblRallye);
		
		JComboBox comboBoxRallye = new JComboBox();
		ArrayList<Edition> editionAPari = ffrag.editionAPari();
		String[] listEdition = new String[editionAPari.size()+1];
		listEdition[0] = "---Choix de l'¨¦dition---";
		for(int i = 0; i < editionAPari.size(); i++) {
			listEdition[i+1] = editionAPari.get(i).getRallye().getNomRallye() + "-" + editionAPari.get(i).getSaison();
		}
		comboBoxRallye.setModel(new DefaultComboBoxModel(listEdition));
		comboBoxRallye.setBounds(138, 58, 184, 32);
		contentPane.add(comboBoxRallye);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 103, 404, 234);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Position", "Coureur", "Temps Prevu"
			}
		));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(153);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(153);
		scrollPane.setColumnHeaderView(table);
		
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
					
					ArrayList<HashMap.Entry<Participant, Integer>> classementProbable = edition.classementProbable(60);
					Object[][] participants = new Object[classementProbable.size()][3];
					for(int i=0;i<classementProbable.size();i++) {
						participants[i][0] = i+1;
						participants[i][1] = classementProbable.get(i).getKey().getCoureur().getPrenomCoureur()+" "+classementProbable.get(i).getKey().getCoureur().getNomCoureur();
						Courir t = new Courir(0,0,0,0);
						t.setMilleSeconde(classementProbable.get(i).getValue());
						participants[i][2] = t.getTemps();
					}
					table.setModel(new DefaultTableModel(
							participants,
							new String[] {
									"Position", "Coureur", "Temps Prevu"
							}
					));
					contentPane.add(table);
					table.getColumnModel().getColumn(1).setResizable(false);
					table.getColumnModel().getColumn(1).setPreferredWidth(153);
					table.getColumnModel().getColumn(2).setResizable(false);
					table.getColumnModel().getColumn(2).setPreferredWidth(153);
					scrollPane.setViewportView(table);
					
				}
			}
		});

	}
}
