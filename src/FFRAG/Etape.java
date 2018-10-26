package FFRAG;
import java.util.*;
public class Etape {

	private HashMap<Participant, Integer> tabParticipants;
	int codeEtape;
	int distanceEtape;
	ArrayList<HashMap.Entry<Participant, Integer>> classementEtape; //arrayList de hashmap de participants (avec leurs temps)
	
	
	public Etape(int code, int distance) {
		this.codeEtape = code;
		this.distanceEtape = distance;
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
	
	/**
	 * 
	 * @return la hashmap des participants
	 */
	public HashMap<Participant, Integer> getTabParticipants() {
		return tabParticipants;
	}
	
	/**
	 * 
	 * @return l'arrayList des classements aux etapes qui contient une hashmap des participants
	 */
	public ArrayList<HashMap.Entry<Participant, Integer>> getClassementEtape() {
		return classementEtape;
	}

	/**
	 * Methode permettant d'organiser l'edition : affecter les participants aux etapes.
	 * @param edition : objet edition pour lequel on va organiser l'edition
	 */
	public void organiser (Edition edition) {
		for(Participant part : edition.getListPart()) {
			tabParticipants.put(part, null);
			}
	}
	
	/**
	 * Methode permettant de calculer le classement d'une etape. Pour tout le classement a une ¨¦tape comprenant l'ensemble des participants,
	 * on calcul
	 */
	public void calculerClassement() {
		for(HashMap.Entry<Participant, Integer> entry:tabParticipants.entrySet()) { //chaque case d'une hashmap est compos¨¦e d'un temps et d'un participant
			int temps = entry.getValue(); //entry = cle participant
			temps = (int) (temps*entry.getKey().getVehicule().getCoef()); //correction du temps en fonction du coeff du vehicule
			entry.setValue(temps); //affecter le temps corrige a la hashmap
		}
		
		Set<HashMap.Entry<Participant, Integer>> entrySet = tabParticipants.entrySet(); 
		classementEtape = new ArrayList<HashMap.Entry<Participant, Integer>>(entrySet);	
		//System.out.println(ligneClassement.size());
		Collections.sort(classementEtape, new Comparator<HashMap.Entry<Participant, Integer>>() { //classer par ordre les participants
			@Override
			public int compare(HashMap.Entry<Participant, Integer> c1,
					HashMap.Entry<Participant, Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
				
	}

	/**
	 * Methode permettant d'enregistrer le temps d'une etape pour un participant
	 * @param part :  participant
	 * @param hh : heure
	 * @param mm : minutes
	 * @param ss : secondes
	 * @param ms : millisecondes
	 */
	public void enregistreTemp(Participant part, int hh, int mm, int ss, int ms) {
		Courir courir = new Courir(hh, mm, ss, ms); //enregistrer le temps dans courir
		int temps = courir.getMilleSeconde(); //recuperer le temps 
		tabParticipants.put(part, temps); //affecter le temps au participant dans le tableau
	}
	
	/**
	 * Methode permettant de valider le classement d'un participant a une etape et de le disqualifier s'il ne l'a pas pris
	 * @param p : participant
	 * @return : true ou false en fonction de s'il a pris le depart ou non. On supprime sa participant dans le cas ou il n'a pas pris le depart
	 */
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