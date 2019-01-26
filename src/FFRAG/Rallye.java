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

	public String getVille() {
		return ville;
	}
	public String getPays() {
		return pays;
	}
	public String getNomRallye() {
		return this.nomRallye;
	}
	
	
	/**
	 * Cette m¨¦thode permet d'obtenir le champion le plus jeune d'un rallye
	 * @return championPlusJeune : objet Coureur le champion le plus jeune 
	 */
	public Coureur getChampionPlusJeune() {
		Coureur plusJeune = listeEdition.get(0).getChampion().getCoureur();
		Date nePlusJeune = listeEdition.get(0).getChampion().getCoureur().getDateNaissanceC();
		for(int i=0; i<listeEdition.size();i++) {
			if(listeEdition.get(i).getChampion()==null) {
				
			}else{
				Date ne=listeEdition.get(i).getChampion().getCoureur().getDateNaissanceC();
				if(ne.getTime() > nePlusJeune.getTime()) { 									//on compare en boucle les dates de naissances 
					nePlusJeune = ne;
					plusJeune = listeEdition.get(i).getChampion().getCoureur();
				}
			}
		}
		this.championPlusJeune = plusJeune;
		return this.championPlusJeune;
	}
	
	public ArrayList<Edition> getListeEdition() {
		return listeEdition;
	}

	/**
	 * Cette m¨¦thode permet d'organiser une ¨¦dition
	 * @param noE : num¨¦ro d'¨¦dition organis¨¦e
	 * @param deb : date de d¨¦but de l'¨¦dition
	 * @param fin : date de fin de l'¨¦dition
	 * @param saison : saison de l'¨¦dition
	 */
	public void organiser(int noE, Date deb, Date fin, String saison) {
		Edition edition = new Edition(noE, deb, fin, saison);
		edition.setRallye(this);
		listeEdition.add(edition);
	}

	/**
	 * Cette m¨¦thode permet de v¨¦rifier si l'¨¦dition en question existe dans ce rallye
	 * @param noEdition : identifiant de l'¨¦dition recherch¨¦
	 * @return
	 */
	public Edition getEdition(int noEdition) {
		Edition edition = null;
		for(Edition e : listeEdition) {
			if(e.getNoEdition() == (noEdition)) {
				edition = e;
			}
		}
		return edition;
	}



}