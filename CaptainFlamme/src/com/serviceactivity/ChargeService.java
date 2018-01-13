package com.serviceactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import beans.Charge;
import beans.Charge.etatActuelType;
import beans.Charge.etatDefaultType;
import beans.Charge.prioriteType;

import com.db.DBmanager;

public class ChargeService {
	private static Hashtable<Integer,Charge> chargesList = new Hashtable<Integer,Charge>();
	public static DBmanager db = DBmanager.createInstance();
	
	static public void addCharge(Charge c) {
		if(!chargesList.containsKey(new Integer(c.getIdCharge()))) {
			chargesList.put(new Integer(c.getIdCharge()), c);
		}
	}
	static public Charge getCharge(int i) {
		if(chargesList.containsKey(new Integer(i))) {
			return chargesList.get(new Integer(i));
		}
		else
			return null;
	}
	
	static private ArrayList<Charge> createChargeList(ResultSet rs3) throws SQLException{
		ArrayList<Charge> chargelist = new ArrayList<Charge>();
		
		while (rs3.next()) {
			int id = rs3.getInt(0);
			Charge c = new Charge(id, rs3.getString(1),
					rs3.getInt(2), rs3.getInt(3), rs3.getDouble(6),
					prioriteType.valueOf(rs3.getString(5)),
					etatActuelType.valueOf(rs3.getString(8)),
					etatDefaultType.valueOf(rs3.getString(7)),
					rs3.getDouble(10));
			addCharge(c);
			chargelist.add(getCharge(id));

		}
		return chargelist;
		
	}
	static public ArrayList<Charge> getChargesFromCat(int catid) throws SQLException{
		String sql3 = "select * from charge where id in( select id_charge from category_charge  where id_category ="
				+ catid + ")";

		ResultSet rs3 = db.executeQuery(sql3);
		return createChargeList(rs3);
	}
	static public ArrayList<Charge> getChargesFromGroupe(int groupid) throws SQLException{
		ArrayList<Charge> chargelist = new ArrayList<Charge>();
		String sql3 = "select * from charge where id in( select id_charge from groupe_charge  where id_category ="
				+ groupid + ")";

		ResultSet rs3 = db.executeQuery(sql3);

		

		return createChargeList(rs3);
	}
	static public ArrayList<Charge> getChargesFromInterrupteurPhys(int interid) throws SQLException{
		ArrayList<Charge> chargelist = new ArrayList<Charge>();
		String sql3 = "select * from charge where id in( select id_charge from interrupteur_physique_charge  where id_inter ="
				+ interid + ")";
		ResultSet rs3 = db.executeQuery(sql3);

		return createChargeList(rs3);
	}

}
