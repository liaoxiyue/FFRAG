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
        
    	for(String s : listeCSV) {

	        try {
		            br = new BufferedReader(new FileReader(csvPath+s));
		            while ((line = br.readLine()) != null) {
		
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
		                int n = 0;
		                Voiture v = new Voiture(n, 0); 
		                n++;
		                
		                Date now = new Date() ;
		                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		                now = dateformat.parse("24/10/2018");
		                
		                
		                // Inscription 
		                
		                int nIns = Integer.parseInt(tab[2]);
		                
		               // Participant
		                Participant p = new Participant(nIns, now,c, v);
		                
		                //Rallye
		                
		                
		                
		                //Edition
		
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