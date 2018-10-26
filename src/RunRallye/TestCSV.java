package RunRallye;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

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
              BufferedReader in =new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
              ArrayList<ArrayList<String>> alldata=new ArrayList<ArrayList<String>>();
              String line;
              String[] onerow;
              while ((line=in.readLine())!=null) {
                   onerow = line.split(",");  //Ĭ�Ϸָ��Ϊ���ţ����Բ�ʹ�ö���
                   List<String> onerowlist = Arrays.asList(onerow);
                   ArrayList<String> onerowaArrayList = new ArrayList<String>(onerowlist);
                   alldata.add(onerowaArrayList);
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
}