package com.serviceactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.db.DBmanager;

import beans.Charge;
import beans.GroupeCharge;

public class GroupeService {
	private static Hashtable<Integer,GroupeCharge> groupeList = new Hashtable<Integer,GroupeCharge>();
	public static DBmanager db = DBmanager.createInstance();
	
	static public void addGroupe(GroupeCharge c) {
		if(!groupeList.containsKey(new Integer(c.getIdGroupe()))) {
			groupeList.put(new Integer(c.getIdGroupe()), c);
		}
	}
	static public GroupeCharge getGroupe(int i) {
		if(groupeList.containsKey(new Integer(i))) {
			return groupeList.get(new Integer(i));
		}
		else
			return null;
	}
	
	static private ArrayList<GroupeCharge> createGCList(ResultSet rs3) throws SQLException {
		ArrayList<GroupeCharge> gchargelist = new ArrayList<GroupeCharge>();

		while (rs3.next()) {
			int id = rs3.getInt(0);
			ArrayList<Charge> charges = ChargeService.getChargesFromGroupe(id);
			GroupeCharge gc = new GroupeCharge(id,rs3.getString(1),rs3.getDouble(2),charges,GroupeCharge.Etat.valueOf(rs3.getString(3)) );
			addGroupe(gc);
			gchargelist.add(getGroupe(id));
		}
		return gchargelist;
	}
	
	static public ArrayList<GroupeCharge> getGChargesFromCat(int catid) throws SQLException{
		String sql3 = "select * from groupe where id in( select id_charge from category_groupe  where id_category ="
				+ catid + ")";

		ResultSet rs3 = db.executeQuery(sql3);
		return createGCList(rs3);
	}

}
