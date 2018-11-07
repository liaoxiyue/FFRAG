package FFRAG;

/**
 * Classe abstraite vehicule
 */
public abstract class Vehicule {
	protected String modele;

	/**
	 * Constructeur d'un vehicule
	 * 
	 * @param modele : nom du modele du vehicule
	 */
	public Vehicule(String modele) {
		this.modele = modele;
	}

	public String getModele() {
		return modele;
	}

	/**
	 * Un vehicule possede un coefficient correctif qui permet de faire le
	 * classement Dans les classes Voiture et Camion cette methode est completee
	 * 
	 * @return
	 */
	public abstract float getCoef();
	
	public abstract int getPoids();
	
	public abstract int getAdherence();
	
	public abstract int getPuissanceV();

}