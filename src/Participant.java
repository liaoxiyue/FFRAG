import java.util.*;

>>>>>>> xiyue
public class Participant {

    private int noInscription;
    private Date dateInscription;
<<<<<<< HEAD
    private float tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    private Edition edition;

    public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v, Edition e) {
=======
    private int tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    
    public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v) {
>>>>>>> xiyue

        this.noInscription = numInscr;
        this.dateInscription = dateEnreg;
        this.coureur = c;
        this.vehicule = v;
<<<<<<< HEAD
        this.edition = e;
    }

    public boolean prendreDepart(Etape e) {
        boolean prendreDepart = true;
        if (e.getTabparticipants().get(this) == null) {
            prendreDepart = false;
        }
        ;
        return prendreDepart;
    }

    public float tempsFinal() {

        float temps = 0;

        return temps;
    }
=======
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
   
>>>>>>> xiyue
}