import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CSV {

	 public static void main(String[] args) throws ParseException {
		 BufferedReader br = null;
		 String line = "";
		 String cvsSplitBy = ";";
		 int ne = 0;// num edition
		 int n = 0;//id vehicule
		 int nume = 1; //num étape
		
		 //CSV COUREUR
		 String csvPathCoureur = "C:/Users/andri/Documents/GitHub/";
		 String csvCoureur = "ValThorens.csv";
		
		 try {
		      int i=0;//on ne traite pas l'entête des tableaux
			  br = new BufferedReader(new FileReader(csvPathCoureur+csvCoureur));

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
		                	    					}
		                else{
		                	  firstName = name;
		                	 }
		                
		                Coureur c = new Coureur(firstName, lastName, tab[1], tab[2]);

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
	 }

		
