import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Participant {

    private int noInscription;
    private Date dateInscription;
    private String tempsFinal;
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

    public boolean prendreDepart(Etape e) {
        boolean prendreDepart = true;
        if (e.getTabparticipants().get(this) == null) {
            prendreDepart = false;
        }
        ;
        return prendreDepart;
    }
    
    public String setTempsFinal() {
    int htotal = 0;
    int mtotal = 0;
    int stotal = 0;
	for (Etape e: this.edition.getListEtape()) {
    		
    		int h = Integer.parseInt(e.getTabparticipants().get(this).getTempsEtape().substring(1,2));
			int m = Integer.parseInt(e.getTabparticipants().get(this).getTempsEtape().substring(4,5));
			int s =  Integer.parseInt(e.getTabparticipants().get(this).getTempsEtape().substring(7,8));
			
			htotal = htotal + h;
			mtotal = mtotal + m;
			stotal = stotal + s;
			
			
    	
    	
    	}
	
	String tf = htotal +":" + mtotal+ ":"+stotal;

		return tf;

    	
    }
    
  

}