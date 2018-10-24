package FFRAG;
import java.util.*;

public class Participant {

    private int noInscription;
	private Date dateInscription;
    private int tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    private int position;
   
	public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v) {
        this.noInscription = numInscr;
        this.dateInscription = dateEnreg;
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

	public boolean prendreDepart(Etape e) {
    	boolean prendreDepart = true;
   		if(e.getTabParticipants().get(this)==null) {
    			prendreDepart=false;
    		};
    	return prendreDepart;
    } 
    
    public Vehicule getVehicule() {
		return vehicule;
	}
    
    public int getNoInscription() {
		return noInscription;
	}
    
    public Coureur getCoureur() {
		return coureur;
	}
}