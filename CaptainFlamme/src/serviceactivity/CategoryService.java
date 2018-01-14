package serviceactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Category;
import beans.Charge;
import beans.GroupeCharge;
import beans.Interrupteur;
import db.DBmanager;

public class CategoryService {
	public static DBmanager db = DBmanager.createInstance();
	
	static public Category getCategory(String name) {

		Category cat=null;
		try {
			String sql1 = "select * from category where name="
					+ name;

			ResultSet rs1 = db.executeQuery(sql1);
			// get all the interrupyeurphysique

			// ArrayList<InterrupteurVirtuel> ivlist = new
			// ArrayList<InterrupteurVirtuel>();
			// init iplist
			while (rs1.next()) {
				int id = rs1.getInt(0);
				String nom = rs1.getString(1);
				double conso = rs1.getDouble(2);
				
				// Get all the list linked to the category
				ArrayList<Charge> chargelist = ChargeService.getChargesFromCat(id);
				ArrayList<GroupeCharge> groupeChargeList = GroupeService.getGChargesFromCat(id);
				ArrayList<Interrupteur> interList =InterrupteurService.getInterrupteurFromCat(id);
				
				cat = new Category(id,nom,conso,groupeChargeList,interList,chargelist);

				return cat;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	static public ArrayList<Category> getCategoryList(){
			ArrayList<Category> list = new ArrayList<Category>();
			Category cat=null;
			try {
				
				String sql1 = "select * from category";

				ResultSet rs1 = db.executeQuery(sql1);
				// get all the interrupyeurphysique

				// ArrayList<InterrupteurVirtuel> ivlist = new
				// ArrayList<InterrupteurVirtuel>();
				// init iplist
				while (rs1.next()) {
					int id = rs1.getInt(0);
					String nom = rs1.getString(1);
					double conso = rs1.getDouble(2);
					
					// find the relation between ip and charge
					ArrayList<Charge> chargelist = ChargeService.getChargesFromCat(id);
					ArrayList<GroupeCharge> groupeChargeList = GroupeService.getGChargesFromCat(id);
					ArrayList<Interrupteur> interList =InterrupteurService.getInterrupteurFromCat(id);
					
					cat = new Category(id,nom,conso,groupeChargeList,interList,chargelist);
					 list.add(cat);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
}
