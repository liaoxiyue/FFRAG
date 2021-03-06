package FFRAG;
import java.util.*;
/**
 * Classe Edition 
 * @author 21203630
 *
 */

public class Edition {
	private int noEdition;
	private Date dateDebER;
	private Date dateFinER;
	private String saison;
	private ArrayList<Etape> listEtape;
	private ArrayList<Participant> listPart;
	private HashMap<Participant, Integer> listTempsGeneral;
	private ArrayList<HashMap.Entry<Participant, Integer>> classementGeneral = new ArrayList<HashMap.Entry<Participant, Integer>>();
	private ArrayList<HashMap.Entry<Participant, Integer>> classementDefinitif = new ArrayList<HashMap.Entry<Participant, Integer>>();
	private Rallye rallye;
	
	
	
	/**
	 * Le constructeur de l'edition permet de creer une edition. 
	 * @param noE: numero de l'edition
	 * @param deb : date de debut de l'edition
	 * @param fin : date de fin de l'edition
	 * @param saison : saison (annees) de l'edition
	 */
	public Edition(int noE, Date deb, Date fin, String saison) {
		this.noEdition=noE;
		this.dateDebER=deb;
		this.dateFinER=fin;
		this.saison = saison;
		this.listEtape = new ArrayList<Etape>();
		this.listPart = new ArrayList<Participant>();
		this.listTempsGeneral = new HashMap<Participant, Integer>();
	}

	public String getSaison() {
		return saison;
	}

	public ArrayList<Etape> getListEtape() {
		return listEtape;
	}
	
	public ArrayList<Participant> getListPart() {
		return listPart;
	}
	
	public ArrayList<HashMap.Entry<Participant, Integer>> getClassementGeneral() {
		return classementGeneral;
	}

	public int getNoEdition() {
		return noEdition;
	}

	public Date getDateDebER() {
		return dateDebER;
	}

	public Date getDateFinER() {
		return dateFinER;
	}

	public Rallye getRallye() {
		return rallye;
	}

	public void setRallye(Rallye rallye) {
		this.rallye = rallye;
	}

	
	public ArrayList<HashMap.Entry<Participant, Integer>> getClassementDefinitif() {
		return classementDefinitif;
	}

	public void setClassementDefinitif(ArrayList<HashMap.Entry<Participant, Integer>> classementDefinitif) {
		this.classementDefinitif = classementDefinitif;
	}

	/**
	 * La methode organiserEtape permet de creer une etape pour l'edition
	 * @param code : code de l'etape
	 * @param distance : distance en km de l'etape
	 */
	public void organiserEtape(int code, int distance, int difficulte) {
		Etape etape = new Etape(code, distance, difficulte);
		listEtape.add(etape);
	}
	
	
	/**
	 * La methode organiserPart permet d'ajouter un participant aux etapes de l'edition 
	 * @param part : un objet Participant 
	 */
	public void organiserPart(Participant part) {
		listPart.add(part);
		for(Etape e : listEtape) {
			e.organiser(this);
		}
		part.setEdition(this);
	}
	
	

	
	
	/**
	 * La methode validerClassement permet de valider le classement d'une etape (cela sera fait par l'acteur jury). 
	 * Si le classement de l'etape est valide, on ajoute le participant a la listTempsGeneral (classement general).
	 * @param etape : code de l'etape
	 */
	public void validerClassement(int etape) {
		for(Participant p : listPart) {
			if (listEtape.get(etape-1).validerClassement(p)) {
				listTempsGeneral.put(p, null);
			}else {
				listTempsGeneral.remove(p);
			}
		}
		
	}
	
	
	/**
	 * La methode calculerClassement nous permet de calculer le classement general de l'edition jusqu'a l'etape en cours.
	 *  Si le classement de l'etape est valide alors le temps total du participant dans le classement general est mis a jour.   
	 * @param etape : code de l'etape.
	 */
	public void calculerClassement(int etape) {
		this.validerClassement(etape);
		for(Participant p : listTempsGeneral.keySet()) {
			int temps = 0;
			for (int i = 0; i < etape; i++ ) {
				temps += listEtape.get(i).getTabParticipants().get(p);
			}
			listTempsGeneral.put(p, temps);
		}
		//Classer les participants dans l'ordre croissant de leur temps 
		Set<HashMap.Entry<Participant, Integer>> entryset = listTempsGeneral.entrySet();
		classementGeneral = new ArrayList<HashMap.Entry<Participant, Integer>>(entryset);
		Collections.sort(classementGeneral, new Comparator<HashMap.Entry<Participant, Integer>>(){
			@Override
			public int compare(HashMap.Entry<Participant, Integer> c1, HashMap.Entry<Participant, Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}
		});
		if(etape == this.listEtape.size()) {
			this.setClassementDefinitif(classementGeneral);
			this.setTempFinal();
		}
	}
	
	
	
	/**
	 * La methode setTempFinal permet d'elaborer le classement definitif (quand la derni��re etape de l'edition est terminee).
	 */
	public void setTempFinal() {
		for(int i = 0; i < classementDefinitif.size(); i++) {
			int temps = classementDefinitif.get(i).getValue();
			int position = i + 1;
			classementDefinitif.get(i).getKey().setTempsFinal(temps);
			classementDefinitif.get(i).getKey().setPosition(position);
			int point = 0;
			switch (position) {
				case 1 : point = 25; break;
				case 2 : point = 18; break;
				case 3 : point = 15; break;
				case 4 : point = 12; break;
				case 5 : point = 10; break;
				case 6 : point = 8; break;
				case 7 : point = 6; break;
				case 8 : point = 4; break;
				case 9 : point = 2; break;
				case 10 : point = 1; break;
				default : point = 0; break;
			}
			classementDefinitif.get(i).getKey().setPoint(point);
		}
	}
	
	
	
