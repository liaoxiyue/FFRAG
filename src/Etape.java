import java.util.Date;
import java.util.HashMap;

public class Etape {
	int codeEtape;
	float distanceEtape;
	HashMap<Participant, Courir> listeTemps; 
	
	public Etape(int code, float distance) {
		this.codeEtape = code;
		this.distanceEtape = distance;
	}
	public calculerClassement() {
		
	}
	
	public void validerClassement(Participant p) {
		if(!p.prendreDepart(this)) {
			this.listeTemps.remove(p);
		}
	}
}
