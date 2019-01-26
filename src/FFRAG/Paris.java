package FFRAG;

public class Paris {
	private Participant participant;
	private int mise;
	private static double beneficeffrag;
	private Edition ed;

	
	//Constructeur du pari
	public Paris(int montantmise, Participant participantmise, Edition edition){
		this.participant = participantmise;
		this.ed = edition;
		this.mise = montantmise;
	}
	
	public Participant getParticipant() {
		return participant;
	}

	public int getMise() {
		return mise;
	}

	public Edition getEditionConcerne() {
		return ed;
	}

	public static double getBeneficeffrag() {
		return beneficeffrag;
	}


	/**
	 * La fonction bingo permet de voir si la personne sur qui nous avons misé est arrivée première de l'édiition
	 * @return vrai si nous avons misé sur le vainqueur
	 */
	public boolean bingo() {
		boolean jackpot = false;
		if (this.participant == this.ed.getChampion()) {
			jackpot = true;
		}
		return jackpot;
	}

	/**
	 * Cette fonction permet de recupérer le gain pour un coureur sur qui j'ai parié.
	 * Si ce coureur arrive premier à l'édition alors mon gain total est multiplié par la cote.
	 * @return le montant du gain après déduction du pourcentage pris par la FFRAG
	 */
	public String getGain() {
		String gain = null;
		int cotation = 1;
		if(this.ed.getChampion() != null) {
			if (this.participant == this.ed.getChampion()) {
				double gainsEd = this.mise * this.participant.definirCotation();
				gain = String.valueOf(gainsEd);
				//ici sera la c魌e plus tard quand calcul閑 (en fonction du classement, et pond閞閑 par temps approximatif)

			}
			else {
				gain = String.valueOf(0);
			}
		}
		beneficeffrag = this.mise * cotation * 0.15;

		return gain;
	}
}
