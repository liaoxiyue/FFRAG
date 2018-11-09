package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import FFRAG.FFRAG;
import FFRAG.Parieur;
import FFRAG.Paris;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParierFrame extends JFrame {
	private JPanel contentPane;
	private FFRAG ffrag;
	private Parieur parieur;
	private JTable table;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ParierFrame frame = new ParierFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the frame.
	 * @param ffrag 
	 */
	public ParierFrame(FFRAG ffrag, Parieur parieur) {
		this.ffrag=ffrag;
		this.parieur = parieur;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 538, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVosParis = new JLabel("Vos Paris");
		lblVosParis.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblVosParis.setBounds(91, 31, 96, 36);
		contentPane.add(lblVosParis);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 79, 436, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
        table.setColumnSelectionAllowed(true);
        table.setGridColor(new java.awt.Color(100, 189, 189));
        table.setCellSelectionEnabled(true);
        table.setFont(new Font("Cambria", Font.PLAIN, 13));
        table.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        table.setRowHeight(20);
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        int length = parieur.getListParis().size();
        Object[][] infoParis = new Object[length][5];
        for(int i = 0; i< length; i++) {
        	Paris p = parieur.getListParis().get(i);
        	infoParis[i][0]=p.getParticipant().getCoureur();
        	infoParis[i][1]=p.getEditionConcerne();
        	infoParis[i][2]=p.getMise();
        	infoParis[i][3]=1;
        	infoParis[i][4]=p.getGainClassEtape();
        }
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Edition", "Pilot", "Mise", "Cotation", "Gain"
        	}
        ));
        scrollPane.setViewportView(table);
        
        table = new JTable();
        scrollPane.setColumnHeaderView(table);
		
		JButton btnFaireUnPari = new JButton("faire un pari");
		btnFaireUnPari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Parier frame = new Parier(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnFaireUnPari.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnFaireUnPari.setBounds(306, 38, 161, 27);
		contentPane.add(btnFaireUnPari);
	}
}
