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

	/**
	 * La methode organiserEtape permet de creer une etape pour l'edition
	 * @param code : code de l'etape
	 * @param distance : distance en km de l'etape
	 */
	public void organiserEtape(int code, int distance) {
		Etape etape = new Etape(code, distance);
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
			this.setTempFinal();
		}
	
	}
	
	
	
	/**
	 * La methode setTempFinal permet d'elaborer le classement definitif (quand la derni¨¨re etape de l'edition est terminee).
	 */
	public void setTempFinal() {
		for(int i = 0; i < classementGeneral.size(); i++) {
			int temps = classementGeneral.get(i).getValue();
			int position = i + 1;
			classementGeneral.get(i).getKey().setTempsFinal(temps);
			classementGeneral.get(i).getKey().setPosition(position);
			int point = 0;
			switch (i) {
				case 0 : point = 25;
				case 1 : point = 18;
				case 2 : point = 15;
				case 3 : point = 12;
				case 4 : point = 10;
				case 5 : point = 8;
				case 6 : point = 6;
				case 7 : point = 4;
				case 8 : point = 2;
				case 9 : point = 1;				
			}
			classementGeneral.get(i).getKey().setPoint(point);
		}
	}
	
	
	
	/**
	 * La methode getChampion() permet de recuperer le gagnant de l'edition. 
	 * @return
	 */
	public Participant getChampion() {
		Participant champion = null;
		if (classementGeneral.size()>0){
			champion = classementGeneral.get(0).getKey();
		}
		return champion;
	}
	
	//Calculer temps pr¨¦vu d'une ¨¦tape donn¨¦e pour tous les participants d'une ¨¦dition
	public HashMap<Participant, Integer> tempsPrevuEtape(Etape etape){
		HashMap<Participant, Integer> pointSaison = new HashMap<Participant, Integer>();
		for(Participant participant : this.listPart) {
			int point = 0;
			for(Participant participation : participant.getCoureur().getListParticipation()) {
				if(participation.getEdition().getSaison() == this.getSaison()) {
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
		HashMap<Participant, Integer> tempsPrevu = new HashMap<Participant, Integer>();
		for(int i = 0; i < classementSaison.size(); i++) {
			int poids = classementSaison.get(i).getKey().getVoiture().getPoids();
			int adherence = classementSaison.get(i).getKey().getVoiture().getAdherence();
			int puissance = classementSaison.get(i).getKey().getVoiture().getPuissanceV();
			float distance = etape.getDistanceEtape();
			int nbVirage = etape.getDifficulte();
			float coefNiveauPilot;
			if(i<10) {
				coefNiveauPilot = (float) (0.95 + (10 - i) * 0.02);
			}
			else {
				coefNiveauPilot = (float) 0.95;
			}
			int temps = (int) (distance / coefNiveauPilot * (1-1/(puissance-200))*(1-poids/10000) * 60 * 60 * 1000 + nbVirage * (1/coefNiveauPilot) * (1 + 1 / adherence) * 5 * 1000);
			tempsPrevu.put(classementSaison.get(i).getKey(), temps);
		}
		return tempsPrevu;
	}
	
	public Courir getTempsPrevu(Participant p, Etape e) {
		Courir temps = new Courir(0,0,0,0);
		HashMap<Participant, Integer> tempsPrevu = this.tempsPrevuEtape(e);
		for(Participant part : tempsPrevu.keySet()) {
			if(part == p) {
				temps.setMilleSeconde(tempsPrevu.get(p));
				break;
			}
		}
		return temps;		
	}
	
}