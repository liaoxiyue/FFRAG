package FFRAG;
import java.util.*;



/**
 * Classe coureur 
 * @author 21203630
 *
 */



public class Coureur {
	private String nomCoureur;
	private String prenomCoureur;
	private Date dateNaissanceC;
	private String sanguin;
	private String nationalite;
	private ArrayList<Participant> listParticipation;
	
	
	
	/**
	 * Constructeur d'un coureur
	 * @param nom : nom du coureur
	 * @param prenom : prenom du coureur
	 * @param datene : date de naissance du coureur
	 * @param nationalite : nationalite du coureur
	 * @param sanguin : groupe sanguin du coureur
	 */
	public Coureur(String nom, String prenom, Date datene, String nationalite, String sanguin){
		this.nomCoureur = nom;
		this.prenomCoureur = prenom;
		this.dateNaissanceC = datene;
		this.nationalite = nationalite;
		this.sanguin = sanguin;
		this.listParticipation = new ArrayList<Participant>();
	}
	
	public Date getDateNaissanceC() {
		return dateNaissanceC;
	}
	
	
	public String getNomCoureur() {
		return this.nomCoureur;
	}
	public String getPrenomCoureur() {
		return prenomCoureur;
	}

	public String getSanguin() {
		return sanguin;
	}

	public String getNationalite() {
		return nationalite;
	}

	public ArrayList<Participant> getListParticipation() {
		return listParticipation;
	}
	
	
	/**
	 * La m��thode affecterParticipation permet pour un coureur de stocker dans une liste toutes les participations auxquelles il a particip��.
	 * @param p : sa participation 
	 */
	public void affecterParticipation(Participant p) {
		this.listParticipation.add(p);
	}
	
	
	
	/**
	 * La m��thode getTitreReporte permet de savoir si un coureur a gagn�� une edition.
	 * @return la position du coureur a une edition 
	 */
	public int getTitreReporte() {
		int titreReporte = 0;
		for(Participant p : listParticipation) {
			if(p.getPosition() == 1) {
				titreReporte++;
			}
		}
		return titreReporte;
	}
	
	
	/**
	 * Cette m��thode permet de savoir le nombre de titre remport�� de ce coureur
	 * @return titreRemporte
	 */
	public int titreRemporte() {
		int titreRemporte = 0;
		for(int i = 0; i < listParticipation.size(); i++) {
			if(listParticipation.get(i).getPosition() == 1) {
				titreRemporte++;
			}
		}
		return titreRemporte;
	}
}



