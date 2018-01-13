package beans;

import java.util.ArrayList;

import beans.Charge.etatActuelType;

public class Interrupteur {
	
	private int id;
	private String nom;
	protected ArrayList<Charge> charges;
	public static enum etatActuelType{ON,OFF};
	private etatActuelType etatActuel;
	
	
	
	
	
	public Interrupteur(int id, etatActuelType e, String nom, ArrayList<Charge> charges) {
		this.id = id;
		etatActuel=e;
		this.nom = nom;
		this.charges=charges;
	}
	
	public etatActuelType getEtatActuel() {
		return etatActuel;
	}
	public void setEtatActuel(etatActuelType etatActuel) {
		this.etatActuel = etatActuel;
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
