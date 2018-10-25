package FFRAG;

import java.util.*;

public class FFRAG {
	private ArrayList<Rallye> listRallye;
	private ArrayList<Coureur> listCoureur;
	
	public FFRAG() {
		this.listRallye = new ArrayList<Rallye>();
		this.listCoureur = new ArrayList<Coureur>();		
	}
	
	public void creationRallye(String nom, String ville, String pays){
		Rallye rallye = new Rallye(nom, ville, pays);
		this.listRallye.add(rallye);
		
	}
	
	public void insertCoureur(String nom,String prenom,Date dateNe) {
		Coureur coureur = new Coureur(nom, prenom, dateNe);
		this.listCoureur.add(coureur);
	}

	public ArrayList<Rallye> getListRallye() {
		return listRallye;
	}

	public ArrayList<Coureur> getListCoureur() {
		return listCoureur;
	}
	
	public Rallye getRallye(String nomRallye) {
		Rallye rallye = null;
		for(Rallye r : listRallye) {
			if(r.getNomRallye() == nomRallye) {
				rallye = r;
			}
		}
		return rallye;
	}
	
	public Coureur getCoureur(String nomCoureur, String prenomCoureur) {
		Coureur coureur = null;
		for(Coureur c : listCoureur) {
			if(c.getNomCoureur() == nomCoureur && c.getPrenomCoureur() == prenomCoureur) {
				coureur = c;
			}
		}
		return coureur;
	}

	
}
