import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RunRallye {

	public static void main(String[] args) throws ParseException {
	Camion c1 = new Camion("cme", 2250);
	System.out.println(c1.getCoef());

		Voiture v1 = new Voiture("vme", 50);
		System.out.println(v1.getCoef());
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateformat2 = new SimpleDateFormat("hh:mm:ss");

	Date d1;
	Date d2;
	String d3,d4;
	
	d1 = dateformat.parse("10-01-2018");
	d2 = dateformat.parse("15-01-2018");
	d3 = "05:05:01";
	d4 = "07:05:00";

	Edition e1 = new Edition(1,d1,d2 );
	
	Etape et1, et2;
	et1 = new Etape(1, 400);
	et2 = new Etape(2, 500);
	
	e1.organiserEtape(et1);
	Participant p;
	Coureur c11;
	Date dateN = dateformat.parse("26-08-1992");

	c11 = new Coureur("Castillo", "Manuel", dateN);
	p = new Participant(1,d1,c11, v1, e1);
	et1.ajouterTemps(p,d3 );
	et2.ajouterTemps(p,d4);

	System.out.println(p.setTempsFinal());

	

	

	}

}
