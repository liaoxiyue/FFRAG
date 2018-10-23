import java.util.ArrayList;
import java.util.Date;

public class Edition {
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;
	private ArrayList<Etape> listeEtape;
	
	public Edition(int noE, Date deb, Date fin) {
		this.noEdition = noE;
		this.dateDebER = deb;
		this.dateFinER = fin;
	}
	

}
