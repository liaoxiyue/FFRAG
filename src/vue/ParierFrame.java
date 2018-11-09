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
		setBounds(100, 100, 714, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVosParis = new JLabel("Vos Paris");
		lblVosParis.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblVosParis.setBounds(91, 31, 96, 36);
		contentPane.add(lblVosParis);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 79, 627, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Edition", "Pilot", "Mise", "Cotation", "Gain"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(168);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(158);
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
        	infoParis[i][0]=p.getEditionConcerne().getRallye().getNomRallye() + "-" + p.getParticipant().getEdition().getSaison();
        	infoParis[i][1]=p.getParticipant().getCoureur().getPrenomCoureur() + " " + p.getParticipant().getCoureur().getNomCoureur();
        	infoParis[i][2]=p.getMise();
        	infoParis[i][3]=1;
        	String gain = p.getGain();
        	if(gain == null) {
        		gain = "en cours";
        	}
        	infoParis[i][4]=gain;
        }
        table.setModel(new DefaultTableModel(
        		infoParis,
        	new String[] {
        		"Edition", "Pilot", "Mise", "Cotation", "Gain"
        	}
        ));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(168);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(158);
        scrollPane.setViewportView(table);
        
		
		JButton btnFaireUnPari = new JButton("faire un pari");
		btnFaireUnPari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Parier frame = new Parier(ffrag,parieur);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnFaireUnPari.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnFaireUnPari.setBounds(469, 38, 161, 27);
		contentPane.add(btnFaireUnPari);
		
		JButton btnRafraichir = new JButton("rafraichir");
		btnRafraichir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		        	infoParis[i][0]=p.getEditionConcerne().getRallye().getNomRallye() + "-" + p.getParticipant().getEdition().getSaison();
		        	infoParis[i][1]=p.getParticipant().getCoureur().getPrenomCoureur() + " " + p.getParticipant().getCoureur().getNomCoureur();
		        	infoParis[i][2]=p.getMise();
		        	infoParis[i][3]=1;
		        	String gain = p.getGain();
		        	if(gain == null) {
		        		gain = "en cours";
		        	}
		        	infoParis[i][4]=gain;
		        }
		        table.setModel(new DefaultTableModel(
		        		infoParis,
		        	new String[] {
		        		"Edition", "Pilot", "Mise", "Cotation", "Gain"
		        	}
		        ));
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(168);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(158);
		        scrollPane.setViewportView(table);
			}
		});
		btnRafraichir.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnRafraichir.setBounds(302, 38, 113, 27);
		contentPane.add(btnRafraichir);
	}
}


