import java.util.*;
public class Courir {	
	int milleSeconde;

	public Courir(int hh, int mm, int ss, int ms) {
		this.milleSeconde = ((hh * 60 + mm) * 60 + ss) * 1000 + ms;
	}
	
	public String getTemps() {
		String temps = "";
		int ms = milleSeconde % 1000;
		int ss = (milleSeconde / 1000) % 60;
		int mm = milleSeconde / 1000 / 60 % 60;
		int hh = milleSeconde / 1000 / 60 / 60;
		temps += hh + ":" + mm + ":" + ss + ":" + mm + ":" + ms;
		return temps;
	}

	public void setMilleSeconde(int milleSeconde) {
		this.milleSeconde = milleSeconde;
	}

	
	public int getMilleSeconde() {
		return milleSeconde;
	}
}
