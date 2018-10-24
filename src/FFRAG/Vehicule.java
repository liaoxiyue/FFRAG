package FFRAG;

public abstract class Vehicule {
	protected String idVehicule;
	

	public Vehicule(String v) {
		this.idVehicule=v;
	}

	public String getIdVehicule() {
		return idVehicule;
	}

	public abstract float getCoef();

}