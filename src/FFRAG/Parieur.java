package FFRAG;

import java.util.ArrayList;
/**
 * 
 * @author 21511708
 *
 */
public class Parieur {
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private ArrayList<Paris> listParis;

	public Parieur(String nom, String prenom, String tel, String mail, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail=mail;
		this.mdp=mdp;
		this.listParis = new ArrayList<Paris>();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
		
	public String getMail() {
		return mail;
	}

	public String getMdp() {
		return mdp;
	}

	public ArrayList<Paris> getListParis() {
		return listParis;
	}
	
	public void parier(Paris paris){ //affecter un pari � ce parieur
		listParis.add(paris);
	}
	
}
