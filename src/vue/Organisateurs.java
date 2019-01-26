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

public class Organisateurs extends JFrame {

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
	public Organisateurs(FFRAG ffrag) {
		this.ffrag=ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreationEdition = new JButton("Creation edition");
		btnCreationEdition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreationEdition frame = new CreationEdition(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		
		btnCreationEdition.setFont(new Font("Calibri", Font.BOLD, 15));
		btnCreationEdition.setBounds(56, 138, 202, 27);
		contentPane.add(btnCreationEdition);
		
		JLabel lblBienvenuPour = new JLabel("Bienvenue ! ");
		lblBienvenuPour.setFont(new Font("Eras Bold ITC", Font.PLAIN, 27));
		lblBienvenuPour.setBounds(285, 34, 202, 53);
		contentPane.add(lblBienvenuPour);
		
		JButton btnConsultationClassementRallye = new JButton("Classement du rallye");
		btnConsultationClassementRallye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ConsultationClassementR frame = new ConsultationClassementR(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnConsultationClassementRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		btnConsultationClassementRallye.setBounds(380, 168, 270, 27);
		contentPane.add(btnConsultationClassementRallye);

		JButton btnConsultationClassementSaison = new JButton("Classement saison");
		btnConsultationClassementSaison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClassementSaison frame = new ClassementSaison(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnConsultationClassementSaison.setFont(new Font("Calibri", Font.BOLD, 15));
		btnConsultationClassementSaison.setBounds(380, 215, 270, 27);
		contentPane.add(btnConsultationClassementSaison);
		
		JButton btnValitationClassementEtape = new JButton("Valitation classement ¨¦tape");
		btnValitationClassementEtape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ValitationClasseEtape frame = new ValitationClasseEtape(ffrag);
					frame.setVisible(true);
				} catch (Exception ecr) {
					ecr.printStackTrace();
				}
			}
		});
		btnValitationClassementEtape.setFont(new Font("Calibri", Font.BOLD, 15));
		btnValitationClassementEtape.setBounds(380, 128, 270, 27);
		contentPane.add(btnValitationClassementEtape);
		
		JButton btnCreationRallye = new JButton("Cr¨¦er un rallye");
		btnCreationRallye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CreationRallye frame = new CreationRallye(ffrag);
					frame.setVisible(true);
				} catch (Exception ecr) {
					ecr.printStackTrace();
				}
			}
		});
		btnCreationRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		btnCreationRallye.setBounds(56, 189, 202, 27);
		contentPane.add(btnCreationRallye);
		
		JButton btnConsultationInfosRallye = new JButton("Consulter infos rallye");
		btnConsultationInfosRallye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConsultationInfoRallye frame = new ConsultationInfoRallye(ffrag);
					frame.setVisible(true);
				} catch (Exception ecir) {
					ecir.printStackTrace();
				}
			}
		});
		btnConsultationInfosRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		btnConsultationInfosRallye.setBounds(56, 239, 202, 27);
		contentPane.add(btnConsultationInfosRallye);
		
		JButton btnConsultationClassementProbable = new JButton("Classement Probable");
		btnConsultationClassementProbable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		btnConsultationClassementProbable.setFont(new Font("Calibri", Font.BOLD, 15));
		btnConsultationClassementProbable.setBounds(380, 255, 270, 27);
		contentPane.add(btnConsultationClassementProbable);
		
		JLabel back = new JLabel();
		back.setIcon(new ImageIcon(Bienvenue.class.getResource("/image/background.jpeg")));
		back.setBounds(0, 0, 800, 533);
		this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		((JPanel)this.getContentPane()).setOpaque(false);
		contentPane.add(back);
	}
}
