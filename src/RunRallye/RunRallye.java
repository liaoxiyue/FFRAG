package RunRallye;

import java.awt.EventQueue;
import java.io.*;
import FFRAG.*;
import vue.Bienvenue;
import vue.Parier;


import java.text.*;
public class RunRallye {
	
    public static void main(String[] args) throws IOException,FileNotFoundException, ParseException {
    	
    	  
	        
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
	        


    	FFRAG ffrag = new FFRAG("data/");
    	CSV.readFFRAG(ffrag,ffrag.getCsvPath());
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
        for(Coureur c: ffrag.getListCoureur()) {
        	int point = 0;
        	for(Participant p: c.getListParticipation()) {
        		point += p.getPoint();
        	}
        	System.out.println(c.getNomCoureur() + point);
        }
    }
}

