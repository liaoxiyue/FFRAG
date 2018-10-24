import java.util.*;

public class Edition {
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;	
	private ArrayList<Participant> listPart;
	private ArrayList<Etape> listEtape;
	private HashMap<Participant, Integer> classementGeneral;
	
	public Edition(int noE, Date deb, Date fin) {
		this.noEdition = noE;
		this.dateDebER = deb;
		this.dateFinER = fin;
		this.listEtape = new ArrayList<Etape>();
		this.listPart = new ArrayList<Participant>();
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

	
	public void validerClassement(Etape etape) {
		HashMap<Participant, Integer> classementGeneral = new HashMap<Participant, Integer>();
		for(Participant p : listPart) {
			if (etape.validerClassement(p)) {
				classementGeneral.put(p, null);
			}
		}
		
	}
	
	public void calculerClassement(Etape etape) {
		this.validerClassement(etape);
		for(Participant p : classementGeneral.keySet()) {
			int temps = 0;
			for (int i = 0; i <= listEtape.indexOf(etape); i++ ) {
				temps += listEtape.get(i).getTabParticipants().get(p);
			}
			classementGeneral.put(p, temps);
		}
	}
	
	public void setTempFinal() {
		int noEtape = listEtape.size() - 1;
		this.calculerClassement(listEtape.get(noEtape));
		for(Participant p : listPart) {
			int temps = classementGeneral.get(p);
			p.setTempsFinal(temps);
		}
	}

}