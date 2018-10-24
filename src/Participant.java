import java.util.*;

public class Participant {

    private int noInscription;
    private Date dateInscription;
    private int tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    private Edition edition;

    public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v, Edition e) {

        this.noInscription = numInscr;
        this.dateInscription = dateEnreg;
        this.coureur = c;
        this.vehicule = v;
        this.edition = e;
    }
    
    public void setTempsFinal(int temps) {
    	this.tempsFinal = temps;
    }
    
    public boolean prendreDepart(Etape e) {
    	boolean prendreDepart = true;
   		if(e.getTabParticipants().get(this)==null) {
    			prendreDepart=false;
    		};
    	return prendreDepart;
    }
}