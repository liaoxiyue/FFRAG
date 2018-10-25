package FFRAG;
import java.util.*;

public class Coureur {
	private String nomCoureur;
	private String prenomCoureur;
	private Date dateNaissanceC;
	private String sanguin;
	private String nationalite;
	private ArrayList<Participant> listParticipation;
	
	public Coureur(String nom, String prenom, Date datene, String nationalite, String sanguin){
		this.nomCoureur = nom;
		this.prenomCoureur = prenom;
		this.dateNaissanceC = datene;
		this.nationalite = nationalite;
		this.sanguin = sanguin;
		this.listParticipation = new ArrayList<Participant>();
	}
	
	public ArrayList<Participant> getListParticipation() {
		return listParticipation;
	}

	public Date getDateNaissanceC() {
		return dateNaissanceC;
	}
	public void affecterParticipation(Participant p) {
		this.listParticipation.add(p);
	}
	
	public int getTitreReporte() {
		int titreReporte = 0;
		for(Participant p : listParticipation) {
			if(p.getPosition() == 1) {
				titreReporte++;
			}
		}
		return titreReporte;
	}
	public String getNomCoureur() {
		return this.nomCoureur;
	}
	public String getPrenomCoureur() {
		return prenomCoureur;
	}
}




