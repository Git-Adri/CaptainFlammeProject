package beans;

import java.util.ArrayList;

public class Interrupteur {
	
	private int id;
	private String nom;
	protected ArrayList<Charge> charges;

	public Interrupteur(int id, String nom, ArrayList<Charge> charges) {
		this.id = id;
		this.nom = nom;
		this.charges=charges;
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Charge> getCharges() {
		return charges;
	}
	public void setCharges(ArrayList<Charge> charges) {
		this.charges = charges;
	}
	public void addCharge(Charge charge) {
		this.charges.add(charge);
	}
	public void rmCharge(int icharge) {
		this.charges.remove(icharge);
	}

}
