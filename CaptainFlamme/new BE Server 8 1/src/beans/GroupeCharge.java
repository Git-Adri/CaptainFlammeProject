package beans;

import java.util.ArrayList;

public class GroupeCharge {
	
	public enum Etat{on,off,intermed};

	private int idGroupe;
	private String nomGroupe;
	private Etat etatGroupe;
	private double consommation;
	private ArrayList<Charge> charges;

	public GroupeCharge(int idGroupe, String nomGroupe, double consommation, ArrayList<Charge> charges, Etat  etatGroupe) {
		this.idGroupe = idGroupe;
		this.nomGroupe = nomGroupe;
		this.consommation = consommation;
		this.charges = charges;
		this.etatGroupe = etatGroupe;
	}

	public int getIdGroupe() {
		return idGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public double getConsommation() {
		return consommation;
	}
	public void setConsommation(double consommation) {
		this.consommation = consommation;
	}
	public ArrayList<Charge> getCharges() {
		return charges;
	}
	public void setCharges(ArrayList<Charge> charges) {
		this.charges = charges;
	}
	public Etat getEtatGroupe() {
		return etatGroupe;
	}
	public void setEtat_groupe(Etat etatGroupe) {
		this.etatGroupe = etatGroupe;
	}
	public void addCharge(Charge charge) {
		this.charges.add(charge);
	}
	public void rmCharge(int icharge) {
		this.charges.remove(icharge);
	}

}
