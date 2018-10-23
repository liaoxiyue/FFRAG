import java.util.Date;

public class Participant {

    private int NoInscription;
    private Date DateInscription;
    private float TempsFinal;
    private Coureur coureur;
    private Vehicule vehicule;

    public Participant(int numInscr, Date dateEnreg, Coureur c, Vehicule v) {

        this.NoInscription = numInscr;
        this.DateInscription = dateEnreg;
        this.coureur = c;
        this.vehicule = v;

    }

    public boolean PrendreDepart() {

        if ()

    }
}