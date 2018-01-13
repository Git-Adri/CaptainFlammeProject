package beans;

public class Charge {

	private int idCharge;
	private String nomCharge;
	private int numBoitier;
	private int numSortie;
	private double calibre;

	public static enum prioriteType{ZERO,UN,DEUX,TROIS,QUATRE,CINQ,SIX,SEPT,HUIT,NEUF};
	public static enum etatActuelType{ON,OFF};
	public static enum etatDefaultType{ON,OFF,PRECEDENT};

	private prioriteType priorite;
	private etatActuelType etatActuel;
	private etatDefaultType etatDefault;


	private double consomation;

	public Charge(int id,String nom,int numboitier,int numsortie,double calibre, prioriteType prior, etatActuelType actuel,etatDefaultType def, double conso) {
		
		this.idCharge = id;
		this.nomCharge= nom;
		this.numBoitier = numboitier;
		this.numSortie = numsortie;
		this.calibre = calibre;
		this.priorite = prior;
		this.etatActuel = actuel;
		this.etatDefault = def;
		this.consomation = conso;
		
	}

	
	
	public Charge(int id) {
		// TODO Auto-generated constructor stub
	
	idCharge= id;
	
	}
	




	public int getIdCharge() {
		return idCharge;
	}

	public String getNomCharge() {
		return nomCharge;
	}

	public void setNomCharge(String nomCharge) {
		this.nomCharge = nomCharge;
	}

	public int getNumBoitier() {
		return numBoitier;
	}

	public void setNumBoitier(int numBoitier) {
		this.numBoitier = numBoitier;
	}

	public int getNumSortie() {
		return numSortie;
	}

	public void setNumSortie(int numSortie) {
		this.numSortie = numSortie;
	}

	public double getCalibre() {
		return calibre;
	}

	public void setCalibre(double calibre) {
		this.calibre = calibre;
	}

	public prioriteType getPriorite() {
		return priorite;
	}

	public void setPriorite(prioriteType priorite) {
		this.priorite = priorite;
	}

	public etatActuelType getEtatActuel() {
		return etatActuel;
	}

	public void setEtatActuel(etatActuelType etatActuel) {
		this.etatActuel = etatActuel;
	}

	public etatDefaultType getEtatDefault() {
		return etatDefault;
	}

	public void setEtatDefault(etatDefaultType etatDefault) {
		this.etatDefault = etatDefault;
	}

	public double getConsomation() {
		return consomation;
	}

	public void setConsomation(double consomation) {
		this.consomation = consomation;
	}
}
