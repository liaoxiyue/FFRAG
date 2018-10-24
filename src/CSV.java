import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
               
                String[] coureur = tab[0].split(" ");
                for (String s: coureur) {
                System.out.println(s);
                
                }



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