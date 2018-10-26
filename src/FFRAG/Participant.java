package FFRAG;
import java.util.*;

public class Participant {

    private int noInscription;
	private Date dateInscription;
    private int tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    private int position;
   
	public Participant (int nIns, Date dateIns, Coureur c, Vehicule v) {
		this.noInscription = nIns;
		this.dateInscription = dateIns;
        this.coureur = c;
        this.vehicule = v;
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
	
    public Vehicule getVehicule() {
		return vehicule;
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

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
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