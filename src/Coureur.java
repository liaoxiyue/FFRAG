import java.util.*;

public class Coureur {
	private String nomCoureur;
	private String prenomCoureur;
	private Date dateNaissanceC;
	private ArrayList<Participant> listPart;
	
	public Coureur(String nom, String prenom, Date datene){
		this.nomCoureur = nom;
		this.prenomCoureur = prenom;
		this.dateNaissanceC = datene;
		listPart = new ArrayList<Participant>();
	}
	
	public void inscrir(Edition edition, Vehicule vehicule) {
		Participant part = new Participant();
		listPart.add(part);
	}
}
