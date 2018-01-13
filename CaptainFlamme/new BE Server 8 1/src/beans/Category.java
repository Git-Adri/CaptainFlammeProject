package beans;

import java.util.ArrayList;

public class Category {
	private int idCategory;
	private String nomCategory;
	private double consommation;
	private ArrayList <GroupeCharge> groupesCharge;
	private ArrayList <Interrupteur> interrupteurs;
	private ArrayList <Charge> charges;
	public Category(int idCategory, String nomCategory, double consommation, ArrayList<GroupeCharge> groupesCharge,
			ArrayList<Interrupteur> interrupteurs, ArrayList<Charge> charges) {
		this.idCategory = idCategory;
		this.nomCategory = nomCategory;
		this.consommation = consommation;
		this.groupesCharge = groupesCharge;
		this.interrupteurs = interrupteurs;
		this.charges = charges;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public String getNomCategory() {
		return nomCategory;
	}
	public void setNomCategory(String nomCategory) {
		this.nomCategory = nomCategory;
	}
	public double getConsommation() {
		return consommation;
	}
	public void setConsommation(double consommation) {
		this.consommation = consommation;
	}
	public ArrayList<GroupeCharge> getGroupesCharge() {
		return groupesCharge;
	}
	public void setGroupesCharge(ArrayList<GroupeCharge> groupesCharge) {
		this.groupesCharge = groupesCharge;
	}
	public ArrayList<Interrupteur> getInterrupteurs() {
		return interrupteurs;
	}
	public void setInterrupteurs(ArrayList<Interrupteur> interrupteurs) {
		this.interrupteurs = interrupteurs;
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
