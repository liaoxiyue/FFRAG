import java.util.Date;
import java.util.HashMap;

public class Etape {
	private HashMap<Participant, Courir> tabparticipants;
	int codeEtape;
	float distanceEtape;
	
	public Etape(int code, float distance) {
		this.codeEtape = code;
		this.distanceEtape = distance;
	}
	
}