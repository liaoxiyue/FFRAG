package FFRAG;

public class Voiture extends Vehicule{
	private int puissanceV ;
	private Parametres coefV = new Parametres();
	
	public Voiture(String m, int p) {
		super(m);
		this.puissanceV = p;
	}

	public int getPuissanceV() {
		return puissanceV;
	}

	public float getCoef() {
		float coefV = 1 + (puissanceV - 20)*this.coefV.getCoefCorrectifV();
		return coefV;
	}
}

