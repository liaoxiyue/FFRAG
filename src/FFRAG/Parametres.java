package FFRAG;

/**
 * Classe Parametres
 */
public class Parametres {
	public float coefCorrectifV = (float) 0.05;// Nous fixons le coefficient correctif pour une voiture a 0.05
	public float coefCorrectifC = (float) 0.1;// Et pour un camion a 0.1

	public float getCoefCorrectifV() {
		return coefCorrectifV;
	}

	public float getCoefCorrectifC() {
		return coefCorrectifC;
	}
}