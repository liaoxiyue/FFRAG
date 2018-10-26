package FFRAG;

public class Voiture extends Vehicule{
	private float puissanceV ;
	private Parametres coefV = new Parametres();
	
	public Voiture(String m, float pui) {
		super(m);
		this.puissanceV = pui;
	}

	public float getPuissanceV() {
		return puissanceV;
	}

	public float getCoef() {
		float coefV = 1 + (puissanceV - 250)/25*this.coefV.getCoefCorrectifV();
		return coefV;
	}
}

