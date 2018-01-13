package beans;

import java.util.ArrayList;

public class BoitierSecondaire extends BoitierPrimaire {

	private Charge[] tabCharge = new Charge[8];
	private InterrupteurPhysique[] tabInterupteurPhys = new InterrupteurPhysique[8];
	
	
	public BoitierSecondaire(String nomBoitier, double consoBoitier, int idBoitier,
			ArrayList<BoitierSecondaire> boitiersSecond, Charge[] tabCharge,
			InterrupteurPhysique[] tabInterupteurPhys) {
		super(nomBoitier, consoBoitier, idBoitier, boitiersSecond);
		this.tabCharge = tabCharge;
		this.tabInterupteurPhys = tabInterupteurPhys;
	}


	public Charge[] getTabCharge() {
		return tabCharge;
	}


	public void setTabCharge(Charge[] tabCharge) {
		this.tabCharge = tabCharge;
	}


	public InterrupteurPhysique[] getTabInterupteurPhys() {
		return tabInterupteurPhys;
	}


	public void setTabInterupteurPhys(InterrupteurPhysique[] tabInterupteurPhys) {
		this.tabInterupteurPhys = tabInterupteurPhys;
	}
	
}
