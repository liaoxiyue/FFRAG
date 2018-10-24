
public class Voiture extends Vehicule{
	private int puissanceV ;
	private Parametres coefV = new Parametres();
	
	public Voiture(String v, int p) {
		super(v);
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

