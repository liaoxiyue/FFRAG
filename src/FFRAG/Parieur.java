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
	private String tel;
	private String mail;
	private String mdp;
	private String ville;
	private String pays;
	private ArrayList<Paris> listParis;

	public Parieur(String nom, String prenom, String tel, String ville, String pays, String mail, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail=mail;
		this.ville = ville;
		this.pays = pays;
		this.mdp=mdp;
		this.listParis = new ArrayList<Paris>();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public String getTel() {
		return tel;
	}
	
	

	public String getMail() {
		return mail;
	}

	public String getVille() {
		return ville;
	}

	public String getPays() {
		return pays;
	}

	public String getMdp() {
		return mdp;
	}

	public ArrayList<Paris> getListParis() {
		return listParis;
	}
	
	public void parier(Paris paris){ //affecter un pari à ce parieur
		listParis.add(paris);
	}
	
}
