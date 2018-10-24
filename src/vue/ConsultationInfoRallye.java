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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultationInfoRallye extends JFrame {

	private JPanel contentPane;
	private JTable tabInfoRallye;
	private JTable tabInfoEtape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public ConsultationInfoRallye() {
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
		
		JComboBox cBoxRallye = new JComboBox();
		cBoxRallye.setBounds(120, 60, 98, 24);
		contentPane.add(cBoxRallye);
		
		JLabel lblChoixRallye = new JLabel("Choix Rallye");
		lblChoixRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChoixRallye.setBounds(27, 64, 79, 18);
		contentPane.add(lblChoixRallye);
		
		JLabel lblChoixEdition = new JLabel("Choix Edition");
		lblChoixEdition.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChoixEdition.setBounds(249, 64, 101, 18);
		contentPane.add(lblChoixEdition);
		
		JComboBox cBoxEdition = new JComboBox();
		cBoxEdition.setBounds(350, 60, 98, 24);
		contentPane.add(cBoxEdition);
		
		JButton btnNewButton = new JButton("Consulter");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(487, 59, 113, 27);
		contentPane.add(btnNewButton);
		
		tabInfoRallye = new JTable();
		tabInfoRallye.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rallye", "Edition", "Saison", "Date D\u00E9but", "Date Fin", "Lieu"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Rallye", "Edition", "Saison", "Date D\u00E9but", "Date Fin", "Lieu"
			}
		));
		tabInfoRallye.getColumnModel().getColumn(0).setPreferredWidth(137);
		tabInfoRallye.getColumnModel().getColumn(1).setPreferredWidth(84);
		tabInfoRallye.getColumnModel().getColumn(2).setPreferredWidth(108);
		tabInfoRallye.getColumnModel().getColumn(3).setPreferredWidth(121);
		tabInfoRallye.getColumnModel().getColumn(4).setPreferredWidth(109);
		tabInfoRallye.getColumnModel().getColumn(5).setPreferredWidth(111);
		tabInfoRallye.setBounds(27, 109, 573, 64);
		contentPane.add(tabInfoRallye);
		
		JLabel lblChoixEtape = new JLabel("Choix Etape");
		lblChoixEtape.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChoixEtape.setBounds(27, 203, 79, 18);
		contentPane.add(lblChoixEtape);
		
		JComboBox cBoxEtape = new JComboBox();
		cBoxEtape.setBounds(120, 199, 98, 24);
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
	}
}
