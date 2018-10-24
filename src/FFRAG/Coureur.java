package FFRAG;
import java.util.*;

public class Coureur {
	private String nomCoureur;
	private String prenomCoureur;
	private Date dateNaissanceC;
	
	public Coureur(String nom, String prenom, Date datene){
		this.nomCoureur = nom;
		this.prenomCoureur = prenom;
		this.dateNaissanceC = datene;
	}

	public Date getDateNaissanceC() {
		return dateNaissanceC;
	}
	
}
