import java.util.*;

public class Edition {
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;
	private ArrayList<Etape> listEtape;
	private ArrayList<Participant> listPart;
	private HashMap<Participant, Courir> classementGeneral;
	
	public Edition(int noE, Date deb, Date fin) {
		this.noEdition = noE;
		this.dateDebER = deb;
		this.dateFinER = fin;
		this.listEtape = new ArrayList<Etape>();
		this.listPart = new ArrayList<Participant>();
	}

	public void organiserEtape(Etape etape) {
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
	

}