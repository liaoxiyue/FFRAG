
public abstract class Vehicule {
	protected int idVehicule;
	

public Vehicule(int v) {
	this.idVehicule=v;
	
}


public int getIdVehicule() {
	return idVehicule;
}

public abstract float getCoef();

}