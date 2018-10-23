import java.util.*;

public class Etape {
	private HashMap<Participant, Courir> tabparticipants;
	int codeEtape;
	float distanceEtape;
	Date dateDep;
	
	public Etape(int code, float distance, Date dep) {
		this.codeEtape = code;
		this.distanceEtape = distance;
		this.dateDep = dep;
		this.tabparticipants = new HashMap<Participant, Courir>();
	}

	

	public void ajouterTemps(Participant p, float temps) {
		
	}

    public boolean PrendreDepart(Participant numeroPart) {

        if (tabparticipants.containsKey(numeroPart)) {
        	if(tabparticipants.containsKey)
        	
        }
    }
	

	public int getCodeEtape() {
		return codeEtape;
	}

	public float getDistanceEtape() {
		return distanceEtape;
	}
	
	public HashMap<Participant, Courir> getTabparticipants() {
		return tabparticipants;
	}
	
	public void organiser (Edition edition) {
		for(Participant part : edition.getListPart()) {
			tabparticipants.put(part, null);
			}
	}
	
	public void enregistreTemp(Participant part, Courir courir) {
		tabparticipants.put(part, courir);
	}
}
