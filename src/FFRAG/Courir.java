package FFRAG;
/**
 * Classe courir permettant de manipuler le temps d'un coureur dans differents formats
 * @author 21203630
 *
 */

public class Courir {	
	
	int milleSeconde;

	
	
	/**
	 * Le constructeur Courir permet de convertir un temps d'un coureur en milliseconde. 
	 * @param hh : heure
	 * @param mm : minute
	 * @param ss : seconde
	 * @param ms : milliseconde
	 */
	public Courir(int hh, int mm, int ss, int ms) {
		this.milleSeconde = ((hh * 60 + mm) * 60 + ss) * 1000 + ms;
	}
	

	public void setMilleSeconde(int milleSeconde) {
		this.milleSeconde = milleSeconde;
	}

	
	public int getMilleSeconde() {
		return milleSeconde;
	}
	
	/**
	 * La methode getTemps permet de convertir un temps d'un coureur en milliseconde en format heure:minute:seconde:milliseconde.
	 * @return temps: affichage en texte du temps d'un coureur dans le format heure:minute:seconde:milliseconde.
	 */
	public String getTemps() {
		String temps = "";
		int ms = milleSeconde % 1000;
		int ss = (milleSeconde / 1000) % 60;
		int mm = milleSeconde / 1000 / 60 % 60;
		int hh = milleSeconde / 1000 / 60 / 60;
		temps += hh + ":" + mm + ":" + ss + ":" + ms;
		return temps;
	}

}