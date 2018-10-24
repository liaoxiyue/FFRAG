import java.util.*;

public class Edition {
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;
	private ArrayList<Etape> listEtape;
	private ArrayList<Participant> listPart;
	private HashMap<Participant, Integer> listTempsGeneral;
	private ArrayList<HashMap.Entry<Participant, Integer>> classementGeneral;
	
	public Edition(int noE, Date deb, Date fin) {
		this.noEdition = noE;
		this.dateDebER = deb;
		this.dateFinER = fin;
		this.listEtape = new ArrayList<Etape>();
		this.listPart = new ArrayList<Participant>();
		this.listTempsGeneral = new HashMap<Participant, Integer>();
	}

	public void organiserEtape(int code, float distance, Date dep) {
		Etape etape = new Etape(code, distance, dep);
		listEtape.add(etape);
	}
	
	public void organiserPart(Participant part) {
		listPart.add(part);
	}
	
	public ArrayList<Etape> getListEtape() {
		return listEtape;
	}
	
	public ArrayList<Participant> getListPart() {
		return listPart;
	}
	
	public void validerClassement(int etape) {
		//listTempsGeneral = new HashMap<Participant, Integer>();
		for(Participant p : listPart) {
			if (listEtape.get(etape-1).validerClassement(p)) {
				listTempsGeneral.put(p, null);
			}
		}
		
	}
	
	public void calculerClassement(int etape) {
		this.validerClassement(etape);
		for(Participant p : listTempsGeneral.keySet()) {
			int temps = 0;
			for (int i = 0; i < etape; i++ ) {
				temps += listEtape.get(i).getTabParticipants().get(p);
			}
			listTempsGeneral.put(p, temps);
		}
		
		//mettre dans l'ordre
		Set<HashMap.Entry<Participant, Integer>> entryset = listTempsGeneral.entrySet();
		classementGeneral = new ArrayList<HashMap.Entry<Participant, Integer>>(entryset);
		Collections.sort(classementGeneral, new Comparator<HashMap.Entry<Participant, Integer>>(){
			@Override
			public int compare(HashMap.Entry<Participant, Integer> c1, HashMap.Entry<Participant, Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		
	}
	
	public void setTempFinal() {
		int indexEtape = listEtape.size();
		this.calculerClassement(indexEtape);
		for(Participant p : listPart) {
			int temps = listTempsGeneral.get(p);
			p.setTempsFinal(temps);
		}
	}
	
	public Participant getChampion() {
		Participant champion;
		champion = classementGeneral.get(0).getKey();
		return champion;
	}

}