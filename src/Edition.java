import java.util.*;

public class Edition {
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;
	private ArrayList<Etape> listEtape = new ArrayList<Etape>();
	
	
	public Edition(int noE, Date deb, Date fin) {
		this.noEdition = noE;
		this.dateDebER = deb;
		this.dateFinER = fin;
	}
	
	public ArrayList<Etape> getListEtape() {
		return listEtape;
	}

}
