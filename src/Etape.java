import java.util.*;
public class Etape {
	private int codeEtape;
	private float distanceEtape;
	private HashMap<Participant,Integer> tabParticipants;
	private Date dateDep;

	
	
	
	public Etape(int code, float distance, Date dep) {
		this.codeEtape = code;
		this.distanceEtape = distance;
		this.dateDep = dep;
		this.tabParticipants = new HashMap<Participant, Integer>();
	}
	
	public int getCodeEtape() {
		return codeEtape;
	}

	public float getDistanceEtape() {
		return distanceEtape;
	}
	
	public HashMap<Participant, Integer> getTabParticipants() {
		return tabParticipants;
	}
	
	
	//affecter les participants ¨¤ l'¨¦pate
	public void organiser (Edition edition) {
		for(Participant part : edition.getListPart()) {
			tabParticipants.put(part, null);
			}
	}
	

	public void enregistreTemp(Participant part, int hh, int mm, int ss, int ms) {
		Courir courir = new Courir(hh, mm, ss, ms);
		int temps = courir.getMilleSeconde();
		tabParticipants.put(part, temps);
	}
	
	public boolean validerClassement(Participant p) {
		if(!p.prendreDepart(this)) {
			tabParticipants.remove(p);
			return false;
		}
		else {
			return true;
		}
	}
}
