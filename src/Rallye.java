import java.util.*;
public class Rallye {
	private String nomRallye;
	private String lieuRallye;
	private ArrayList<Edition> listeEdition;
	public Rallye(String nom, String lieu) {
		this.nomRallye = nom;
		this.lieuRallye = lieu;
		listeEdition = new ArrayList<Edition>();
	}
	
	public String getNomRallye() {
		return nomRallye;
	}

	public String getLieuRallye() {
		return lieuRallye;
	}

	public ArrayList<Edition> getListeEdition() {
		return listeEdition;
	}

	public void organiser(Edition edition) {
		listeEdition.add(edition);
	}
}