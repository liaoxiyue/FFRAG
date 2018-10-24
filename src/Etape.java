import java.util.*;
import java.util.Map.Entry;
public class Etape {
	private HashMap<Participant, Integer> tabparticipants;
	int codeEtape;
	float distanceEtape;
	Date dateDep;
	ArrayList<HashMap.Entry<Participant, Integer>> classementEtape;
	
	public Etape(int code, float distance, Date dep) {
		this.codeEtape = code;
		this.distanceEtape = distance;
		this.dateDep = dep;
		this.tabparticipants = new HashMap<Participant, Integer>();
		this.classementEtape = new ArrayList<HashMap.Entry<Participant, Integer>>();
	}
	
	public int getCodeEtape() {
		return codeEtape;
	}

	public float getDistanceEtape() {
		return distanceEtape;
	}
	
	public HashMap<Participant, Integer> getTabparticipants() {
		return tabparticipants;
	}
	
	public void organiser (Edition edition) {
		for(Participant part : edition.getListPart()) {
			tabparticipants.put(part, null);
			}
	}
	
	public void enregistreTemp(Participant part, Integer courir) {
		tabparticipants.put(part, courir);
	}
	
	public void calculerClassement() {
		for(HashMap.Entry<Participant, Integer> entry:tabparticipants.entrySet()) {
			System.out.print(entry.getKey().getNoInscription()+" "+entry.getValue()+" ");
		}
		for(HashMap.Entry<Participant, Integer> entry:tabparticipants.entrySet()) {
			int temps = entry.getValue();
			temps = (int) (temps*entry.getKey().getVehicule().getCoef());
			entry.setValue(temps);
		}
		
		Set<HashMap.Entry<Participant, Integer>> entrySet = tabparticipants.entrySet(); 
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

	public void validerClassement(Participant part, Date temps) {
		
	}
}
