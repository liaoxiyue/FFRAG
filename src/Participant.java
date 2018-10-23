import java.util.*;
public class Participant {

    private int noInscription;
    private Date dateInscription;
    private float tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    
    public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v) {

        this.noInscription = numInscr;
        this.dateInscription = dateEnreg;
        this.coureur = c;
        this.vehicule = v;
    }

    public boolean prendreDepart(Etape e) {
    	boolean prendreDepart = true;
   		if(e.getTabparticipants().get(this)==null) {
    			prendreDepart=false;
    		};
    	return prendreDepart;
    }
   
}