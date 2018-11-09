package FFRAG;

/**
 * 
 * @author 21511708
 *
 */
import FFRAG.Coureur;
import FFRAG.Edition;
import FFRAG.Etape;

public class Paris {
	
		private Participant participant;
	    private int mise;
	    private Edition editionConcerne;
	    private static double beneficeffrag;
	    
	    /**
	     * Paris concernant une 閐ition compl鑤e non encore valid閑. L鑦e une
	     * exception si le paris concerne une 閐tion valid閑.
	     *
	     * @param montantmise
	     * @param coureurmise
	     * @param editionc
	     */
	    
	    public Paris(int montantmise, Participant participantmise, Edition editionc){
	            this.participant = participantmise;
	            this.editionConcerne = editionc;
	            this.mise = montantmise;
	    }

		public Participant getParticipant() {
			return participant;
		}

		public int getMise() {
			return mise;
		}

		public Edition getEditionConcerne() {
			return editionConcerne;
		}

		public static double getBeneficeffrag() {
			return beneficeffrag;
		}

	    /**
	     * Cette fonction bingo permet de voir si la personne sur qui nous avons
	     * mis� est arriv閑 premi鑢e de l'閐ition
	     *
	     * @return vrai si nous avons mis� sur le vainqueur
	     */
	    public boolean bingo() {
	        boolean jackpot = false;
	            if (this.participant == this.editionConcerne.getChampion()) {
	                jackpot = true;
	            }
	        return jackpot;
	    }
	    
	    /**
	     * Cette fonction permet de recup閞er le gain pour un coureur sur qui j'ai
	     * pari�. Si ce coureur
	     * arrive premier de l'閐ition alors mon
	     * gain total est multipli� par la c魌e.
	     *
	     * @return le montant du gain apr鑣 d閐uction du pourcentage pris par la
	     * FFRAG
	     */
	    public double getGainClassEtape() {
	        double gainsEd = 0;
	        int cotation = 1;

	            if (this.participant == this.editionConcerne.getChampion()) {
	                gainsEd = this.mise * cotation;
	                //ici sera la c魌e plus tard quand calcul閑 (en fonction du classement, et pond閞閑 par temps approximatif)

	            }
	        beneficeffrag += gainsEd * 0.15; //la ffrag r閏up鑢e 15% des gains
	        return gainsEd * 0.85;

	    }


}










