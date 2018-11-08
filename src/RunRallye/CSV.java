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
					System.out.println("---111--");
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

	public static void readCoureur(String path, String fichier, FFRAG ffrag) throws ParseException {
		String pathCSV = path + fichier;
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		CSV csv = new CSV();
		ArrayList<ArrayList<String>> coureur = new ArrayList<ArrayList<String>>();
		coureur = csv.CSV2Array(pathCSV);
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

	public static void readEdition(String path, String fichier, FFRAG ffrag) throws ParseException {
		String pathCSV = path + fichier;
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		CSV csv = new CSV();
		ArrayList<ArrayList<String>> edition = new ArrayList<ArrayList<String>>();
		edition = csv.CSV2Array(pathCSV);
		for(int i = 0; i < edition.size(); i++) {
			String nomRallye = String.valueOf(edition.get(i).get(0));
			int noEdition = Integer.parseInt(edition.get(i).get(1));
			String saison = edition.get(i).get(2);
			Date deb = dateformat.parse(edition.get(i).get(3));
			Date fin = dateformat.parse(edition.get(i).get(4));
			ffrag.getRallye(nomRallye).organiser(noEdition, deb, fin, saison);
		}
	}
	
	public static void readEtape(String path, String fichier, FFRAG ffrag) throws ParseException {
		String pathCSV = path + fichier;
		String[] split = fichier.split("_");
		String nomRallye = split[0];
		Rallye rallye = ffrag.getRallye(nomRallye);
		int noEdition = Integer.parseInt(split[1]);
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		CSV csv = new CSV();
		ArrayList<ArrayList<String>> etape = new ArrayList<ArrayList<String>>();
		etape = csv.CSV2Array(pathCSV);
		for(int i = 0; i < etape.size(); i++) {
			int code = Integer.parseInt(etape.get(i).get(0));
			Number distance = Float.parseFloat((etape.get(i).get(1)));
			int difficulte = Integer.parseInt(etape.get(i).get(2));
			rallye.getEdition(noEdition).organiserEtape(code, distance.intValue(), difficulte);
		}
	}
	
	public static void readVoiture(String path, String fichier, FFRAG ffrag){
		String pathCSV = path + fichier;
		CSV csv = new CSV();
		ArrayList<ArrayList<String>> voiture = new ArrayList<ArrayList<String>>();
		voiture = csv.CSV2Array(pathCSV);
		for(int i = 0; i < voiture.size(); i++) {
			String modele = voiture.get(i).get(0);
			int puissance = Integer.parseInt(voiture.get(i).get(1));
			int poids = Integer.parseInt(voiture.get(i).get(2));
			int adherence = Integer.parseInt(voiture.get(i).get(3));
			ffrag.insertVoiture(modele, puissance, poids, adherence);
		}
	}
	
	public static void readRallye(String path, String fichier, FFRAG ffrag){
		String pathCSV = path + fichier;
		CSV csv = new CSV();
		ArrayList<ArrayList<String>> rallye = new ArrayList<ArrayList<String>>();
		rallye = csv.CSV2Array(pathCSV);
		for(int i = 0; i < rallye.size(); i++){
			String nomRallye = rallye.get(i).get(0);
			String pays = rallye.get(i).get(2);
			String ville = rallye.get(i).get(1);
			ffrag.creationRallye(nomRallye, ville, pays);
		}
	}
	
	public static void readEtapeTemps(String path, String fichier, FFRAG ffrag) {
		String pathCSV = path + fichier;
		String[] split = fichier.split("_");
		String nomRallye = split[0];
		Rallye rallye = ffrag.getRallye(nomRallye);
		int noEdition = Integer.parseInt(split[1]);
		Edition edition = rallye.getEdition(noEdition);
		CSV csv = new CSV();
		ArrayList<ArrayList<String>> pilot = new ArrayList<ArrayList<String>>();
		pilot = csv.CSV2Array(pathCSV);
		for(int i = 0; i < pilot.size(); i++) {
			//saisir coureur
			String prenom = pilot.get(i).get(0);
			String nom = pilot.get(i).get(1);
			Coureur coureur = null;
			for(int j = 0; j < ffrag.getListCoureur().size(); j++) {
				if (ffrag.getListCoureur().get(j).getPrenomCoureur().equals(String.valueOf(prenom)) && ffrag.getListCoureur().get(j).getNomCoureur().equals(String.valueOf(nom))) {
					coureur = ffrag.getListCoureur().get(j);
					break;
				}
			}
			
			//saisir voiture
			String modele = pilot.get(i).get(2);
			Voiture voiture = null;
			for(int j = 0; j < ffrag.getListVoiture().size(); j++) {
				if (ffrag.getListVoiture().get(j).getModele().equals(String.valueOf(modele))) {
					voiture = ffrag.getListVoiture().get(j);
					break;
				}
			}
			
			//saisir noIscription
			int noInscription = Integer.parseInt(pilot.get(i).get(3));
			
			Participant part = new Participant(noInscription, coureur, voiture);
			edition.organiserPart(part);
		}
			
			
			//Enregistrer temps des coureurs
			for(int j = 0; j < edition.getListEtape().size(); j++) {
				for(int i = 0; i < pilot.size(); i++) {
					//recuperer le temps
					int heur = 0;
					int min = 0;
					int seconde = 0;
					int milleseconde = 0;
					String tempsString = pilot.get(i).get(j+4);
					if (tempsString != null) {
						String[] tempsSplit = tempsString.split(":");
						heur = Integer.parseInt(tempsSplit[0]);
						min = Integer.parseInt(tempsSplit[1]);
						seconde = Integer.parseInt(tempsSplit[2]);
					}
					else {
						heur = 0;
						min = 0;
						seconde = 0;
					}
					edition.getListEtape().get(j).enregistreTemp(edition.getListPart().get(i), heur, min, seconde, milleseconde);;
				}
			}
			for(int k = 0; k < ffrag.getListRallye().get(0).getEdition(1).getListEtape().size(); k++) {
				for(int j = 0; j < ffrag.getListRallye().get(0).getEdition(1).getListPart().size(); j++) {
				System.out.println(ffrag.getListRallye().get(0).getEdition(1).getListEtape().get(k).getTabParticipants().get(ffrag.getListRallye().get(0).getEdition(1).getListPart().get(j)));
			}
		}
	}
}


