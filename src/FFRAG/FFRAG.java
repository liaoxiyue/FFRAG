package FFRAG;

import java.text.SimpleDateFormat;
import java.util.*;

public class FFRAG {
	private ArrayList<Rallye> listRallye;
	private ArrayList<Coureur> listCoureur;
	private ArrayList<Voiture> listVoiture;

	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	
	public FFRAG() {
		this.listRallye = new ArrayList<Rallye>();
		this.listCoureur = new ArrayList<Coureur>();
		this.listVoiture = new ArrayList<Voiture>();
	}
	
	
	
	public ArrayList<Voiture> getListVoiture() {
		return listVoiture;
	}



	public void creationRallye(String nom, String ville, String pays){
		Rallye rallye = new Rallye(nom, ville, pays);
		this.listRallye.add(rallye);
		
	}
	
	public void insertCoureur(String nom,String prenom, Date dateNe, String nationalite, String sanguin) {
		Coureur coureur = new Coureur(nom, prenom, dateNe, nationalite, sanguin);
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
	

	public Coureur getCoureur(String nomCoureur, String prenomCoureur, String date) {
		Coureur coureur = null;
		for(Coureur c : listCoureur) {
			if(c.getNomCoureur() == nomCoureur && c.getPrenomCoureur() == prenomCoureur && dateformat.format(c.getDateNaissanceC()) == date) {
				coureur = c;
			}
		}
		return coureur;
	}

	public Coureur confirmeCoureur(String nomCoureur, String prenomCoureur) {
		Coureur coureur = null;
		for(Coureur c : listCoureur) {
			if(c.getNomCoureur().equals(nomCoureur) && c.getPrenomCoureur().equals(prenomCoureur)) {
				coureur = c;
			}
		}
		return coureur;
	}

	
	public int getNbPartSaison(Coureur coureur, String saison) {
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();
		for(Rallye r : listRallye) {
			for(Edition e : r.getListeEdition()) {
				if(e.getSaison() == saison) {
					editionSaison.add(e);
				}
			}
		}
		int nbPart = 0;
		for(int i = 0; i < coureur.getListParticipation().size(); i++) {
			for(Edition e : editionSaison) {
				if(e.getListPart().contains(coureur.getListParticipation().get(i))) {
					nbPart++;
				}
			}
		}
		return nbPart;
	}
	
	public int getMeilleurSaison(Coureur coureur, String saison) {
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();
		for(Rallye r : listRallye) {
			for(Edition e : r.getListeEdition()) {
				if(e.getSaison() == saison) {
					editionSaison.add(e);
				}
			}
		}
		int position=100;
		for(int i = 0; i < coureur.getListParticipation().size(); i++) {
			for(Edition e : editionSaison) {
				if(e.getListPart().contains(coureur.getListParticipation().get(i))) {
					if(coureur.getListParticipation().get(i).getPosition() < position) {
						position = coureur.getListParticipation().get(i).getPosition();
					}
				}
			}
		}
		return position;
	}
	
	public HashMap<Rallye, Participant> getDetailSaison(Coureur coureur, String saison){
		HashMap<Rallye, Participant> detailClassement = new HashMap<Rallye, Participant>();
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();
		for(Rallye r : listRallye) {
			for(Edition e : r.getListeEdition()) {
				if(e.getSaison() == saison) {
					editionSaison.add(e);
				}
			}
		}

		for(int i = 0; i < coureur.getListParticipation().size(); i++) {
			for(Edition e : editionSaison) {
				if(e.getListPart().contains(coureur.getListParticipation().get(i))) {
					for(Rallye r : listRallye) {
						if (r.getListeEdition().contains(e)) {
							detailClassement.put(r, coureur.getListParticipation().get(i));
						}
					}
				}
			}
		}
		return detailClassement;
	}


	public void insertVoiture(String string, int pui) {
		this.listVoiture.add(new Voiture(string, pui));
	}
}
