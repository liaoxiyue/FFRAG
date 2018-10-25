package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FFRAG.FFRAG;
import FFRAG.Rallye;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.ScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreationEdition extends JFrame {

	private JPanel contentPane;
	private FFRAG ffrag;
	private JTextField textFieldSaison;
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Create the frame.
	 */
	public CreationEdition(FFRAG ffrag) {
		this.ffrag = ffrag;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrationEdition = new JLabel("Cr\u00E9ation Edition");
		lblCrationEdition.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
		lblCrationEdition.setBounds(10, 10, 159, 21);
		contentPane.add(lblCrationEdition);
		

		JComboBox comboBoxRallye = new JComboBox();
		String[] listRallye = new String[ffrag.getListRallye().size()+1];
		listRallye[0] = "---Choix de Rallye---";
		for(int i = 0; i < ffrag.getListRallye().size(); i++) {
			listRallye[i+1] = ffrag.getListRallye().get(i).getNomRallye();
		}
		comboBoxRallye.setModel(new DefaultComboBoxModel(listRallye));
		comboBoxRallye.setToolTipText("");
		comboBoxRallye.setBounds(84, 41, 141, 30);
		contentPane.add(comboBoxRallye);
		
		JLabel lblRallye = new JLabel("Rallye");
		lblRallye.setFont(new Font("Calibri", Font.BOLD, 15));
		lblRallye.setBounds(20, 50, 54, 15);
		contentPane.add(lblRallye);
		
		JLabel lblSaison = new JLabel("Saison");
		lblSaison.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSaison.setBounds(20, 123, 54, 15);
		contentPane.add(lblSaison);
		
		JLabel lblDateDeFin = new JLabel("Date de fin");
		lblDateDeFin.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDateDeFin.setBounds(20, 181, 79, 15);
		contentPane.add(lblDateDeFin);
		
		JLabel lblDateDeDbut = new JLabel("Date de d\u00E9but");
		lblDateDeDbut.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDateDeDbut.setBounds(20, 152, 99, 15);
		contentPane.add(lblDateDeDbut);
		
		JLabel lblCrerUnNouveau = new JLabel("<html><u>Cr\u00E9er un nouveau Rallye</u></html>");
		
		lblCrerUnNouveau.setForeground(SystemColor.textHighlight);
		lblCrerUnNouveau.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblCrerUnNouveau.setBounds(20, 81, 149, 21);
		contentPane.add(lblCrerUnNouveau);
		
		JComboBox comboBoxDebAnnee = new JComboBox();
		String[] anneeDeb = new String[4];
		anneeDeb[0] = "Annee";
		for(int i = 1; i < 4; i++) {
			anneeDeb[i] = "";
			Calendar c = Calendar.getInstance();
			int annee = c.get(Calendar.YEAR) + i - 1;
			anneeDeb[i] += annee;
		}
		comboBoxDebAnnee.setModel(new DefaultComboBoxModel(anneeDeb));
		comboBoxDebAnnee.setBounds(140, 148, 70, 21);
		contentPane.add(comboBoxDebAnnee);
		
		JComboBox comboBoxDebMois = new JComboBox();
		String[] mois = new String[13];
		mois[0] = "Mois";
		for(int i = 1; i < 13; i++) {
			mois[i] = "";
			mois[i] += i;
		}
		comboBoxDebMois.setModel(new DefaultComboBoxModel(mois));
		comboBoxDebMois.setBounds(220, 148, 60, 21);
		contentPane.add(comboBoxDebMois);
		
		JComboBox comboBoxDebJour = new JComboBox();
		comboBoxDebJour.setModel(new DefaultComboBoxModel(new String[] {"Jour"}));
		comboBoxDebJour.setBounds(290, 148, 63, 21);
		contentPane.add(comboBoxDebJour);
		
		JComboBox comboBoxFinAnnee = new JComboBox();
		comboBoxFinAnnee.setModel(new DefaultComboBoxModel(new String[] {"Annee"}));
		comboBoxFinAnnee.setBounds(140, 177, 70, 21);
		contentPane.add(comboBoxFinAnnee);
		
		JComboBox comboBoxFinMois = new JComboBox();
		comboBoxFinMois.setModel(new DefaultComboBoxModel(mois));
		comboBoxFinMois.setBounds(220, 177, 60, 21);
		contentPane.add(comboBoxFinMois);
		
		JComboBox comboBoxFinJour = new JComboBox();
		comboBoxFinJour.setModel(new DefaultComboBoxModel(new String[] {"Jour"}));
		comboBoxFinJour.setBounds(290, 177, 63, 21);
		contentPane.add(comboBoxFinJour);
		
		textFieldSaison = new JTextField();
		textFieldSaison.setEditable(false);
		textFieldSaison.setBounds(140, 119, 85, 21);
		contentPane.add(textFieldSaison);
		textFieldSaison.setColumns(10);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(20, 232, 333, 116);
		contentPane.add(scrollPane);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(new Font("Calibri", Font.BOLD, 15));
		btnEnregistrer.setBounds(26, 388, 115, 30);
		contentPane.add(btnEnregistrer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Calibri", Font.BOLD, 15));
		btnAnnuler.setBounds(192, 388, 115, 30);
		contentPane.add(btnAnnuler);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxRallye, lblCrerUnNouveau, textFieldSaison, comboBoxDebAnnee, comboBoxDebMois, comboBoxDebJour, comboBoxFinAnnee, comboBoxFinMois, comboBoxFinJour, lblRallye, lblSaison, lblCrationEdition, lblDateDeFin, lblDateDeDbut}));
	
		
		lblCrerUnNouveau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCrerUnNouveau.setForeground(new Color(128, 0, 128));
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CreationRallye frame = new CreationRallye(ffrag);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCrerUnNouveau.setForeground(new Color(0, 0, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCrerUnNouveau.setForeground(SystemColor.textHighlight);
			}
		});
		
		comboBoxDebAnnee.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange() && comboBoxDebAnnee.getSelectedIndex() != 0) {
					Calendar c = Calendar.getInstance();
					int annee = c.get(Calendar.YEAR);
					int nbAnneeFin = annee + 3 - Integer.valueOf(comboBoxDebAnnee.getSelectedItem().toString()) + 1; 
					String[] anneeFin = new String[nbAnneeFin];
					anneeFin[0] = "Annee";
					for(int i = 1; i < nbAnneeFin; i++) {
						anneeFin[i] = "" + (Integer.valueOf(comboBoxDebAnnee.getSelectedItem().toString()) + i - 1);
					}
					comboBoxFinAnnee.setModel(new DefaultComboBoxModel(anneeFin));
				}
				else if(ItemEvent.SELECTED == e.getStateChange() && comboBoxDebAnnee.getSelectedIndex() == 0) {
					comboBoxFinAnnee.setModel(new DefaultComboBoxModel(new String[] {"Annee"}));
				}
			}
		});
		
		comboBoxDebMois.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String saison;
				if(ItemEvent.SELECTED == e.getStateChange()) {
					switch (comboBoxDebMois.getSelectedIndex()){
						case 0 : comboBoxDebJour.setModel(new DefaultComboBoxModel(new String[] {"Jour"}));
						break;
						case 1 : 
						case 3 :
						case 5 :
						case 7 :
						case 8 :
						case 10 :
						case 12 :
							String[] jour1 = new String[32];
							jour1[0] = "Jour";
							for(int i = 1; i < 32; i++) {
								jour1[i] = "" + i;
							}
							comboBoxDebJour.setModel(new DefaultComboBoxModel(jour1));
						break;
						case 4 :
						case 6 :
						case 9 :
						case 11 :
							String[] jour2 = new String[31];
							jour2[0] = "Jour";
							for(int i = 1; i < 31; i++) {
								jour2[i] = "" + i;
							}
							comboBoxDebJour.setModel(new DefaultComboBoxModel(jour2));
						break;
						case 2 :
							if(Integer.valueOf(comboBoxDebAnnee.getSelectedItem().toString())%4 == 0) {
								String[] jour3 = new String[30];
								jour3[0] = "Jour";
								for(int i = 1; i < 30; i++) {
									jour3[i] = "" + i;
								}
								comboBoxDebJour.setModel(new DefaultComboBoxModel(jour3));
							}
							else {
								String[] jour3 = new String[29];
								jour3[0] = "Jour";
								for(int i = 1; i < 29; i++) {
									jour3[i] = "" + i;
								}
								comboBoxDebJour.setModel(new DefaultComboBoxModel(jour3));
							}
					}
					if(comboBoxDebMois.getSelectedIndex() <= 6) {
						saison ="" + (Integer.valueOf(comboBoxDebAnnee.getSelectedItem().toString()) - 1) + " / " + comboBoxDebAnnee.getSelectedItem().toString();
					}
					else {
						saison =comboBoxDebAnnee.getSelectedItem().toString() + " / " + (Integer.valueOf(comboBoxDebAnnee.getSelectedItem().toString()) + 1);
					}
					textFieldSaison.setText(saison);
				}
			}
		});
		
		comboBoxFinMois.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(ItemEvent.SELECTED == e.getStateChange()) {
					switch (comboBoxFinMois.getSelectedIndex()){
						case 0 : comboBoxFinJour.setModel(new DefaultComboBoxModel(new String[] {"Jour"}));
						break;
						case 1 : 
						case 3 :
						case 5 :
						case 7 :
						case 8 :
						case 10 :
						case 12 :
							String[] jour1 = new String[32];
							jour1[0] = "Jour";
							for(int i = 1; i < 32; i++) {
								jour1[i] = "" + i;
							}
							comboBoxFinJour.setModel(new DefaultComboBoxModel(jour1));
						break;
						case 4 :
						case 6 :
						case 9 :
						case 11 :
							String[] jour2 = new String[31];
							jour2[0] = "Jour";
							for(int i = 1; i < 31; i++) {
								jour2[i] = "" + i;
							}
							comboBoxFinJour.setModel(new DefaultComboBoxModel(jour2));
						break;
						case 2 :
							if(Integer.valueOf(comboBoxDebAnnee.getSelectedItem().toString())%4 == 0) {
								String[] jour3 = new String[30];
								jour3[0] = "Jour";
								for(int i = 1; i < 30; i++) {
									jour3[i] = "" + i;
								}
								comboBoxFinJour.setModel(new DefaultComboBoxModel(jour3));
							}
							else {
								String[] jour3 = new String[29];
								jour3[0] = "Jour";
								for(int i = 1; i < 29; i++) {
									jour3[i] = "" + i;
								}
								comboBoxFinJour.setModel(new DefaultComboBoxModel(jour3));
							}
					}
				}
			}
		});
		
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String debString = comboBoxDebAnnee.getSelectedItem().toString() + "-" + comboBoxDebMois.getSelectedItem().toString() + "-" + comboBoxDebJour.getSelectedItem().toString();
				java.util.Date deb = null;
				try {
					deb = dateformat.parse(debString);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				String finString = comboBoxFinAnnee.getSelectedItem().toString() + "-" + comboBoxFinMois.getSelectedItem().toString() + "-" + comboBoxFinJour.getSelectedItem().toString();
				java.util.Date fin = null;
				try {
					fin = dateformat.parse(finString);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				Rallye rallye = ffrag.getRallye(comboBoxRallye.getSelectedItem().toString());
				rallye.organiser(rallye.getListeEdition().size()+1, deb, fin);
				System.out.println(rallye.getListeEdition().get(rallye.getListeEdition().size()-1).getNoEdition());
				System.out.println(rallye.getListeEdition().get(rallye.getListeEdition().size()-1).getDateDebER());
				System.out.println(rallye.getListeEdition().get(rallye.getListeEdition().size()-1).getDateFinER());
			}
		});
	}
	
}
