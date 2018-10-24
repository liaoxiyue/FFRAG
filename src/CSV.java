import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*

public class CSV {	
	
	public static void main(String[] args) {
		
		String filename = "C:/Users/andri/Documents/GitHub/SuperBesse.csv";
		File file = new File(filename);
	try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(";");
				System.out.println(values[0]);
				
			}
			
			inputStream.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
		
		
	
}
*/

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
                String[] country = line.split(cvsSplitBy);

                ArrayList<String> coureur = new ArrayList<String>();
                coureur.add(country[0]);
                System.out.println(country.toString());


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
