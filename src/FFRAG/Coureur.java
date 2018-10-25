package FFRAG;
import java.util.*;

public class Coureur {
	private String nomCoureur;
	private String prenomCoureur;
	private Date dateNaissanceC;
	private ArrayList<Participant> listParticipation;
	
	public Coureur(String nom, String prenom, Date datene){
		this.nomCoureur = nom;
		this.prenomCoureur = prenom;
		this.dateNaissanceC = datene;
		this.listParticipation = new ArrayList<Participant>();
	}
	
	
	public String getNomCoureur() {
		return nomCoureur;
	}


	public String getPrenomCoureur() {
		return prenomCoureur;
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
}




