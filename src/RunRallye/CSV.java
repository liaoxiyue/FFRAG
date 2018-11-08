package RunRallye;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import FFRAG.Coureur;
import FFRAG.Courir;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;
import FFRAG.Voiture;
import javafx.scene.input.DataFormat;

public class CSV {
	
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
        String[] strQuota = {  };
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
	        	}
	        	i++;
            }
            in.close();
            return alldata;
          } catch (Exception e) {
              return null;
          }

    }

	
	public static void enregistreRallye(FFRAG ffrag, String path) {
		ArrayList<ArrayList<String>> ra = new ArrayList<ArrayList<String>>();
		ArrayList<String> ligneTitre = new ArrayList<String>();
		ligneTitre.add("NomRallye");
		ligneTitre.add("Ville");
		ligneTitre.add("Pays");
		ra.add(ligneTitre);
		for (Rallye r:ffrag.getListRallye()) {
			ArrayList<String> ligneRallye = new ArrayList<String>();
			ligneRallye.add(r.getNomRallye());
			ligneRallye.add(r.getVille());
			ligneRallye.add(r.getPays());
			ra.add(ligneRallye);
		}
		CSV rallye = new CSV();
		rallye.Array2CSV(ra, path+"Rallye.csv");
	}
	
	public static void enregistreEdition(FFRAG ffrag, String path) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<ArrayList<String>> ed = new ArrayList<ArrayList<String>>();
		ArrayList<String> ligneTitre = new ArrayList<String>();
		ligneTitre.add("NomRallye");
		ligneTitre.add("NoEdition");
		ligneTitre.add("Saison");
		ligneTitre.add("DateDebut");
		ligneTitre.add("DateFin");
		ed.add(ligneTitre);
		for (Rallye r:ffrag.getListRallye()) {
			for(Edition e: r.getListeEdition()) {
				ArrayList<String> ligneEdition = new ArrayList<String>();
				ligneEdition.add(r.getNomRallye());
				ligneEdition.add(String.valueOf(e.getNoEdition()));
				ligneEdition.add(String.valueOf(e.getSaison()));
				ligneEdition.add(String.valueOf(dateformat.format(e.getDateDebER())));
				ligneEdition.add(String.valueOf(dateformat.format(e.getDateFinER())));
				ed.add(ligneEdition);
			}
		}
		CSV edition = new CSV();
		edition.Array2CSV(ed, path+"Edition.csv");
	}
	
	public static void enregistreCoureur(FFRAG ffrag, String path) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<ArrayList<String>> cr = new ArrayList<ArrayList<String>>();
		ArrayList<String> ligneTitre = new ArrayList<String>();
		ligneTitre.add("Prenom");
		ligneTitre.add("Nom");
		ligneTitre.add("DateNaissance");
		ligneTitre.add("Nationalite");
		ligneTitre.add("Sanguin");
		cr.add(ligneTitre);
		for (Coureur c:ffrag.getListCoureur()) {
			ArrayList<String> ligneCoureur = new ArrayList<String>();
			ligneCoureur.add(c.getPrenomCoureur());
			ligneCoureur.add(c.getNomCoureur());
			ligneCoureur.add(dateformat.format(c.getDateNaissanceC()));
			ligneCoureur.add(c.getNationalite());
			ligneCoureur.add(c.getSanguin());
			cr.add(ligneCoureur);
		}
		CSV coureur = new CSV();
		coureur.Array2CSV(cr, path+"Coureur.csv");
	}
	
	public static void enregistreVoiture(FFRAG ffrag, String path) {
		ArrayList<ArrayList<String>> vi = new ArrayList<ArrayList<String>>();
		ArrayList<String> ligneTitre = new ArrayList<String>();
		ligneTitre.add("Model");
		ligneTitre.add("Pussaince");
		ligneTitre.add("Poids");
		ligneTitre.add("Adherence");
		vi.add(ligneTitre);
		for (Voiture v: ffrag.getListVoiture()) {
			ArrayList<String> ligneVoiture = new ArrayList<String>();
			ligneVoiture.add(v.getModele());
			ligneVoiture.add(String.valueOf(v.getPuissanceV()));
			ligneVoiture.add(String.valueOf(v.getPoids()));
			ligneVoiture.add(String.valueOf(v.getAdherence()));
			vi.add(ligneVoiture);
		}
		CSV voiture = new CSV();
		voiture.Array2CSV(vi, path+"Voiture.csv");
	}
	
	public static void enregistreClassementDefinitif(FFRAG ffrag, String path) {
		for (Rallye r: ffrag.getListRallye()) {
			for(Edition e: r.getListeEdition()) {
				ArrayList<ArrayList<String>> cld = new ArrayList<ArrayList<String>>();
				ArrayList<String> ligneTitre = new ArrayList<String>();
				ligneTitre.add("Position");
				ligneTitre.add("Prenom");
				ligneTitre.add("Nom");
				ligneTitre.add("Voiture");
				ligneTitre.add("TempFinal");
				for(Etape et : e.getListEtape()) {
					ligneTitre.add("Etape "+String.valueOf(e.getListEtape().indexOf(et)+1));
				}
				cld.add(ligneTitre);
				for(HashMap.Entry<Participant, Integer> cd: e.getClassementDefinitif()) {
					ArrayList<String> ligneCld = new ArrayList<String>();
					ligneCld.add(String.valueOf(e.getClassementDefinitif().indexOf(cd)+1));
					ligneCld.add(cd.getKey().getCoureur().getPrenomCoureur());
					ligneCld.add(cd.getKey().getCoureur().getNomCoureur());
					ligneCld.add(cd.getKey().getVoiture().getModele());
					Courir temps = new Courir(0,0,0,0);
					temps.setMilleSeconde(cd.getValue());
					ligneCld.add(temps.getTemps());
					for(Etape et: e.getListEtape()) {
						temps.setMilleSeconde(et.getTabParticipants().get(cd.getKey()));
						ligneCld.add(temps.getTemps());
					}
					cld.add(ligneCld);
				}
				CSV classementD = new CSV();
				classementD.Array2CSV(cld, path+"classement/ClassementDefinitif"+r.getNomRallye()+e.getNoEdition()+".csv");
			}
		}
	}
		
	public static void enregistreInfoEtape(FFRAG ffrag, String path) {
		for (Rallye r: ffrag.getListRallye()) {
			for(Edition e: r.getListeEdition()) {
				ArrayList<ArrayList<String>> infoE = new ArrayList<ArrayList<String>>();
				ArrayList<String> ligneTitre = new ArrayList<String>();
				ligneTitre.add("Etape");
				ligneTitre.add("Distance");
				ligneTitre.add("Difficulite");
				infoE.add(ligneTitre);
				for (Etape et: e.getListEtape()) {
					ArrayList<String> ligneEtape = new ArrayList<String>();
					ligneEtape.add(String.valueOf(e.getListEtape().indexOf(et)+1));
					ligneEtape.add(String.valueOf(et.getDistanceEtape()));
					ligneEtape.add(String.valueOf(et.getDifficulte()));
					infoE.add(ligneEtape);					}
					CSV infoEtape = new CSV();
					infoEtape.Array2CSV(infoE, path+r.getNomRallye()+"_"+e.getNoEdition()+"_Etape.csv");
				}
			}
		}
	
	public static void enregistreFFRAG(FFRAG ffrag, String path) {
		enregistreRallye(ffrag,path);
		enregistreEdition(ffrag,path);
		enregistreCoureur(ffrag,path);
        enregistreVoiture(ffrag,path);
        enregistreClassementDefinitif(ffrag,path);
        enregistreInfoEtape(ffrag,path);
	}
	
	public static void enregistreNouveauRallye(FFRAG ffrag, String path, Rallye r) throws FileNotFoundException {
		PrintWriter pw;
		pw = new PrintWriter(new FileOutputStream(path+"Rallye.csv",true));
		pw.println(r.getNomRallye()+","+r.getVille()+","+r.getPays());
		pw.flush();
		pw.close();
	}
	public static void enregistreNouveauEdition(FFRAG ffrag, String path, Rallye r, Edition e) throws FileNotFoundException {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		PrintWriter pw;
		pw = new PrintWriter(new FileOutputStream(path+"Edition.csv",true));
		pw.println(r.getNomRallye()+","+e.getNoEdition()+","+e.getSaison()+","+dateformat.format(e.getDateDebER())+","+dateformat.format(e.getDateFinER()));
		pw.flush();
		pw.close();
		
		ArrayList<ArrayList<String>> infoE = new ArrayList<ArrayList<String>>();
		ArrayList<String> ligneTitre = new ArrayList<String>();
		ligneTitre.add("Etape");
		ligneTitre.add("Distance");
		ligneTitre.add("Difficulite");
		infoE.add(ligneTitre);
		for (Etape et: e.getListEtape()) {
			ArrayList<String> ligneEtape = new ArrayList<String>();
			ligneEtape.add(String.valueOf(e.getListEtape().indexOf(et)+1));
			ligneEtape.add(String.valueOf(et.getDistanceEtape()));
			ligneEtape.add(String.valueOf(et.getDifficulte()));
			infoE.add(ligneEtape);	}			
		CSV csv = new CSV();
		csv.Array2CSV(infoE, path+r.getNomRallye()+"_"+e.getNoEdition()+"_Etape.csv");
	}
	
	public static void readCoureur(FFRAG ffrag) throws ParseException {
		ffrag.setListCoureur(new ArrayList<Coureur>());
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		CSV csv = new CSV();
		ArrayList<ArrayList<String>> coureur = new ArrayList<ArrayList<String>>();
		coureur = csv.CSV2Array(ffrag.getCsvPath()+"Coureurs.csv");
		System.out.println(coureur.size());
		for(int i = 0; i < coureur.size(); i++) {
	        String prenom = coureur.get(i).get(0);
	        String nom = coureur.get(i).get(1);
	        Date dateN = dateformat.parse(coureur.get(i).get(2));
	        String nationalite = coureur.get(i).get(3);
	        String sanguin = coureur.get(i).get(4);
			ffrag.insertCoureur(nom, prenom, dateN, nationalite, sanguin);
		}
	}
	
	public static void readToutsClassements(FFRAG ffrag) {
		  File file=new File(ffrag.getCsvPath()+"/classement");
		  File[] tempList = file.listFiles();
		  //System.out.println("nbFiche："+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {

			   System.out.println("Fiche："+tempList[i]);
		   }
		  }
	}
	
}
