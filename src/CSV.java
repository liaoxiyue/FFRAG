import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CSV {
	
	

    public static void main(String[] args) throws ParseException {
    	
    
    	ArrayList<String> listeCSV = new ArrayList<String>();
        String csvPath = "C:/Users/andri/Documents/GitHub/";
    	String csv = "SuperBesse.csv";
    	String csv1 = "ValThorens.csv";

    	listeCSV.add(csv);
    	listeCSV.add(csv1);

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int ne = 0;
        int n = 0;
    	for(String s : listeCSV) {

	        try {
	        	int i=0;
		            br = new BufferedReader(new FileReader(csvPath+s));
		            while ((line = br.readLine()) != null) {
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
			                	System.out.println(lastName);
			                	    					}
			                else{
			                	  firstName = name;
			                	    }
			                
			                Coureur c = new Coureur(firstName, lastName, null);
			                
			                //Vehicule
			               
			                Voiture v = new Voiture(n, 0); 
			                n++;
			                
			                Date now = new Date() ;
			                SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
			                now = dateformat.parse("24-10-2018");
			                
			                
			                // Inscription 
			                
			                int nIns = Integer.parseInt(tab[2]);
			                
			               // Participant
			                Participant p = new Participant(nIns, now,c, v);
			                
			                //Rallye
			                String n1 = s.substring(0, s.lastIndexOf("."));
			                Rallye r = new Rallye (n1,n1);
			                
			                //courir
			                for (int e= 3; e<tab.length; e++) {
			                	String h = tab[e].substring(0,2);
			                	System.out.println(h);
			                	
			                	String m = tab[e].substring(3,5);
			                	System.out.println(m);
			                	
			                	String sec = tab[e].substring(6,8);
			                	System.out.println(sec);
			                }
			                
			                //Etape
			                System.out.println(tab.length);

			                int nbe = tab.length - 3;
			                for( int j=1; j<=nbe; j++) {
			                	Etape et = new Etape(j,0);
			                	//et.enregistreTemp
			                }
			                
			                //Edition
			               
			                Date dateDeb = new Date() ;
			                dateDeb = dateformat.parse("24-04-2019");
			                
			                Date dateFin = new Date() ;
			                dateFin = dateformat.parse("24-04-2019");
			                Edition e = new Edition(ne, dateDeb, dateFin);
			                //e.organiserEtape();
			               	ne++;
			               	
		            		
		            	}
		               
		               	i++;
		            }
		
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
}}