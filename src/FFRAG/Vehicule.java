package FFRAG;

public abstract class Vehicule {
	protected String modele;
	

	public Vehicule(String modele) {
		this.modele = modele;
	}



	public String getModele() {
		return modele;
	}



	public abstract float getCoef();

}