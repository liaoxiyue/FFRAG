package RunRallye;

import java.io.*;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import FFRAG.Coureur;
import FFRAG.FFRAG;
import FFRAG.Rallye;

public class TestCSV {
	public static void Array2CSV(ArrayList<ArrayList<String>> data, String path)
    {
        try {
              BufferedWriter out =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));         
              for (int i = 0; i < data.size(); i++)
              {
                  ArrayList<String> onerow=data.get(i);
                  for (int j = 0; j < onerow.size(); j++)
                  {
                      out.write(DelQuota(onerow.get(j)));
                      out.write(",");
                  }
                  out.newLine();
              }
              out.flush();
              out.close();

          } catch (Exception e) {
              e.printStackTrace();
          }

    }
    public static String DelQuota(String str)
    {
        String result = str;
        String[] strQuota = { "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "`", ";", "'", ",", ".", "/", ":", "/,", "<", ">", "?" };
        for (int i = 0; i < strQuota.length; i++)
        {
            if (result.indexOf(strQuota[i]) > -1)
                result = result.replace(strQuota[i], "");
        }
        return result;
    }
    
	public static ArrayList<ArrayList<String>> CSV2Array(String path)
    {
        try {
        	int i = 0;
        	BufferedReader in =new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
	        ArrayList<ArrayList<String>> alldata=new ArrayList<ArrayList<String>>();
	        String line;
	        String[] onerow;
	        while ((line=in.readLine())!=null) {
	        	if(i !=0) {
		        	onerow = line.split(",");  //默认分割符为逗号，可以不使用逗号
	                List<String> onerowlist = Arrays.asList(onerow);
	                ArrayList<String> onerowaArrayList = new ArrayList<String>(onerowlist);
	                alldata.add(onerowaArrayList);
	                i++;
	        	}
            }
            in.close();
            return alldata;
          } catch (Exception e) {
              return null;
          }

    }
	
	public static void enregistreRallye(FFRAG ffrag) {
		ArrayList<ArrayList<String>> rallye = new ArrayList<ArrayList<String>>();
		for (Rallye r:ffrag.getListRallye()) {
			ArrayList<String> ligneRallye = new ArrayList<String>();
			ligneRallye.add(r.getNomRallye());
			ligneRallye.add(r.getVille());
			ligneRallye.add(r.getPays());
			rallye.add(ligneRallye);
		}
		TestCSV test = new TestCSV();
		test.Array2CSV(rallye, "test.csv");
	}
	
	public static void readCoureur(String path) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<ArrayList<String>> coureur = new ArrayList<ArrayList<String>>();
		coureur = CSV2Array(path);
		for(int i = 0; i < coureur.size(); i++) {
			String name = coureur.get(i).get(0);
	        String lastName = "";
	        String firstName= "";
	        if(name.split(" ").length>1){
	        	lastName = name.substring(name.lastIndexOf(" ")+1);//dernier caractere avec l'espace
	            firstName = name.substring(0, name.lastIndexOf(" "));
	        }
	        else{
	        	firstName = name;
	        }
	        Date dateN = dateformat.parse(coureur.get(i).get(1));
	        String nationalite = coureur.get(i).get(2);
	        String sanguin = coureur.get(i).get(3);
			Coureur c = new Coureur(lastName, firstName, dateN, nationalite, sanguin);
		}
		
	}
}
