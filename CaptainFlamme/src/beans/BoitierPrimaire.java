package beans;

import java.util.ArrayList;

public class BoitierPrimaire {

	private String nomBoitier;
	private double consoBoitier;
	private int idBoitier;
	private ArrayList<BoitierSecondaire> boitiersSecond = new ArrayList<BoitierSecondaire>();

	public BoitierPrimaire(String nomBoitier, double consoBoitier, int idBoitier,
			ArrayList<BoitierSecondaire> boitiersSecond) {
		super();
		this.nomBoitier = nomBoitier;
		this.consoBoitier = consoBoitier;
		this.idBoitier = idBoitier;
		this.boitiersSecond = boitiersSecond;
	}
	
	public void addBoitier(BoitierSecondaire boitier) {
		this.boitiersSecond.add(boitier);
	}

	public String getNomBoitier() {
		return nomBoitier;
	}

	public void setNomBoitier(String nomBoitier) {
		this.nomBoitier = nomBoitier;
	}

	public double getConsoBoitier() {
		return consoBoitier;
	}

	public void setConsoBoitier(double consoBoitier) {
		this.consoBoitier = consoBoitier;
	}

	public int getIdBoitier() {
		return idBoitier;
	}

	public ArrayList<BoitierSecondaire> getBoitiersSecond() {
		return boitiersSecond;
	}
	
}
