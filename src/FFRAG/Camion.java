package FFRAG;
/**
 * Classe Camion heritee de Vehicule  
 * @author 21203630
 *
 */

public class Camion extends Vehicule {

	private float poidsC;
	private Parametres coefC = new Parametres();
	
	

	/**
	 * Constructeur d'un camion
	 * @param m : nom du modele du camion
	 * @param p : poids du camion
	 */
	public Camion(String m, float p) {
		super(m);
		this.poidsC = p;
	}
	
	
	
	public float getPoidsC() {
		return poidsC;
	}
	
	
	/**
	 * Methode calculant le coefficient correctif d'un camion
	 * @return le coefficient correctif
	 */
	public float getCoef() {
			float coefC = 1 - ((this.poidsC-2000)/100)*this.coefC.getCoefCorrectifC();
		return coefC;
		}
	}

