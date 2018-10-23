import java.util.*;

public class Etape {
	int codeEtape;
	float distanceEtape;
	Date dateDep;
	Edition edition;
	HashMap<Participant, Courir> listCourir;
	ArrayList<Participant> listPart;
	
	public Etape(int code, float distance, Date dep, Edition edition) {
		this.codeEtape = code;
		this.distanceEtape = distance;
		this.dateDep = dep;
		this.edition = edition;
		this.listCourir = new HashMap<Participant, Courir>();
	}
	
	public void organiser () {
		for(Participant part : edition.getListPart()) {
			listPart.add(part);
		}
	}
	
	public void enregistreTemp(Participant part, Courir courir) {
		listCourir.put(part, courir);
	}
}
