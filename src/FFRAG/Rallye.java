package FFRAG;
import java.util.*;
public class Rallye {
	private String nomRallye;
	private String lieuRallye;
	private ArrayList<Edition> listeEdition;
	private Coureur championPlusJeune;
	

	public Rallye(String nom, String lieu) {
		this.nomRallye = nom;
		this.lieuRallye = lieu;
		listeEdition = new ArrayList<Edition>();
	}
	
	public void organiser(Edition edition) {
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
}