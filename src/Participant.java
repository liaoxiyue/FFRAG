import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Participant {

    private int noInscription;
    private Date dateInscription;
    private float tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    private Edition edition;

    public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v, Edition edition) {

        this.noInscription = numInscr;
        this.dateInscription = dateEnreg;
        this.coureur = c;
        this.vehicule = v;
        this.edition = edition;
    }

    public boolean prendreDepart() {
    	boolean prendreDepart = true;
    	for(Etape e : edition.getListEtape()) {
    		if(e.getTabparticipants().get(this)==null) {
    			prendreDepart=false;
    		};
    	}
    	return prendreDepart;
    	
    }
    
    

}