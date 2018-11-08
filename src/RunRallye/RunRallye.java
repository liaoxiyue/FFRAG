package RunRallye;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import FFRAG.Coureur;
import FFRAG.Edition;
import FFRAG.Etape;
import FFRAG.FFRAG;
import FFRAG.Participant;
import FFRAG.Rallye;
import FFRAG.Voiture;
import vue.Bienvenue;
import vue.ClassementSaison;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class RunRallye {
	
	

    public static void main(String[] args) throws IOException,FileNotFoundException, ParseException {
    	
    	FFRAG ffrag = new FFRAG();
    	CSV.readCoureur("data/Coureurs.csv", ffrag);
    	
    	//recuperer les donnees des fichiers csv
        String csvPath = "data/";
    	String csvVal = "ValThorens.csv";
    	String csvPuiss = "Puissances.csv";
    	String csvSuper = "SuperBesse.csv";
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int numins= 0; //numero d'inscription
        int ned = 1; //numero de l'edition
    	
        

        
	        //Creation des rallyes ValThorens et SuperBesse
	     	ffrag.creationRallye("ValThorens", "ValThorens", "France");
	        ffrag.creationRallye("SuperBesse", "Besse", "France");
	        
	        Date datedebV = dateformat.parse("08/12/2017");	 
	        Date datefinV = dateformat.parse("01/01/2018");	        
	        Date datedebS = dateformat.parse("27/01/2018");	 
	        Date datefinS = dateformat.parse("01/02/2018");	 
	        

	        //Creation de l'edition de Val Thorens et de ses etapes
	        for(Rallye r: ffrag.getListRallye()) {
	        	if(r.getNomRallye() == "ValThorens") {
	        		r.organiser(ned, datedebV, datefinV, "2018 / 2019");
	        		for(Edition eV : r.getListeEdition()) {
	        			if(eV.getNoEdition()==ned) {
		        			eV.organiserEtape(1, 347);
		        			eV.organiserEtape(2, 305);
		        			eV.organiserEtape(3, 552);
		        			eV.organiserEtape(4, 180);
		        			eV.organiserEtape(5, 210);
		        			eV.organiserEtape(6, 380);
		        			eV.organiserEtape(7, 645);
		        			eV.organiserEtape(8, 325);
		        			eV.organiserEtape(9, 305);
		        			eV.organiserEtape(10, 179);
		        			
	        			}
	        		}
	        	}
	        }
		   
	        //recuperer les donnees du fichier Puissances.csv et instancier les objets Vehicule 
	        try {
	        	int j=0;//on ne traite pas l'entete des tableaux
		        br = new BufferedReader(new FileReader(csvPath+csvPuiss));
		        while ((line = br.readLine()) != null) {
		        	if(j!=0) {
		        		String[] tabPuiss = line.split(cvsSplitBy);
				        int pui = Integer.parseInt(tabPuiss[1]); 
			            ffrag.insertVoiture(tabPuiss[0], pui);
			        }
		            j++;

 		      }
		        
	        } finally {
				if (br != null) {
					try {
						br.close();
						} catch (IOException e) {
							e.printStackTrace();
					    }
				}
			}
	        

	        //creer les participants pour le rallye ValThorens
	        for(Rallye r: ffrag.getListRallye()) {
	        	if(r.getNomRallye() == "ValThorens") {
	        		for(Edition eV : r.getListeEdition()) {
	        			if(eV.getNoEdition()==ned) {
	        				 try {
	        			        	int k=0;//on ne traite pas l'entete des tableaux
	        				        br = new BufferedReader(new FileReader(csvPath+csvVal));
	        				        while ((line = br.readLine()) != null) {
	        				            	if(k!=0) {
	        					                String[] tab = line.split(cvsSplitBy);
	        					                String name = tab[0];
	        					                String lastName = "";
	        					                String firstName= "";
	        					                if(name.split(" ").length>1){
	        					                	lastName = name.substring(name.lastIndexOf(" ")+1);//dernier caractere avec l'espace
	        					                	firstName = name.substring(0, name.lastIndexOf(" "));
	        					                }else{
	        					                	  firstName = name;
	        					                	 }
	        					                for(Coureur c: ffrag.getListCoureur()) {
	    		        			        		if(c.getNomCoureur().equals(lastName) &&c.getPrenomCoureur().equals(firstName)) {
	    		        			        			int nIns = Integer.parseInt(tab[2]);
	    			        					        Date dateIns = dateformat.parse("03/03/2017");
	    			        					        for(Voiture v: ffrag.getListVoiture()){
	    			        					        	if(v.getModele().equals(tab[1])) {
	    			        					        		eV.organiserPart(new Participant(nIns,dateIns,c, v));
		 	    			        			                numins++;
	    			        					        	}
	    			        					        }
	    			        					    }
	    			        			      }
	    			        			  }
	        				              
	        				            k++;	        					                
	        				        }

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
	        	}
	        }
	        
	        
	        //enregistrer temps des coureurs pour l'edition Valthorens
	        for(Rallye r: ffrag.getListRallye()) {
	        	if(r.getNomRallye() == "ValThorens") {
	        		for(Edition eV : r.getListeEdition()) {
	        			if(eV.getNoEdition()==ned) {	
	        					for(Participant p : eV.getListPart()){
	        				        for (int j=3; j<13; j++) {
	        						try {
		        			        	int m=0;
		        				        br = new BufferedReader(new FileReader(csvPath+csvVal));
		        				        	  while ((line = br.readLine()) != null) {
			        				            	if(m!=0) {
			        					                String[] tab = line.split(cvsSplitBy);
	    		        			        			int nIns = Integer.parseInt(tab[2]);	    		        			
			        					                if(p.getNoInscription()==nIns){
				        				        						int h = Integer.parseInt(tab[j].substring(0,2)); //tableau fixe
						        					                	int mm = Integer.parseInt(tab[j].substring(3,5));
						        					                	int sec = Integer.parseInt(tab[j].substring(6,8));
						        					                	eV.getListEtape().get(j-3).enregistreTemp(p, h, mm, sec,00);
			        						                		}
				        				        	}
				        				            m++;	
			        						    }
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
	        		}
	        	}
	        }
	       }
	        
	       //Creer une edition pour SuperBesse
	        for(Rallye r: ffrag.getListRallye()) {
	        	if(r.getNomRallye() == "SuperBesse") {
	        		r.organiser(ned, datedebS, datefinS, "2018 / 2019");
	        		for(Edition eV : r.getListeEdition()) {
	        			if(eV.getNoEdition()==ned) {
		        			eV.organiserEtape(1, 360);
		        			eV.organiserEtape(2, 325);
		        			eV.organiserEtape(3, 658);
		        			eV.organiserEtape(4, 157);
		        			eV.organiserEtape(5, 285);
		        			eV.organiserEtape(6, 423);
		        			eV.organiserEtape(7, 592);
		        			eV.organiserEtape(8, 227);
		        			eV.organiserEtape(9, 219);
		        			eV.organiserEtape(10, 280);
		        			eV.organiserEtape(11, 267);
		        			eV.organiserEtape(12, 302);
	        			}
	        		}
	        	}
	        }
	        
	        
	        //Creer les participants du rallye SuperBesse
	        for(Rallye r: ffrag.getListRallye()) {
	        	if(r.getNomRallye() == "SuperBesse") {
	        		for(Edition eV : r.getListeEdition()) {
	        			if(eV.getNoEdition()==ned) {
	        				 try {
	        			        	int l=0;
	        				        br = new BufferedReader(new FileReader(csvPath+csvSuper));
	        				        while ((line = br.readLine()) != null) {
	        				            	if(l!=0) {
	        					                String[] tab = line.split(cvsSplitBy);
	        					                String name = tab[0];
	        					                String lastName = "";
	        					                String firstName= ""; 
	        					                if(name.split(" ").length>1){
	        					                	lastName = name.substring(name.lastIndexOf(" ")+1);//dernier caractere avec l'espace
	        					                	firstName = name.substring(0, name.lastIndexOf(" "));
	        					               }else{
	        					                	  firstName = name;
	        					               }
	        					                for(Coureur c: ffrag.getListCoureur()) {
	    		        			        		if(c.getNomCoureur().equals(lastName) &&c.getPrenomCoureur().equals(firstName)) {
	    		        			        			int nIns = Integer.parseInt(tab[2]);
	    			        					        Date dateIns = dateformat.parse("31/12/2017");
	    			        					        for(Voiture v: ffrag.getListVoiture()){	
	    			        					        	if(v.getModele().equals(tab[1])) {
	    			        					        		eV.organiserPart(new Participant(nIns,dateIns,c, v));
		 	    			        			                numins++;
	    			        					        	}
	    			        					        }
	    			        					    }
	    			        			      }
	    			        			  }
	        				            	l++;       
	        				        }

	        				 	}finally {
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
	        	}
	        }

	        //Enregistrer temps des coureurs pour l'edition SuperBesse
	        for(Rallye r: ffrag.getListRallye()) {
	        	if(r.getNomRallye() == "SuperBesse") {
	        		for(Edition eV : r.getListeEdition()) {
	        			if(eV.getNoEdition()==ned) {
	        					for(Participant p : eV.getListPart()){
	        				        for (int j=3; j<15; j++) {
	        				        	try {
			        			        	int m=0;//on ne traite pas l'entete des tableaux
			        				        br = new BufferedReader(new FileReader(csvPath+csvSuper));
			        				        	  while ((line = br.readLine()) != null) {
				        				            	if(m!=0) {
				        					                String[] tab = line.split(cvsSplitBy);
		    		        			        			int nIns = Integer.parseInt(tab[2]);
				        					                if(p.getNoInscription()==nIns){
					        				        						int h = Integer.parseInt(tab[j].substring(0,2)); 
							        					                	int mm = Integer.parseInt(tab[j].substring(3,5));
							        					                	int sec = Integer.parseInt(tab[j].substring(6,8));
							        					                	eV.getListEtape().get(j-3).enregistreTemp(p, h, mm, sec,00);
				        						              }
					        				        					
					        				        	}
	
					        				            m++;	
	
				        						     }
				    			        }finally {
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
	        		}
	        	}
	        }
	        }
	        
	        
	        for (Rallye r : ffrag.getListRallye()) {
	        	for (Edition e : r.getListeEdition()) {
	        		int finalEtape = e.getListEtape().size();
	        		e.calculerClassement(finalEtape);
	        	}
	        }
	        
	        int i = 0;
	        for (Voiture v : ffrag.getListVoiture()) {
	        	v.setPoids((int) (1000 + Math.pow(-1, i%2) * i * 10));
	        	v.setAdherence((int) (7 + Math.pow(-1, i%2) * i * 0.3));
	        	i++;
	        }
	        
	        Date datedeb = dateformat.parse("12/12/2018");
	        ffrag.getRallye("ValThorens").organiser(2,datedeb,datedeb,"2019 / 2020");
	        Edition ed = ffrag.getRallye("ValThorens").getListeEdition().get(1);
	        ed.organiserEtape(1,100);
	        ed.organiserEtape(2,150);
	        ed.organiserEtape(3,120);
	        
	        i = 0;
	        for(Etape etape : ed.getListEtape()) {
	        	etape.setDifficulte((int) (150 + Math.pow(-1, i%2) * i * 10));
	        	i++;
	        }
	        
	        
	        i = 1;
	        for(Coureur c : ffrag.getListCoureur()) {
		        Participant p = new Participant(i,datedeb,c,ffrag.getListVoiture().get(i%8));
		        ed.organiserPart(p);
		        i++;
	        }
	        /*
	        for(Etape e : ed.getListEtape()) {
	        	for (Participant p: ed.getListPart()) {
	        		System.out.println("Etape "+ e.getCodeEtape() +" le participant "+p.getCoureur().getPrenomCoureur() +" "+p.getCoureur().getNomCoureur() +" le temps prevu est " +ed.getTempsPrevu(p, e).getTemps());
	        	}
	        }
	        */
	        
	        
	      /*
	        EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Bienvenue frame = new Bienvenue(ffrag);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			});
		*/
	        CSV.enregistreFFRAG(ffrag);
	        CSV.readCoureur("data/Coureur.csv", ffrag);
	        System.out.println(ffrag.getListCoureur().size());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getNomCoureur());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getPrenomCoureur());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getDateNaissanceC());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getNationalite());
	        System.out.println(ffrag.getListCoureur().get(ffrag.getListCoureur().size()-1).getSanguin());
    }
}

