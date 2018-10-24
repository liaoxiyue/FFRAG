import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		et1.enregistreTemp(p2, 1,35,59,1);
		et1.enregistreTemp(p1, 0,20,35,220);
		et1.calculerClassement();
		
		Edition ed1 = new Edition(21,today,today);
		ed1.organiserEtape(1,(float) (235.1),today);
		ed1.organiserEtape(2,(float) (235.5),today);
		ed1.organiserPart(p2);ed1.organiserPart(p1);
		ed1.getListEtape().get(0).enregistreTemp(p2, 1,35,59,1);
		ed1.getListEtape().get(0).enregistreTemp(p1, 0,20,35,220);
		ed1.getListEtape().get(1).enregistreTemp(p2, 1,35,59,1);
		ed1.getListEtape().get(1).enregistreTemp(p1, 0,20,35,220);
		
		ed1.calculerClassement(1);
		ed1.calculerClassement(2);
		int nom = ed1.getChampion().getNoInscription();
		System.out.println("Le champion est le" + nom);
		
		ed1.setTempFinal();
		System.out.println("Le temps final du participant " + p1.getNoInscription() + " est de " + p1.getTempsFinal());

	}
}
