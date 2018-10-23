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
    private Date tempsFinal;
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
    
    /**
     * 
     * @param e = etape pour laquelle on vérifie que le participant a bien pris le départ
     * @return true ou false en fonction de s'il a participé ou non
     */
    public boolean prendreDepart(Etape e) {
    	boolean prendreDepart=true;
    	if(e.getTabparticipants().get(this)==null) { //vérifier si le participant a un temps enregistré(non null) en fonction de sa clé
    		prendreDepart=false;
    	}
    	return prendreDepart;
    }
    
    public void setTempsFinal() throws ParseException {
    	SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
    	Calendar d1 = Calendar.getInstance();
    	d1.setTime(dateformat.parse("00:00:00"));
    	
    	
    	for(Etape e: this.edition.getListEtape()) {
    		
    		d1.add(Calendar.DATE,(int) e.getTabparticipants().get(this).getTempsEtape().getTime());
    	}

    	
    }
    
  

}