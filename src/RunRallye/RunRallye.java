package RunRallye;
import java.util.*;
import FFRAG.Camion;
import FFRAG.Coureur;
import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;
import FFRAG.Voiture;
import vue.Bienvenue;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RunRallye {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date today = dateformat.parse("2018-10-04");
		FFRAG ffrag = new FFRAG();
		
		//creation rallye
		ffrag.creationRallye("r1","v1","p1");
		ffrag.creationRallye("r2","v2","p2");
		ffrag.creationRallye("r3","v3","p3");
		ffrag.creationRallye("r4","v4","p4");
		
		//creation coureur
		ffrag.insertCoureur("lala","lala",today);
		ffrag.insertCoureur("riri","riri",today);
		ffrag.insertCoureur("toto","toto",today);
		ffrag.insertCoureur("fufu","fufu",today);
		ffrag.insertCoureur("didi","didi",today);
		
		//creation vehicule
		Camion c1 = new Camion("cme", 2250);
		Voiture v1 = new Voiture("vme", 25);
		
		//creation edition
		for(int i = 0; i < ffrag.getListRallye().size(); i++) {
			for(int j = 1; j < 5; j++) {
				ffrag.getListRallye().get(i).organiser(j, today, today);
			}
		}
		
		
		//creation etape
		ffrag.getListRallye().get(0).getListeEdition().get(0).organiserEtape(1, 123);
		ffrag.getListRallye().get(0).getListeEdition().get(0).organiserEtape(2, 123);
		ffrag.getListRallye().get(0).getListeEdition().get(0).organiserEtape(3, 123);
		ffrag.getListRallye().get(0).getListeEdition().get(0).organiserEtape(4, 123);
		ffrag.getListRallye().get(0).getListeEdition().get(0).organiserEtape(5, 123);

		
		
		//creation participant
		//ffrag.getListRallye().get(0).getListeEdition().get(0).organiserPart(part);
		
		//test temps
		Courir cou1 = new Courir(1,3,28,6);
		Courir cou2 = new Courir(0,5,12,5);
		Courir cou3 = new Courir(2,52,18,5);
		Courir cou4 = new Courir(1,6,52,558);
		Courir cou5 = new Courir(0,59,10,125);
		
		//test calculer			
		Coureur co1 = new Coureur("sf","sef",today);
		Coureur co2 = new Coureur("sef","sef",today);
		Participant p1 = new Participant(1,today,co1,c1);
		Participant p2 = new Participant(2,today,co2,v1);
		Etape et1 = new Etape(1,(int) (235));
		
		et1.enregistreTemp(p2, 1,35,59,1);
		et1.enregistreTemp(p1, 0,20,35,220);
		et1.calculerClassement();
		
		Edition ed1 = new Edition(21,today,today);
		Edition ed2 = new Edition(22,today,today);
		Edition ed3 = new Edition(23,today,today);
		ffrag.getListRallye().get(0).organiser(21,today,today);
		ffrag.getListRallye().get(0).organiser(22,today,today);
		ffrag.getListRallye().get(1).organiser(22,today,today);
		ffrag.getListRallye().get(1).organiser(23,today,today);
		
		ffrag.getListRallye().get(0).getListeEdition().get(0).organiserEtape(1,(int) (235));
		ffrag.getListRallye().get(0).getListeEdition().get(0).organiserEtape(2,(int) (235));
		ed1.organiserEtape(1,235);
		ed1.organiserEtape(2,541);
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenue frame = new Bienvenue(ffrag);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		ArrayList<ArrayList<String>> rallye = new ArrayList<ArrayList<String>>();
		for (Rallye r:ffrag.getListRallye()) {
			ArrayList<String> ligneRallye = new ArrayList<String>();
			ligneRallye.add(r.getNomRallye());
			ligneRallye.add(r.getVille());
			ligneRallye.add(r.getPays());
			rallye.add(ligneRallye);
		}
		//TestCSV test = new TestCSV();
		//test.Array2CSV(rallye, "test.csv");
	}
}
