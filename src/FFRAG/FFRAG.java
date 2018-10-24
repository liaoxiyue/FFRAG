package FFRAG;

import java.util.ArrayList;

public class FFRAG {
	private ArrayList<Rallye> listRallye;
	private ArrayList<Coureur> listCoureur;
	
	public FFRAG() {
		listRallye = new ArrayList<Rallye>();
		listCoureur = new ArrayList<Coureur>();		
	}
	
	public void creationRallye(String nom, String ville, String pays){
		Rallye rallye = new Rallye(nom, ville, pays);
		this.listRallye.add(rallye);
		
	}

	public ArrayList<Rallye> getListRallye() {
		return listRallye;
	}

	public ArrayList<Coureur> getListCoureur() {
		return listCoureur;
	}
	
	
}
