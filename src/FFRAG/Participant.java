package FFRAG;
import java.util.*;

public class Participant {

    private int noInscription;
    private int tempsFinal;
    private Coureur coureur;
    private Voiture voiture;
    private int position;
    private int point;
    private Edition edition;
    
	public Participant (int nIns, Coureur c, Voiture v) {
		this.noInscription = nIns;
        this.coureur = c;
        this.voiture = v;
        this.coureur.affecterParticipation(this);
    }
	
	public int getTempsFinal() {
		return this.tempsFinal;
	}
	
    public void setTempsFinal(int temps) {
    	this.tempsFinal = temps;
    }
    
    public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
    public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Voiture getVoiture() {
		return voiture;
	}
    
    public int getNoInscription() {
		return noInscription;
	}
    
    public void setNoInscription(int noInscription) {
		this.noInscription = noInscription;
	}

    public Coureur getCoureur() {
		return coureur;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	/**
	 * Cette methode permet de v¨¦rifier si le participant a bien pris le d¨¦part ¨¤ une ¨¦tape afin de le disqualifier ensuite dans l'etape
	 * @param e : objet etape pour lequel on va verifier la participation
	 * @return
	 */
	public boolean prendreDepart(Etape e) {
    	boolean prendreDepart = true;
   		if(e.getTabParticipants().get(this)==null) {
    			prendreDepart=false;
    		};
    	return prendreDepart;
    } 
	
	public int definirNumPart() {
		int indexPart = 0;
		ArrayList<HashMap.Entry<Participant, Integer>> classementProbable = this.edition.classementProbable(60);
		for(int i = 0; i < classementProbable.size(); i++) {
			if (this.equals(classementProbable.get(i).getKey())) {
				indexPart = i;
			}
		}
		return indexPart;
	}
	
	//m¨¦thode d¨¦finition de cotation
		public double definirCotation() {
			ArrayList<HashMap.Entry<Participant, Integer>> classementProbable = this.edition.classementProbable(60);
			double minTempsMaxCoureur, tempsMinCoureur, sommeInt, sommeT,probabilite,cotation;
			sommeT=0;
			sommeInt=0;
			probabilite=0;
			cotation=0;
			minTempsMaxCoureur=this.edition.classementProbable(55).get(0).getValue();
			int nbBoucle = 0;
			for(int i = 0; i<classementProbable.size(); i++) {
				if(minTempsMaxCoureur > this.edition.classementProbable(65).get(i).getValue()) {
					nbBoucle++;
				}
				else {
					break;
				}
			}
			for(int i=0; i<nbBoucle;i++) {
				tempsMinCoureur=this.edition.classementProbable(65).get(i).getValue();
				sommeInt=minTempsMaxCoureur-tempsMinCoureur;
				sommeT=sommeT+sommeInt;
			}
			sommeInt=minTempsMaxCoureur-(this.edition.classementProbable(65).get(this.definirNumPart()).getValue());
			System.out.println(minTempsMaxCoureur);
			System.out.println(sommeInt);
			probabilite=sommeInt/sommeT;
			if(probabilite > 0.01) {
				cotation=1/probabilite/3;
			}
			else {
				cotation = 45;
			}
			cotation = (double) Math.round(cotation *100) /100;
			return cotation;
		}
    

}