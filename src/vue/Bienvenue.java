package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.FFRAG;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Bienvenue extends JFrame {

	private JPanel contentPane;
	private FFRAG ffrag;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenue frame = new Bienvenue();
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
	public Bienvenue(FFRAG ffrag) {
		this.ffrag=ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInscription = new JButton("Coureur");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LogCoureur frame = new LogCoureur(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnInscription.setFont(new Font("Calibri", Font.BOLD, 15));
		btnInscription.setBounds(490, 138, 156, 27);
		contentPane.add(btnInscription);
		
		JButton btnOrganisateur = new JButton("Organisateur");
		btnOrganisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Organisateurs frame = new Organisateurs(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnOrganisateur.setFont(new Font("Calibri", Font.BOLD, 15));
		btnOrganisateur.setBounds(157, 137, 156, 27);
		contentPane.add(btnOrganisateur);
		
		JLabel lblBienvenuPour = new JLabel("Bienvenue ! ");
		lblBienvenuPour.setFont(new Font("Eras Bold ITC", Font.PLAIN, 27));
		lblBienvenuPour.setBounds(285, 34, 202, 53);
		contentPane.add(lblBienvenuPour);
		

		JLabel back = new JLabel();
		back.setIcon(new ImageIcon(Bienvenue.class.getResource("/image/background.jpeg")));
		back.setBounds(0, 0, 800, 533);
		this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		((JPanel)this.getContentPane()).setOpaque(false);
		contentPane.add(back);
		

	}
}
