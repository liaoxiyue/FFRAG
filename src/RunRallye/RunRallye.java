package RunRallye;

import java.awt.EventQueue;
import java.io.*;
import FFRAG.*;
import vue.Bienvenue;


import java.text.*;
public class RunRallye {
	
    public static void main(String[] args) throws IOException,FileNotFoundException, ParseException {
    	//Cr¨¦ation ffrag, on d¨¦finit le path des dossiers csv et r¨¦cup¨¨re les donn¨¦es des dossier cvs
    	FFRAG ffrag = new FFRAG("src/data/");
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

        /*cette m¨¦thode est pour ¨¦viter valider tous les classement ¨¦tape manuellement pendant tester les codes, 
         * normallement le classement est valid¨¦ par ¨¦tape sur l'interface d¨¨s que l'¨¦tape finit.
         */
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
    }
}

