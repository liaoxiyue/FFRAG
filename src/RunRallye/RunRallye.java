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

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class RunRallye {
	
    public static void main(String[] args) throws IOException,FileNotFoundException, ParseException {

    	FFRAG ffrag = new FFRAG("data/");

    	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
    	
    	String path = "data/";
	      //CSV.readToutsClassements(ffrag);

    	CSV.readRallye(path, "Rallye.csv", ffrag);
    	CSV.readEdition(path, "Edition.csv", ffrag);
    	CSV.readVoiture(path, "Voiture.csv", ffrag);
    	CSV.readCoureur(path,"Coureurs.csv", ffrag);
    	CSV.readEtape(path, "ValThorens_1_Etape.csv", ffrag);
    	CSV.readEtape(path, "ValThorens_2_Etape.csv", ffrag);
    	CSV.readEtape(path, "SuperBesse_1_Etape.csv", ffrag);
    	CSV.readEtapeTemps(path, "ValThorens_1_TempsEtape.csv", ffrag);

    	CSV.readEtapeTemps(path, "SuperBesse_1_TempsEtape.csv", ffrag);
    	/*
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
		*/
    	
	        CSV.enregistreFFRAG(ffrag,ffrag.getCsvPath());
	        
	        //tester readCoureur
	        System.out.println(ffrag.getListCoureur().size());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getNomCoureur());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getPrenomCoureur());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getDateNaissanceC());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getNationalite());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getSanguin());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getSanguin());
	        
	        //tester readRallye
	        System.out.println(ffrag.getListRallye().size());
	        System.out.println(ffrag.getListRallye().get(ffrag.getListRallye().size()-1).getNomRallye());
	        System.out.println(ffrag.getListRallye().get(ffrag.getListRallye().size()-1).getPays());
	        System.out.println(ffrag.getListRallye().get(ffrag.getListRallye().size()-1).getVille());
	        
	        //tester readEdition
	        System.out.println(ffrag.getListRallye().get(0).getListeEdition().size());
	        System.out.println(ffrag.getListRallye().get(1).getListeEdition().size());
	        
	        //tester readTemps
	        
    }
}

