import java.util.ArrayList;
import java.util.Date;

public class Participant {

    private int noInscription;
    private Date dateInscription;
    private float tempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;
    private ArrayList listeParticipants;

    public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v) {

        this.noInscription = numInscr;
        this.dateInscription = dateEnreg;
        this.coureur = c;
        this.vehicule = v;

    }

    public boolean PrendreDepart() {

        if ()

    }
}