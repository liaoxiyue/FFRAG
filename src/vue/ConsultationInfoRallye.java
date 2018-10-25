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

import FFRAG.FFRAG;
import FFRAG.Rallye;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultationInformationsRallye = new JLabel("Consultation Informations Rallye");
		lblConsultationInformationsRallye.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblConsultationInformationsRallye.setBounds(27, 13, 307, 38);
		contentPane.add(lblConsultationInformationsRallye);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Calibri", Font.BOLD, 15));
		lblVille.setBounds(27, 95, 79, 18);
		contentPane.add(lblVille);
		
		JComboBox cBoxRallye = new JComboBox();
		String[] listRallye = new String[ffrag.getListRallye().size()+1];
		listRallye[0]="---choix du Rallye---";
		for(int i = 1; i <= ffrag.getListRallye().size(); i++) {
			listRallye[i] = ffrag.getListRallye().get(i-1).getNomRallye();
		}
		cBoxRallye.setModel(new DefaultComboBoxModel(listRallye));
		cBoxRallye.setEditable(true);
		cBoxRallye.setToolTipText("");
		cBoxRallye.setBounds(106, 60, 154, 24);
		contentPane.add(cBoxRallye);
		
		JLabel lblChoixEdition = new JLabel("Choix Edition");
		lblChoixEdition.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChoixEdition.setBounds(274, 64, 101, 18);
		contentPane.add(lblChoixEdition);
		
		JComboBox cBoxEdition = new JComboBox();
		cBoxEdition.setBounds(375, 60, 98, 24);
		contentPane.add(cBoxEdition);
		
		tabInfoRallye = new JTable();
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
		tabInfoRallye.setBounds(27, 126, 573, 64);
		contentPane.add(tabInfoRallye);
		
		JLabel lblChoixEtape = new JLabel("Choix Etape");
		lblChoixEtape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChoixEtape.setBounds(27, 209, 79, 18);
		contentPane.add(lblChoixEtape);
		
		JComboBox cBoxEtape = new JComboBox();
		cBoxEtape.setBounds(120, 205, 98, 24);
		contentPane.add(cBoxEtape);
		
		tabInfoEtape = new JTable();
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
		tabInfoEtape.setBounds(27, 242, 338, 64);
		contentPane.add(tabInfoEtape);
		
		JLabel label = new JLabel("Choix Rallye");
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(27, 64, 79, 18);
		contentPane.add(label);
		
		JLabel lblPays = new JLabel("Pays :");
		lblPays.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPays.setBounds(181, 94, 79, 18);
		contentPane.add(lblPays);
		
		JLabel ville = new JLabel("");
		ville.setFont(new Font("Calibri", Font.BOLD, 15));
		ville.setBounds(88, 94, 79, 18);
		contentPane.add(ville);
		
		JLabel pays = new JLabel("");
		pays.setFont(new Font("Calibri", Font.BOLD, 15));
		pays.setBounds(229, 94, 79, 18);
		contentPane.add(pays);
		
		
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
				
			}
		});
		
	}
}
