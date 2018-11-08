package FFRAG;
import java.util.*;

public class Participant {

    private int noInscription;
    private int tempsFinal;
    private Coureur coureur;
    private Voiture voiture;
    private int position;
    private int point;
    private Edition edition;
    
	public Participant (int nIns, Coureur c, Voiture v) {
		this.noInscription = nIns;
        this.coureur = c;
        this.voiture = v;
        this.coureur.affecterParticipation(this);
    }
	
	public int getTempsFinal() {
		return this.tempsFinal;
	}
	
    public void setTempsFinal(int temps) {
    	this.tempsFinal = temps;
    }
    
    public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
    public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Voiture getVoiture() {
		return voiture;
	}
    
    public int getNoInscription() {
		return noInscription;
	}
    
    public void setNoInscription(int noInscription) {
		this.noInscription = noInscription;
	}

    public Coureur getCoureur() {
		return coureur;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	/**
	 * Cette methode permet de v¨¦rifier si le participant a bien pris le d¨¦part ¨¤ une ¨¦tape afin de le disqualifier ensuite dans l'etape
	 * @param e : objet etape pour lequel on va verifier la participation
	 * @return
	 */
	public boolean prendreDepart(Etape e) {
    	boolean prendreDepart = true;
   		if(e.getTabParticipants().get(this)==null) {
    			prendreDepart=false;
    		};
    	return prendreDepart;
    } 
    

}