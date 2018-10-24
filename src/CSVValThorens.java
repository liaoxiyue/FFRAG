import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CSVValThorens {
	
	

    public static void main(String[] args) throws ParseException {
    	
    
        String csvPath = "C:/Users/andri/Documents/GitHub/";
    	String csv = "ValThorens.csv";


        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int ne = 0;// num edition
        int n = 0;//id vehicule
        int nume = 1; //num étape
    
        

	        try {
	        	int i=0;//on ne traite pas l'entête des tableaux
		            br = new BufferedReader(new FileReader(csvPath+csv));
		            while ((line = br.readLine()) != null) 
		            	if(i!=0) {
		            		 // use comma as separator
			                String[] tab = line.split(cvsSplitBy);
			              
			                //Coureur 
			                String name = tab[0];
			                String lastName = "";
			                String firstName= "";
			                
			                if(name.split(" ").length>1){
			                	lastName = name.substring(name.lastIndexOf(" "));//dernier caractère avec l'espace
			                	firstName = name.substring(0, name.lastIndexOf(" "));
			                	    					}
			                else{
			                	  firstName = name;
			                	    }
			                
			                Coureur c = new Coureur(firstName, lastName, tab[1], tab[2]);
			                
			                //Vehicule
			                
			                
			                float pui = Float.parseFloat(tab[5]);
			                Voiture v = new Voiture(n, pui); 
			                n++;
			                
			                Date now = new Date();
			                SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
			                now = dateformat.parse("24-10-2018");
			                
			                
			                // Inscription 
			                
			                int nIns = Integer.parseInt(tab[2]);
			                
			               // Participant
			                Participant p = new Participant(nIns, now,c, v); 
			                
			                //Rallye
			                String n1 = csv.substring(0, csv.lastIndexOf("."));
			                Rallye r = new Rallye (n1,"Val Thorens");
			                
			                
			                
			              //Edition
   
			                Date dateDeb = new Date() ;
			                dateDeb = dateformat.parse("08-12-2017");
			                
			                Date dateFin = new Date() ;
			                dateFin = dateformat.parse("28-01-2018");
			                Edition e = new Edition(ne, dateDeb, dateFin);
			               	ne++;

			                //Etape 
			                for (int j= 3; j<tab.length; j++) {
			                	int h = Integer.parseInt(tab[j].substring(0,2));
			                	int m = Integer.parseInt( tab[j].substring(3,5));
			                	int sec = Integer.parseInt(tab[j].substring(6,8));
			                	
			                	
				                e.organiserEtape(nume, 0);
				                e.getListEtape().get(e.getListEtape().size()-1).enregistreTemp(p, h, m, sec, 00 );

			                	nume++;
			                }
			                
		            		
		            	}
		               
		               	i++;
	       
						        
					            
					    } catch (FileNotFoundException e) {
					        e.printStackTrace();
					    } catch (IOException e) {
					        e.printStackTrace();
					    } finally {
					        if (br != null) {
					            try {
					                br.close();
					            } catch (IOException e) {
					                e.printStackTrace();
					            }
					        }
					    }
					}
					}