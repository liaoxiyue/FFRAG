package FFRAG;


/**
 * Classe Voiture qui herite de la classe Vehicule
 */
public class Voiture {
	private String modele;
	private int puissanceV;
	private Parametres coefV = new Parametres();
	private int poids;
	private int adherence;

	/**
	 * 
	 * @param m : nom du mod¨¨le de la voiture
	 * @param p : puissance d'une voiture mesuree en puissance de chevaux
	 */
	public Voiture(String m, int p) {
		this.modele = m;
		this.puissanceV = p;
	}

	public String getModele() {
		return modele;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public void setAdherence(int adherence) {
		this.adherence = adherence;
	}

	public int getPuissanceV() {
		return puissanceV;
	}

	
	public int getPoids() {
		return poids;
	}

	public int getAdherence() {
		return adherence;
	}

	/**
	 * Cette methode permet de calculer le coefficient corrcetif pour une voiture
	 * Dans la methode de calcul nous prenons en compte la puissance de la voiture A
	 * laquelle nous appliquons le coefficient correctif deja fixe pour une voiture
	 * qui est determine dans la classe Parametres
	 */
	public float getCoef() {
		float coefV = 1 + (puissanceV - 250) / 25 * this.coefV.getCoefCorrectifV();
		return coefV;
	}

}