package FFRAG;

import java.text.ParseException;
/**
 * Classe FFRAG
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class FFRAG {
	private ArrayList<Rallye> listRallye;
	private ArrayList<Coureur> listCoureur;
	private ArrayList<Voiture> listVoiture;
	private ArrayList<Parieur> listParieur;
	private String csvPath;
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateformat2 = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Nous considerons que la classe FFRAG se compose de rallyes, coureurs et
	 * voitures
	 */
	public FFRAG(String path) {
		this.listRallye = new ArrayList<Rallye>();
		this.listCoureur = new ArrayList<Coureur>();
		this.listVoiture = new ArrayList<Voiture>();
		this.listParieur = new ArrayList<Parieur>();
		this.csvPath = path;
	}

	public ArrayList<Voiture> getListVoiture() {
		return listVoiture;
	}

	public ArrayList<Rallye> getListRallye() {
		return listRallye;
	}

	public String getCsvPath() {
		return csvPath;
	}

	public ArrayList<Parieur> getListParieur() {
		return listParieur;
	}

	public ArrayList<Coureur> getListCoureur() {
		return listCoureur;
	}

	public void setListRallye(ArrayList<Rallye> listRallye) {
		this.listRallye = listRallye;
	}

	public void setListCoureur(ArrayList<Coureur> listCoureur) {
		this.listCoureur = listCoureur;
	}

	public void setListVoiture(ArrayList<Voiture> listVoiture) {
		this.listVoiture = listVoiture;
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
	 * @return rallye
	 */
	public Rallye getRallye(String nomRallye) {
		Rallye rallye = null;
		for (Rallye r : listRallye) {
			if (r.getNomRallye().equals(nomRallye)) {
				rallye = r;
			}
		}
		return rallye;
	}

	/**
	 * La methode confirmeCoureur permet de savoir si un coureur existe dans les
	 * registres de la FFRAG, s'il existe la methode retourne son nom et
	 * prenom Sinon elle retourne null
	 * 
	 * @param nomCoureur    : nom du coureur
	 * @param prenomCoureur : prenom du coureur
	 * @return coureur
	 */
	public Coureur confirmeCoureur(String nomCoureur, String prenomCoureur) {
		Coureur coureur = null;
		for (Coureur c : listCoureur) {
			if (c.getNomCoureur().equals(nomCoureur) && c.getPrenomCoureur().equals(prenomCoureur)) {
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
	 * @return nbPart : nombre de participants
	 */
	public int getNbPartSaison(Coureur coureur, String saison) {
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();
		for (Rallye r : listRallye) {
			for (Edition e : r.getListeEdition()) {
				if (e.getSaison().equals(saison)) {
					editionSaison.add(e);
				}
			}
		}
		int nbPart = 0;
		for (int i = 0; i < coureur.getListParticipation().size(); i++) {
			for (Edition e : editionSaison) {
				if (e.getListPart().contains(coureur.getListParticipation().get(i))) {
					nbPart++;
				}
			}
		}
		return nbPart;
	}

	/**
	 * La methode getMeilleurSaison permet de connaitre la meilleure position d'un
	 * coureur pour une saison
	 * 
	 * @param coureur : objet coureur
	 * @param saison  : par exemple 2018-2019
	 * @return position : la meilleur position
	 */
	public int getMeilleurSaison(Coureur coureur, String saison) {
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();
		for (Rallye r : listRallye) {
			for (Edition e : r.getListeEdition()) {
				if (e.getSaison().equals(saison)) {
					editionSaison.add(e);
				}
			}
		}

		int position = 100;// Nous initialisons la variable position a 100
		for (int i = 0; i < coureur.getListParticipation().size(); i++) {
			for (Edition e : editionSaison) {
				if (e.getListPart().contains(coureur.getListParticipation().get(i))) {
					if (coureur.getListParticipation().get(i).getPosition() < position) {
						position = coureur.getListParticipation().get(i).getPosition();
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
		HashMap<Rallye, Participant> detailClassement = new HashMap<Rallye, Participant>();
		ArrayList<Edition> editionSaison = new ArrayList<Edition>();
		for (Rallye r : listRallye) {
			for (Edition e : r.getListeEdition()) {
				if (e.getSaison().equals(saison)) {
					editionSaison.add(e);
				}
			}
		}

		for (int i = 0; i < coureur.getListParticipation().size(); i++) {
			for (Edition e : editionSaison) {
				if (e.getListPart().contains(coureur.getListParticipation().get(i))) {
					for (Rallye r : listRallye) {
						if (r.getListeEdition().contains(e)) {
							detailClassement.put(r, coureur.getListParticipation().get(i));
						}
					}
				}
			}
		}
		return detailClassement;
	}


	/**
	 * La methode insertVoiture permet d'enregistrer une nouvelle voiture en
	 * fonction des param¨¨tres suivants :
	 * 
	 * @param string : modele de la voiture
	 * @param pui    : puissance de la voiture
	 */

	public void insertVoiture(String string, int pui, int poids, int ad) {
		this.listVoiture.add(new Voiture(string, pui, poids, ad));
	}


	/**
	 *  La m¨¦thode getVoiture permet d'obtenir un objet voiture depuis la mod¨¨le de la voiture
	 *  S'il existe pas on retourne null
	 * @param model
	 * @return voiture
	 */
	public Voiture getVoiture(String model) {
		Voiture voiture = null;
		for(Voiture v : listVoiture) {
			if(v.getModele().equals(model)) {
				voiture = v;
			}
		}
		return voiture;
	}

	/**
	 * Cette m¨¦thode permet d'obtenir l'ArrayList des editions qui sont ouvertes aux paris
	 * @return editionAPari : ArrayList de l'objet Edition 
	 * @throws ParseException
	 */
	public ArrayList<Edition> editionAPari() throws ParseException{
		ArrayList<Edition> editionAPari = new ArrayList<Edition>();
		Date datedeb = dateformat2.parse("01/10/2017"); //la date qu'on a ¨¦crit manuellement est juste pour qu'on peut tester en donn¨¦es actuelles
		Calendar dt = Calendar.getInstance();
		dt.setTime(datedeb);
		dt.add(Calendar.MONTH, 3);
		Date datefin = dt.getTime();

		for(int i = 0; i < this.getListRallye().size(); i++) {
			for(int j = 0; j < this.getListRallye().get(i).getListeEdition().size(); j++) {
				Edition edition = this.getListRallye().get(i).getListeEdition().get(j);
				if(edition.getDateDebER().before(datefin) && datedeb.before(edition.getDateDebER())) {
					editionAPari.add(edition);
				}
			}
		}
		return editionAPari;
	}

}