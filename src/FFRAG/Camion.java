package FFRAG;

public class Camion extends Vehicule {
	private float poidsC;
	private Parametres coefC = new Parametres();
	public Camion(String m, float p) {
		super(m);
		this.poidsC = p;
	}
	public float getPoidsC() {
		return poidsC;
	}
	
	public float getCoef() {
			float coefC = 1 - ((this.poidsC-2000)/100)*this.coefC.getCoefCorrectifC();
		return coefC;
		}
	}


