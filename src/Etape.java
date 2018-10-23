<<<<<<< HEAD
import java.util.Date;
import java.util.HashMap;

public class Etape {
	private HashMap<Participant, Courir> tabparticipants;
	int codeEtape;
	float distanceEtape;
	
	public Etape(int code, float distance) {
		this.codeEtape = code;
		this.distanceEtape = distance;
		this.tabparticipants = new HashMap<Participant, Courir>();
	}

	

	public void ajouterTemps(Participant p, int temps) {
		this.tabparticipants.put(p,new Courir(temps));
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
	
}
=======
>>>>>>> 4c9514f7897aa84e16c5fd5ccc8eaba3d6b2e18b
