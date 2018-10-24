public class RunRallye {

	public static void main(String[] args) {
		Camion c1 = new Camion("cme", 2250);
		System.out.println(c1.getCoef());

		Voiture v1 = new Voiture("vme", 50);
		System.out.println(v1.getCoef());
		
		
		//test temps
		Courir cou1 = new Courir(1,3,28,6);
		System.out.println(cou1.getMilleSeconde());
		System.out.println(cou1.getTemps());
	}
}
