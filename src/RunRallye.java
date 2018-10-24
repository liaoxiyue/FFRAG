import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
public class RunRallye {

	public static void main(String[] args) throws ParseException {
		Camion c1 = new Camion("cme", 2250);
		System.out.println(c1.getCoef());

		Voiture v1 = new Voiture("vme", 25);
		System.out.println(v1.getCoef());
		
		
		//test temps
		Courir cou1 = new Courir(1,3,28,6);
		Courir cou2 = new Courir(0,5,12,5);
		System.out.println(cou1.getMilleSeconde());
		System.out.println(cou1.getTemps());

		//test calculer
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date today = dateformat.parse("2018-10-04");	
		Coureur co1 = new Coureur("sf","sef",today);
		Coureur co2 = new Coureur("sef","sef",today);
		Participant p1 = new Participant(123,today,co1,c1);
		Participant p2 = new Participant(124,today,co2,v1);
		Etape et1 = new Etape(1,(float) (235.1),today);
		
		et1.enregistreTemp(p2, 123456789);
		et1.enregistreTemp(p1, 12345);
		et1.calculerClassement();
		
		
	}



}
