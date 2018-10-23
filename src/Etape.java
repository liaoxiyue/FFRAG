import java.util.*;
public class Etape {
	int codeEtape;
	float distanceEtape;
	private HashMap<Participant, Courir> tabParticipants;
	Date dateDep;
	
	public Etape(int code, float distance) {
		this.codeEtape = code;
		this.distanceEtape = distance;
		this.tabParticipants = new HashMap<Participant, Courir>();
	}
	

	public void ajouterTemps(Participant p, Date temps) {
		this.tabParticipants.put(p,new Courir(temps));
	}
	
	public int getCodeEtape() {
		return codeEtape;
	}

	public float getDistanceEtape() {
		return distanceEtape;
	}
	
	public HashMap<Participant, Courir> getTabparticipants() {
		return tabParticipants;
	}
	
	public void validerClassement() {
		//disqualifier 
		
		for(Participant p: this.tabParticipants.keySet()) {
			
			if(p.prendreDepart(this)){
				continue;
			}else {
				this.tabParticipants.remove(p);
			}
			
		}
	}
	public void organiser (Edition edition) {
		for(Participant part : edition.getListPart()) {
			tabParticipants.put(part, null);
			}
	}
	
	public void enregistreTemp(Participant part, Courir courir) {
		tabParticipants.put(part, courir);
	}
}
