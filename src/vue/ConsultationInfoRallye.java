package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import FFRAG.Edition;
import FFRAG.FFRAG;
import FFRAG.Rallye;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class ConsultationInfoRallye extends JFrame {

	private JPanel contentPane;
	private JTable tabInfoRallye;
	private JTable tabInfoEtape;
	private FFRAG ffrag;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultationInfoRallye frame = new ConsultationInfoRallye();
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
	public ConsultationInfoRallye(FFRAG ffrag) {
		this.ffrag = ffrag;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultationInformationsRallye = new JLabel("Consultation Informations Rallye");
		lblConsultationInformationsRallye.setBounds(27, 13, 307, 38);
		lblConsultationInformationsRallye.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		contentPane.add(lblConsultationInformationsRallye);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(27, 113, 79, 18);
		lblVille.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(lblVille);
		
		JComboBox cBoxRallye = new JComboBox();
		cBoxRallye.setBounds(106, 60, 154, 24);
		String[] listRallye = new String[ffrag.getListRallye().size()+1];
		listRallye[0]="---choix du Rallye---";
		for(int i = 1; i <= ffrag.getListRallye().size(); i++) {
			listRallye[i] = ffrag.getListRallye().get(i-1).getNomRallye();
		}
		cBoxRallye.setModel(new DefaultComboBoxModel(listRallye));
		cBoxRallye.setEditable(true);
		cBoxRallye.setToolTipText("");
		contentPane.add(cBoxRallye);
		
		JLabel lblChoixEdition = new JLabel("Choix Edition");
		lblChoixEdition.setBounds(274, 64, 101, 18);
		lblChoixEdition.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(lblChoixEdition);
		
		JComboBox cBoxEdition = new JComboBox();
		cBoxEdition.setBounds(375, 60, 98, 24);
		contentPane.add(cBoxEdition);
		
		tabInfoRallye = new JTable();
		tabInfoRallye.setBounds(27, 145, 571, 84);
		tabInfoRallye.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rallye", "Edition", "Date D\u00E9but", "Date Fin"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Rallye", "Edition", "Date D\u00E9but", "Date Fin"
			}
		));
		tabInfoRallye.getColumnModel().getColumn(0).setPreferredWidth(150);
		tabInfoRallye.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabInfoRallye.getColumnModel().getColumn(2).setPreferredWidth(150);
		tabInfoRallye.getColumnModel().getColumn(3).setPreferredWidth(150);
		contentPane.add(tabInfoRallye);
		
		tabInfoEtape = new JTable();
		tabInfoEtape.setBounds(27, 242, 333, 470);
		tabInfoEtape.setModel(new DefaultTableModel(
			new Object[][] {
				{"Etape", "Distance"},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Etape", "Distance"
			}
		));
		contentPane.add(tabInfoEtape);
		
		JLabel label = new JLabel("Choix Rallye");
		label.setBounds(27, 64, 79, 18);
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(label);
		
		JLabel lblPays = new JLabel("Pays :");
		lblPays.setBounds(181, 113, 79, 18);
		lblPays.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(lblPays);
		
		JLabel ville = new JLabel("");
		ville.setBounds(88, 113, 79, 18);
		ville.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(ville);
		
		JLabel pays = new JLabel("");
		pays.setBounds(229, 113, 79, 18);
		pays.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(pays);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(229, 94, 79, 18);
		label_1.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(label_1);
		
		JLabel lblChampionPlusJeune = new JLabel("Champion Plus Jeune :");
		lblChampionPlusJeune.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChampionPlusJeune.setBounds(333, 113, 160, 18);
		contentPane.add(lblChampionPlusJeune);
		
		JLabel jeune = new JLabel("");
		jeune.setFont(new Font("Calibri", Font.BOLD, 15));
		jeune.setBounds(487, 113, 129, 18);
		contentPane.add(jeune);
					
		cBoxRallye.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Rallye choix = ffrag.getRallye(cBoxRallye.getSelectedItem().toString());
				ville.setText(choix.getVille());
				pays.setText(choix.getPays());
				jeune.setText(choix.getChampionPlusJeune().getPrenomCoureur()+" "+choix.getChampionPlusJeune().getNomCoureur());
				if(!(choix.getChampionPlusJeune()==null)) {
					jeune.setText(choix.getChampionPlusJeune().getNomCoureur()+" "+choix.getChampionPlusJeune().getPrenomCoureur());
				}
				String[] listEdition = new String[choix.getListeEdition().size()+1];
				listEdition[0] = "---Choix Edition---";
				for(int i = 1; i <= choix.getListeEdition().size(); i++) {
					listEdition[i] = ""+choix.getListeEdition().get(i-1).getNoEdition();
				}
				cBoxEdition.setModel(new DefaultComboBoxModel(listEdition));
				cBoxEdition.setEditable(true);
				cBoxEdition.setToolTipText("");
				
				Object[][] info = new Object[choix.getListeEdition().size()+1][4];
				info[0][0]="Rallye";info[0][1]="Edition";info[0][2]="Date D\u00E9but";info[0][3]="Date D\u00E9but";
				for(int i=0;i<choix.getListeEdition().size();i++) {
					info[i+1][0]=choix.getNomRallye();
					info[i+1][1]=choix.getListeEdition().get(i).getNoEdition();
					info[i+1][2]=choix.getListeEdition().get(i).getDateDebER();
					info[i+1][3]=choix.getListeEdition().get(i).getDateFinER();
				}
				tabInfoRallye.setModel(new DefaultTableModel(info,
						new String[] {
								"Rallye", "Edition", "Date D\u00E9but", "Date Fin"
				}));
				tabInfoRallye.getColumnModel().getColumn(0).setPreferredWidth(150);
				tabInfoRallye.getColumnModel().getColumn(1).setPreferredWidth(50);
				tabInfoRallye.getColumnModel().getColumn(2).setPreferredWidth(150);
				tabInfoRallye.getColumnModel().getColumn(3).setPreferredWidth(150);
				contentPane.add(tabInfoRallye);
				
			}
		});
		cBoxEdition.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Edition choix = ffrag.getRallye(cBoxRallye.getSelectedItem().toString()).getEdition(Integer.valueOf(cBoxEdition.getSelectedItem().toString()));
				if(!(choix.getChampion()==null)) {
					jeune.setText(choix.getChampion().getCoureur().getNomCoureur()+" "+choix.getChampion().getCoureur().getPrenomCoureur());
				}
				Object[][] etape = new Object[choix.getListEtape().size()+1][2];
				etape[0][0]="Etape"; etape[0][1]="Distance";
				for(int i=0;i<choix.getListEtape().size();i++) {
					etape[i+1][0]=choix.getListEtape().get(i).getCodeEtape();
					etape[i+1][1]=choix.getListEtape().get(i).getDistanceEtape()+" km";
				}
				tabInfoEtape.setModel(new DefaultTableModel(etape,
						new String[] {
								"Etape", "Distance"
				}));
				contentPane.add(tabInfoEtape);
			}
		});
	}
}
