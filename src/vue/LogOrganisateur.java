package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.FFRAG;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogOrganisateur extends JFrame {

	private JPanel contentPane;
	private JTextField txtMdp;
	private FFRAG ffrag;
	/**
	 * Launch the application.
	 */
	/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOrganisateur frame = new LogOrganisateur();
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
	 */
	public LogOrganisateur(FFRAG ffrag) {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodeAdmin = new JLabel("Identifiant administrateur");
		lblCodeAdmin.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblCodeAdmin.setBounds(144, 33, 135, 39);
		contentPane.add(lblCodeAdmin);
		
		txtMdp = new JTextField();
		txtMdp.setBounds(144, 85, 108, 24);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		JButton btnLogIn = new JButton("Se connecter");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mdp = txtMdp.getText();
				if(mdp.equals("ffrag123")) {
					dispose();
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
			}
		});
		btnLogIn.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnLogIn.setBounds(144, 149, 113, 27);
		contentPane.add(btnLogIn);
	}
}
