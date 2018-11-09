package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClassementProbable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassementProbable frame = new ClassementProbable();
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
	public ClassementProbable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultationclassementprobale = new JLabel("Consultation Classement Probable");
		lblConsultationclassementprobale.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblConsultationclassementprobale.setBounds(150, 13, 317, 41);
		contentPane.add(lblConsultationclassementprobale);
		
		JLabel lblRallye = new JLabel("Rallye :");
		lblRallye.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblRallye.setBounds(36, 66, 72, 18);
		contentPane.add(lblRallye);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 62, 224, 24);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 110, 548, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Position", "Coureur", "Temps "
			}
		));
		scrollPane.setColumnHeaderView(table);
	}
}
