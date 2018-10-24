
public class Voiture extends Vehicule {
	private float puissanceV;
	private Parametres coefV = new Parametres();

	public Voiture(int v, float p) {
		super(v);
		this.puissanceV = p;

	}

	public float getPuissanceV() {
		return puissanceV;
	}

	public float getCoef() {

		float coefV = 1 + (puissanceV - 20) * this.coefV.getCoefCorrectifV();
		return coefV;
	}
}
