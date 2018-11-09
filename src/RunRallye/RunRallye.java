package RunRallye;

import java.awt.EventQueue;
import java.io.*;
import FFRAG.*;
import vue.Bienvenue;

import java.text.*;
public class RunRallye {
	
    public static void main(String[] args) throws IOException,FileNotFoundException, ParseException {
    	
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
	    				e.calculerClassement(et.getCodeEtape());
	    			}
	    		}
	    	}

	        CSV.enregistreFFRAG(ffrag,ffrag.getCsvPath());
	        
    }
}

