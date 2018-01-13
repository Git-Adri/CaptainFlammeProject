package serviceactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BoitierSecondaire;
import beans.Charge;
import beans.Interrupteur;
import beans.Interrupteur.etatActuelType;
import db.DBmanager;
import beans.InterrupteurPhysique;
import beans.Charge.etatDefaultType;
import beans.Charge.prioriteType;
//image 1   and boitier  charge
public class Boitier {
	
	public static DBmanager db = DBmanager.createInstance();

	
	
	
	public ArrayList<BoitierSecondaire> getboiftiersecondaire() {
		
		
		String sql = "select * from boitier_secondaire";
		ResultSet  resultSet = db.executeQuery(sql);
		ArrayList<BoitierSecondaire>  aBoitierSecondaires = new ArrayList<BoitierSecondaire>();
		
		try {
			while(resultSet.next()) {
				int id = resultSet.getInt(0);
				String nom = resultSet.getString(1);
				double consommation = resultSet.getDouble(2);
				
				BoitierSecondaire boitierSecondaire = new BoitierSecondaire(nom, consommation, id,
						null, 
						null,
						null);
				
				aBoitierSecondaires.add(boitierSecondaire);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return aBoitierSecondaires;
		
	}
	
	public ArrayList<InterrupteurPhysique> getinterrupteurphsique_de_boitier(String idb) {
		
		String sql = "select * from interrupteur_physique where"
				+ "id in (select id_from interrupteur_physique where id_boitier= "+idb+")";
		
		
		
		ResultSet resultSet = db.executeQuery(sql);
		
		 ArrayList<InterrupteurPhysique> arrayList = new ArrayList<>();

		
		try {
			while(resultSet.next()) {
				
				InterrupteurPhysique interrupteurPhysique = new InterrupteurPhysique
						
						(resultSet.getInt(0),etatActuelType.valueOf(resultSet.getString(1)),
								resultSet.getString(4),resultSet.getInt(2),
								resultSet.getInt(3), null);
				
				
				arrayList.add(interrupteurPhysique);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return arrayList;
		
		
		
		
		
	}
	

	
//	
//	public ArrayList<Charge> getchargedeinterrupteur(String inte) {
//		
//		
//		
//		String sql = "select * from charge where id in(select id_charge from boitier_charge where id_boitier =" +iddeboitier+")";
//		
//		
//		ResultSet rs3 = db.executeQuery(sql);
//		
//		 ArrayList<Charge> arrayList = new ArrayList<>();
//		
//		
//		
//		
//	}
//	
	
	public ArrayList<Charge> getchargedeboitier(String iddeboitier) {
		
		String sql = "select * from charge where id in(select id_charge from boitier_charge where id_boitier =" +iddeboitier+")";
		
		
		ResultSet rs3 = db.executeQuery(sql);
		
		 ArrayList<Charge> arrayList = new ArrayList<>();

		
		try {
			while(rs3.next()) {
				

				Charge c = new Charge(rs3.getInt(0), rs3.getString(1),
						rs3.getInt(2), rs3.getInt(3), rs3.getDouble(6),
						prioriteType.valueOf(rs3.getString(5)),
						beans.Charge.etatActuelType.valueOf(rs3.getString(8)),
						etatDefaultType.valueOf(rs3.getString(7)),
						rs3.getDouble(10));
				        arrayList.add(c);
	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return arrayList;
		
		
	
		
		
		
	}
	
	
	
	
	

}