	/**
	 * La methode getChampion() permet de recuperer le gagnant de l'edition. 
	 * @return
	 */
	public Participant getChampion() {
		Participant champion = null;
		if (classementDefinitif.size()>0){
			champion = classementDefinitif.get(0).getKey();
		}
		return champion;
	}
	
	/**
	 * Cette m��thode permet de calculer temps pr��vu d'une ��tape donn��e pour tous les participants d'une ��dition
	 * @param etape : l'��tape choit
	 * @param vitesse : la vitesse qu'on utilise pour calculer le vitesse pr��vue
	 * @return tempsPrevuEtape : HashMap
	 */
	public HashMap<Participant, Integer> tempsPrevuEtape(Etape etape, Integer vitesse){
		HashMap<Participant, Integer> pointSaison = new HashMap<Participant, Integer>();
		/*int saison = Integer.parseInt(this.getSaison().substring(this.getSaison().lastIndexOf(" ")+1))-1;			//cette partie mise en commentaire est pour obtenir la saison pr��c��dente
		String saisonAvant = (saison-1)+" / " + saison;*/
		
		//Calculer le classement des coureur par rapport aux points qu'ils ont obtenu la saison pr��c��dente 
		for(Participant participant : this.listPart) {
			int point = 0;
			for(Participant participation : participant.getCoureur().getListParticipation()) {
				if(participation.getEdition().getSaison().equals(this.saison)) {
					point += participation.getPoint();
				}
			}
			pointSaison.put(participant, point);
		}
		
		Set<HashMap.Entry<Participant, Integer>> entryset = pointSaison.entrySet();
		ArrayList<HashMap.Entry<Participant, Integer>> classementSaison = new ArrayList<HashMap.Entry<Participant, Integer>>(entryset);
		Collections.sort(classementSaison, new Comparator<HashMap.Entry<Participant, Integer>>(){
			@Override
			public int compare(HashMap.Entry<Participant, Integer> c1, HashMap.Entry<Participant, Integer> c2) {
				return c2.getValue().compareTo(c1.getValue());
			}		
		});
		
		//Calculer temps pr��vu ��tape 
		HashMap<Participant, Integer> tempsPrevu = new HashMap<Participant, Integer>();
		for(int i = 0; i < classementSaison.size(); i++) {
			float poids = (float)classementSaison.get(i).getKey().getVoiture().getPoids();
			float adherence = (float) classementSaison.get(i).getKey().getVoiture().getAdherence();
			float puissance = (float) classementSaison.get(i).getKey().getVoiture().getPuissanceV();
			float distance = (float) etape.getDistanceEtape();
			float nbVirage = (float) etape.getDifficulte();
			float coefNiveauPilot;
			
			//Calsuler le coefficient de niveau de pilot, coefNiveauPilot est d��pendant au classement de la saison pr��c��dente
			if(i<10) {
				coefNiveauPilot = (float) (0.95 + (10 - i) * 0.02);
			}
			else {
				coefNiveauPilot = (float) 0.95;
			}
			
			int temps = (int) (distance / (vitesse * coefNiveauPilot * (1-1/(puissance-200))*(poids/1000)) * 60 * 60 * 1000 + nbVirage * (1/coefNiveauPilot) * (1 + 1 / adherence)  * 1000);
			tempsPrevu.put(classementSaison.get(i).getKey(), temps);
		}
		return tempsPrevu;
	}
	
	/**
	 * Cette m��thode permet de savoir le temps pr��vu d'un participant donn�� sur une ��tape
	 * @param p : participant
	 * @param e : ��tape
	 * @return courir
	 */
	public Courir getTempsPrevu(Participant p, Etape e) {
		Courir temps = new Courir(0,0,0,0);
		HashMap<Participant, Integer> tempsPrevu = this.tempsPrevuEtape(e, 60);
		for(Participant part : tempsPrevu.keySet()) {
			if(part == p) {
				temps.setMilleSeconde(tempsPrevu.get(p));
				break;
			}
		}
		return temps;		
	}
	
	/**
	 * Cette m��thode permet de calculer le classement probable d'une ��dition en donnant une vitesse moyenne
	 * @param vitesse -- vitesse moyenne donn��e
	 * @return
	 */
	public ArrayList<HashMap.Entry<Participant, Integer>> classementProbable(Integer vitesse){
		//obtenir le classement en claculant la somme des temps prevus de chaque ��tape par apport aux participants
		HashMap<Participant, Integer> tempsPrevuDefinitif = new HashMap<Participant, Integer>();
		for(Participant participant : this.listPart) {
			tempsPrevuDefinitif.put(participant, 0);
		}
		for(Etape etape : this.listEtape) {
			HashMap<Participant, Integer> tempsPrevuEtape = this.tempsPrevuEtape(etape, vitesse);
			for(Participant participant : tempsPrevuDefinitif.keySet()) {
				int temps = tempsPrevuDefinitif.get(participant) + tempsPrevuEtape.get(participant);
				tempsPrevuDefinitif.put(participant, temps);
			}
		}
		//mettre le classement en l'ordre
		Set<HashMap.Entry<Participant, Integer>> entryset = tempsPrevuDefinitif.entrySet();
		ArrayList<HashMap.Entry<Participant, Integer>> classementProbable = new ArrayList<HashMap.Entry<Participant, Integer>>(entryset);
		Collections.sort(classementProbable, new Comparator<HashMap.Entry<Participant, Integer>>(){
			@Override
			public int compare(HashMap.Entry<Participant, Integer> c1, HashMap.Entry<Participant, Integer> c2) {
				return c1.getValue().compareTo(c2.getValue());
			}		
		});
		return classementProbable;
	}
	
}


