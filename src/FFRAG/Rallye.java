package FFRAG;
import java.util.*;
public class Rallye {
	private String nomRallye;
	private String ville;
	private String pays;
	private ArrayList<Edition> listeEdition;
	private Coureur championPlusJeune;
	
	public Rallye(String nom, String ville, String pays) {
		this.nomRallye = nom;
		this.ville=ville;
		this.pays=pays;
		listeEdition = new ArrayList<Edition>();
	}
	
	public String getNomRallye() {
		return this.nomRallye;
	}
	
	public void organiser(int noE, Date deb, Date fin, String saison) {
		Edition edition = new Edition(noE, deb, fin, saison);
		listeEdition.add(edition);
	}
	
	public void setChampionPlusJeune() {
		Coureur plusJeune = listeEdition.get(0).getChampion().getCoureur();
		Date nePlusJeune = listeEdition.get(0).getChampion().getCoureur().getDateNaissanceC();
		for(int i=0; i<listeEdition.size();i++) {
			Date ne=listeEdition.get(i).getChampion().getCoureur().getDateNaissanceC();
			if(ne.getTime() > nePlusJeune.getTime()) {
				nePlusJeune = ne;
				plusJeune = listeEdition.get(i).getChampion().getCoureur();
			}
		}
		this.championPlusJeune = plusJeune;
	}
	
	public Coureur getChampionPlusJeune() {	
		return this.championPlusJeune;
	}
	public ArrayList<Edition> getListeEdition() {
		return listeEdition;
	}
	
	public Edition getEdition(int noEdition) {
		Edition edition = null;
		for(Edition e : listeEdition) {
			if(e.getNoEdition() == noEdition) {
				edition = e;
			}
		}
		return edition;
	}

	public String getVille() {
		return ville;
	}
	public String getPays() {
		return pays;
	}

}