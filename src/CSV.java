import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.time.LocalDateTime;
public class CSV {
	
	

    public static void main(String[] args) {
    	
    

        String csvFile = "C:/Users/andri/Documents/GitHub/SuperBesse.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        

        try {

            br = new BufferedReader(new FileReader(csvFile));
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
                
                LocalDateTime now = LocalDateTime.now() ;
                              // Participant
                Participant p = new Participant(tab[2],  ,c, v);

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

}}