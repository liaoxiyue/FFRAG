import java.util.ArrayList;

public class Rallye {
	private String nomRallye;
	private String lieuRallye;
	private ArrayList<Edition> listeEdition = new ArrayList<Edition>();
	
	public Rallye(String nom, String lieu) {
		this.nomRallye = nom;
		this.lieuRallye = lieu;
	}
}

