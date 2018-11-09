package RunRallye;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import FFRAG.Coureur;
import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;
import FFRAG.Voiture;
import vue.Bienvenue;
import vue.ClassementSaison;
import vue.Parier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class RunRallye {
	
    public static void main(String[] args) throws IOException,FileNotFoundException, ParseException {

    	
    	FFRAG ffrag = new FFRAG("src/data/");

    	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
    	
    	String path = "src/data/";
	      //CSV.readToutsClassements(ffrag);
    	CSV.readRallye(path, "Rallye.csv", ffrag);
    	CSV.readEdition(path, "Edition.csv", ffrag);
    	CSV.readVoiture(path, "Voiture.csv", ffrag);
    	CSV.readCoureur(path,"Coureurs.csv", ffrag);
    	CSV.readEtape(path, "ValThorens_1_Etape.csv", ffrag);
    	CSV.readEtape(path, "ValThorens_2_Etape.csv", ffrag);
    	CSV.readEtape(path, "SuperBesse_1_Etape.csv", ffrag);
    	CSV.readEtape(path, "Bonascre_1_Etape.csv", ffrag);
    	CSV.readEtapeTemps(path, "ValThorens_1_TempsEtape.csv", ffrag);
    	CSV.readEtapeTemps(path, "SuperBesse_1_TempsEtape.csv", ffrag);
    	CSV.readEtapeTemps(path, "Bonascre_1_TempsEtape.csv", ffrag);
    	  
	        
	        /*
	        //tester
	        for (Rallye r : ffrag.getListRallye()) {
	        	for (Edition e : r.getListeEdition()) {
	        		int finalEtape = e.getListEtape().size();
	        		e.calculerClassement(finalEtape);
	        	}
	        }
	        
	        int i = 0;
	        for (Voiture v : ffrag.getListVoiture()) {
	        	v.setPoids((int) (1000 + Math.pow(-1, i%2) * i * 10));
	        	v.setAdherence((int) (7 + Math.pow(-1, i%2) * i * 0.3));
	        	i++;
	        }
	        
	        Date datedeb = dateformat.parse("12/12/2018");
	        ffrag.getRallye("ValThorens").organiser(2,datedeb,datedeb,"2019 / 2020");
	        Edition ed = ffrag.getRallye("ValThorens").getListeEdition().get(1);
	        ed.organiserEtape(1,100, 0);
	        ed.organiserEtape(2,1500, 0);
	        ed.organiserEtape(3,120, 0);
	        
	        i = 0;
	        for(Etape etape : ed.getListEtape()) {
	        	etape.setDifficulte((int) (150 + Math.pow(-1, i%2) * i * 10));
	        	i++;
	        }
	        
	        
	        i = 1;
	        for(Coureur c : ffrag.getListCoureur()) {
		        Participant p = new Participant(i,c,ffrag.getListVoiture().get(i%8));
		        ed.organiserPart(p);
		        i++;
	        }

	        
	        HashMap<Participant, Integer> tempsPrevuEtape =  ed.tempsPrevuEtape(ed.getListEtape().get(0), 60);
	        
	        for(Etape e : ed.getListEtape()) {
	        	for (Participant p: ed.getListPart()) {
	        		System.out.println("Etape "+ e.getCodeEtape() +" le participant "+p.getCoureur().getPrenomCoureur() +" "+p.getCoureur().getNomCoureur() +" le temps prevu est " +ed.getTempsPrevu(p, e).getTemps());
	        	}
	        }

	        ArrayList<HashMap.Entry<Participant, Integer>> classementProbable= ed.classementProbable(60);
	        for(int j = 0; j < classementProbable.size(); j++) {
	        	Courir temps = new Courir(0,0,0,0);
	        	temps.setMilleSeconde(classementProbable.get(j).getValue());
	        	System.out.println("Le " + (j+1) + " est " + classementProbable.get(j).getKey().getCoureur().getPrenomCoureur() + " " + classementProbable.get(j).getKey().getCoureur().getNomCoureur() + ". Le temps pr¨¦vu d¨¦finitif est de " + temps.getTemps());
	        }
	        */
	        

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

	    	for(Rallye r: ffrag.getListRallye()) {
	    		for(Edition e: r.getListeEdition()) {
	    			for(Etape et: e.getListEtape()) {
	    				int nbPart = e.getListPart().size();
	    				for(int i = 0; i < nbPart; i++) {
	    					if (!et.validerClassement(e.getListPart().get(i))){
	    						i--;
	    						nbPart--;
	    					}
	    				}
	    				et.calculerClassement();
	    				e.calculerClassement(et.getCodeEtape());
	    			}
	    		}
	    	}
	        CSV.enregistreFFRAG(ffrag,ffrag.getCsvPath());
	        	        
	        Date sysdate = new Date();
	        System.out.println(sysdate);
	        
	        Date datePari = dateformat.parse("07/11/2018");
	        
	        if(datePari.before(sysdate)) {
	        	System.out.println("OK");
	        }
	        else {
	        	System.out.println("Non");
	        }
    
	        ArrayList<Edition> editionAPari = ffrag.editionAPari();
	        System.out.println(editionAPari.size());
	        for(int i = 0; i < editionAPari.size(); i++) {
	        	System.out.println(editionAPari.get(i).getRallye().getNomRallye());
	        }
	        
	        
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Parier frame = new Parier(ffrag);
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});

    }
}

