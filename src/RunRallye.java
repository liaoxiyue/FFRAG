import java.text.SimpleDateFormat;

public class RunRallye {

	public static void main(String[] args) {
	Camion c1 = new Camion("cme", 2250);
	System.out.println(c1.getCoef());

		Voiture v1 = new Voiture("vme", 50);
		System.out.println(v1.getCoef());
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	Date d1, d2;
	d1 = dateformat.parse("10/01/2018");
	d2 = dateformat.parse("15/01/2018");

	Edition e1 = new Edition(1,d1,d2 );
	
	Etape et1, et2;
	et1 = new Etape(1, 400);
	et2 = new Etape(2, 500);
	
	e1.organiserEtape(et1);
	
	}

}
