import java.util.*;

public class Edition {
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;
	private ArrayList<Etape> listEtape;

	public Edition(int noE, Date deb, Date fin) {
		this.noEdition = noE;
		this.dateDebER = deb;
		this.dateFinER = fin;
		listEtape = new ArrayList<Etape>();
	}
	
	public void organiser(Etape etape) {
		listEtape.add(etape);
	}
}
