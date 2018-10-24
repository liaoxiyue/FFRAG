package FFRAG;
import java.util.*;
public class Etape {

	private HashMap<Participant, Integer> tabParticipants;
	int codeEtape;
	float distanceEtape;
	Date dateDep;
	ArrayList<HashMap.Entry<Participant, Integer>> classementEtape;
	
	
	public Etape(int code, float distance, Date dep) {
		this.codeEtape = code;
		this.distanceEtape = distance;
		this.dateDep = dep;
		this.tabParticipants = new HashMap<Participant, Integer>();
		this.classementEtape = new ArrayList<HashMap.Entry<Participant, Integer>>();
	}
	
	//getter
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
		
	public void calculerClassement() {
		for(HashMap.Entry<Participant, Integer> entry:tabParticipants.entrySet()) {
			System.out.print(entry.getKey().getNoInscription()+" "+entry.getValue()+" ");
		}
		for(HashMap.Entry<Participant, Integer> entry:tabParticipants.entrySet()) {
			int temps = entry.getValue();
			temps = (int) (temps*entry.getKey().getVehicule().getCoef());
			entry.setValue(temps);
		}
		
		Set<HashMap.Entry<Participant, Integer>> entrySet = tabParticipants.entrySet(); 
		classementEtape = new ArrayList<HashMap.Entry<Participant, Integer>>(entrySet);
		//System.out.println(ligneClassement.size());
		Collections.sort(classementEtape, new Comparator<HashMap.Entry<Participant, Integer>>() {
			@Override
			public int compare(HashMap.Entry<Participant, Integer> c1,
					HashMap.Entry<Participant, Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		
		for(int i=0;i<classementEtape.size();i++) {
			System.out.print(classementEtape.get(i).getKey().getNoInscription()+" "+classementEtape.get(i).getValue()+" ");
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
