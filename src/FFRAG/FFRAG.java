package FFRAG;

/**
 * Classe FFRAG
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class FFRAG {
	private ArrayList<Rallye> listRallye;
	private ArrayList<Coureur> listCoureur;
	private ArrayList<Voiture> listVoiture;

	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Nous considerons que la classe FFRAG se compose de rallyes, coureurs et
	 * voitures
	 */
	public FFRAG() {
		this.listRallye = new ArrayList<Rallye>();
		this.listCoureur = new ArrayList<Coureur>();
		this.listVoiture = new ArrayList<Voiture>();
	}

	public ArrayList<Voiture> getListVoiture() {
		return listVoiture;
	}

	public ArrayList<Rallye> getListRallye() {
		return listRallye;
	}

	public ArrayList<Coureur> getListCoureur() {
		return listCoureur;
	}

	/**
	 * Cette methode permet de cr¨¦er un rallye avec 3 parametres obligatoires
	 * 
	 * @param nom   : le nom du rallye
	 * @param ville : la ville principale de l'evenement
	 * @param pays  : ainsi que son pays
	 */
	public void creationRallye(String nom, String ville, String pays) {
		Rallye rallye = new Rallye(nom, ville, pays);
		this.listRallye.add(rallye);

	}

	/**
	 * La methode insertCoureur permet d'inscrire un nouveau coureur dans les
	 * registres de la FFRAG il faut renseigner
	 * 
	 * @param nom         : le nom du coureur
	 * @param prenom      : ainsi que le prenom
	 * @param dateNe      : sa date de naissance
	 * @param nationalite : son pays d'origine
	 * @param sanguin     : puis son groupe sanguin
	 */
	public void insertCoureur(String nom, String prenom, Date dateNe, String nationalite, String sanguin) {
		Coureur coureur = new Coureur(nom, prenom, dateNe, nationalite, sanguin);
		this.listCoureur.add(coureur);
	}

	/**
	 * Cette methode permet de savoir si un rallye existe Si le rallye existe elle
	 * retourne alors son nom Dans le cas contraire elle retourne null
	 * 
	 * @param nomRallye : nom du rallye
	 * @return
	 */
	public Rallye getRallye(String nomRallye) {
		Rallye rallye = null;
		for (Rallye r : listRallye) {
			if (r.getNomRallye() == nomRallye) {
				rallye = r;
			}
		}
		return rallye;
	}

	/**
	 * La methode confirmeCoureur permet de savoir si un coureur existe dans les
	 * registres de la FFRAG Si le courreur existe la methode retourne son nom et
	 * prenom Sinon elle retourne null
	 * 
	 * @param nomCoureur    : nom du coureur
	 * @param prenomCoureur : prenom du coureur
	 * @return
	 */
	public Coureur confirmeCoureur(String nomCoureur, String prenomCoureur) {
		Coureur coureur = null;
		for (Coureur c : listCoureur) {
			if (c.getNomCoureur().equals(nomCoureur) && c.getPrenomCoureur().equals(prenomCoureur)) {// Nous utilison
																										// l'operateur
																										// && car la
																										// condition est
																										// que le nom et
																										// prenom
																										// doivent etre
																										// les memes
				coureur = c;
			}
		}
		return coureur;
	}

	/**
	 * Cette methode permet de savoir le nombre de participations dans une edition
	 * d'un rallye
	 * 
	 * @param coureur : objet coureur
	 * @param saison  : par exemple 2018-2019
	 * @return
	 */
	public int getNbPartSaison(Coureur coureur, String saison) {
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();// Nous cr¨¦eons une liste qui va contenir les
																	// saisons pour un rallye
		for (Rallye r : listRallye) {// Pour chaque rallye existant dans listRallye
			for (Edition e : r.getListeEdition()) {// et pour chaque edition de ces rallyes
				if (e.getSaison() == saison) {// Si la saison existe alors
					editionSaison.add(e);// nous la rajoutons dans la liste editionSaison
				}
			}
		}
		int nbPart = 0;// Nous initialisons nbPart
		for (int i = 0; i < coureur.getListParticipation().size(); i++) {// Pour chaque coureur dans ListParticipation
			for (Edition e : editionSaison) {// et pour chaque edition
				if (e.getListPart().contains(coureur.getListParticipation().get(i))) {// nous voulons connaitre les
																						// courreurs se trouvons dans
																						// les deux listes
					nbPart++;// On increment nbPart
				}
			}
		}
		return nbPart;
	}

	/**
	 * La methode getMeilleurSaison permet de connaitre la meilleur position d'un
	 * coureur pour une saison
	 * 
	 * @param coureur : objet coureur
	 * @param saison  : par exemple 2018-2019
	 * @return
	 */
	public int getMeilleurSaison(Coureur coureur, String saison) {
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();
		for (Rallye r : listRallye) {
			for (Edition e : r.getListeEdition()) {
				if (e.getSaison() == saison) {
					editionSaison.add(e);
				}
			}
		}

		int position = 100;// Nous initialisons la variable position a 100
		for (int i = 0; i < coureur.getListParticipation().size(); i++) {// Pour chaque coureur
			for (Edition e : editionSaison) {// et pour chaque edition
				if (e.getListPart().contains(coureur.getListParticipation().get(i))) {// Si le coureur a participe dans
																						// l'edition
					if (coureur.getListParticipation().get(i).getPosition() < position) {// Et si il a eu une meilleure
																							// position que 100
						position = coureur.getListParticipation().get(i).getPosition();// alors on veut connaitre sa
																						// position
					}
				}
			}
		}
		return position;
	}

	/**
	 * Cette methode nous permet de restituer toutes les informations d'une edition
	 * 
	 * @param coureur : objet coureur
	 * @param saison  : par exemple 2018-2019
	 * @return
	 */
	public HashMap<Rallye, Participant> getDetailSaison(Coureur coureur, String saison) {
		HashMap<Rallye, Participant> detailClassement = new HashMap<Rallye, Participant>();// Nous creeons un nouveau
																							// HashMap
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();// et une nouvelle liste d'edition
		for (Rallye r : listRallye) {// Pour chaque rallye
			for (Edition e : r.getListeEdition()) {// et pour chaque edition
				if (e.getSaison() == saison) {// si l'edition existe
					editionSaison.add(e);// nous la rajoutons dans la liste editionSaison
				}
			}
		}

		for (int i = 0; i < coureur.getListParticipation().size(); i++) {// Pour chaque coureur
			for (Edition e : editionSaison) {// et pour chaque edition
				if (e.getListPart().contains(coureur.getListParticipation().get(i))) {// si le coureur participe dans
																						// cette edition
					for (Rallye r : listRallye) {// nous allons verifier pour chaque rallye
						if (r.getListeEdition().contains(e)) {// si cette edition existe
							detailClassement.put(r, coureur.getListParticipation().get(i));// dans ce cas, nous allons
																							// afficher les details de
																							// cette edition
						}
					}
				}
			}
		}
		return detailClassement;
	}



	/**
	 * La methode insertVoiture permet d'enregistrer une nouvelle voiture en
	 * fonction de
	 * 
	 * @param string : modele de la voiture
	 * @param pui    : puissance de la voiture
	 */

	public void insertVoiture(String string, int pui) {
		this.listVoiture.add(new Voiture(string, pui));
	}

	public Voiture getVoiture(String model) {
		Voiture voiture = null;
		for(Voiture v : listVoiture) {
			if(v.getModele() == model) {
				voiture = v;
			}
		}
		return voiture;
	}

}