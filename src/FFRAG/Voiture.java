package FFRAG;

<<<<<<< HEAD
public class Voiture extends Vehicule{
	private float puissanceV ;
	private Parametres coefV = new Parametres();
	
	public Voiture(String m, float pui) {
=======
/**
 * Classe Voiture qui herite de la classe Vehicule
 */
public class Voiture extends Vehicule {
	private int puissanceV;
	private Parametres coefV = new Parametres();

	/**
	 * 
	 * @param m : nom du mod¨¨le de la voiture
	 * @param p : puissance d'une voiture mesuree en puissance de chevaux
	 */
	public Voiture(String m, int p) {
>>>>>>> 44087776bcb026b60dc204940a2e6b86d75fabf0
		super(m);
		this.puissanceV = pui;
	}

	public float getPuissanceV() {
		return puissanceV;
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