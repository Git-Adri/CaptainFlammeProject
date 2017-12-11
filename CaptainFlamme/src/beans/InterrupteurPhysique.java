package beans;

import java.util.ArrayList;

public class InterrupteurPhysique extends Interrupteur {

	private  int numBoitier;
	private int numCommande;
	
	public InterrupteurPhysique(int id, String nom, int numBoitier, int numCommande, ArrayList<Charge> charges) {
		super(id, nom, charges);
		this.numBoitier = numBoitier;
		this.numCommande = numCommande;
	}
	public int getNumBoitier() {
		return numBoitier;
	}
	public void setNumBoitier(int numBoitier) {
		this.numBoitier = numBoitier;
	}
	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	
}
