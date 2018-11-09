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
		
	    public boolean bingo() {
	        boolean jackpot = false;
	            if (this.participant == this.editionConcerne.getChampion()) {
	                jackpot = true;
	            }
	        return jackpot;
	    }

	    public double getGainClassEtape() {
	        double gainsEd = 0;
	        int cotation = 1;

	            if (this.participant == this.editionConcerne.getChampion()) {
	                gainsEd = this.mise * cotation;
	            }
	        beneficeffrag += gainsEd * 0.15; 
	        return gainsEd * 0.85;

	    }

}
