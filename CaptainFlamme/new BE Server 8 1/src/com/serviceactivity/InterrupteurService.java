package com.serviceactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BoitierSecondaire;
import beans.Charge;
import beans.GroupeCharge;
import beans.GroupeCharge.Etat;
import beans.InterrupteurPhysique;
import beans.InterrupteurVirtuel;
import beans.Charge.etatActuelType;
import beans.Charge.etatDefaultType;
import beans.Charge.prioriteType;

import com.db.DBmanager;

public class InterrupteurService {

	public static DBmanager db = DBmanager.createInstance();

	private Charge.prioriteType priorite;
	private etatActuelType etatActuel;
	private etatDefaultType etatDefault;

	// get all the interrupteurphysique
	public ArrayList<InterrupteurPhysique> getInterupteurphysique(int idip) {

		ArrayList<InterrupteurPhysique> iplist = new ArrayList<InterrupteurPhysique>();
		try {
			String sql1 = "select * from interrupteur_physique where id="
					+ idip;

			ResultSet rs1 = db.executeQuery(sql1);
			// get all the interrupyeurphysique

			// ArrayList<InterrupteurVirtuel> ivlist = new
			// ArrayList<InterrupteurVirtuel>();
			// init iplist
			while (rs1.next()) {
				int id = rs1.getInt(0);
				int num_boitier = rs1.getInt(1);
				int num_command = rs1.getInt(2);
				String name = rs1.getString(3);

				// find the relation between ip and charge
				String sql3 = "select * from charge where id in( select id_charge from interrupteur_physique_charge  where id_inter ="
						+ id + ")";

				ResultSet rs3 = db.executeQuery(sql3);

				ArrayList<Charge> chargelist = new ArrayList<Charge>();

				while (rs3.next()) {

					Charge c = new Charge(rs3.getInt(0), rs3.getString(1),
							rs3.getInt(2), rs3.getInt(3), rs3.getDouble(6),
							prioriteType.valueOf(rs3.getString(5)),
							etatActuel.valueOf(rs3.getString(8)),
							etatDefaultType.valueOf(rs3.getString(7)),
							rs3.getDouble(10));
					chargelist.add(c);

				}

				InterrupteurPhysique ip = new InterrupteurPhysique(id,name,
						num_command, num_boitier, chargelist);

				iplist.add(ip);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return iplist;

	}

	public ArrayList<InterrupteurVirtuel> getallintervirtuel() {
		ArrayList<InterrupteurVirtuel> ivlist = new ArrayList<InterrupteurVirtuel>();
		try {
			String sql1 = "select * from interrupteur_virtuel";

			ResultSet rs1 = db.executeQuery(sql1);
			// get all the interrupyeurphysique

			// ArrayList<InterrupteurVirtuel> ivlist = new
			// ArrayList<InterrupteurVgetinterrupteurphsique_de_boitierirtuel>();
			// init iplist
			while (rs1.next()) {
				int id = rs1.getInt(0);

				String name = rs1.getString(1);

				// find the relation between iv and charge
				String sql3 = "select * from charge where id in( select id_charge from interrupteur_virtuel_charge  where id_inter ="
						+ id + ")";
				ResultSet rs3 = db.executeQuery(sql3);

				ArrayList<Charge> chargelist = new ArrayList<Charge>();
				while (rs3.next()) {

					Charge c = new Charge(rs3.getInt(0), rs3.getString(1),
							rs3.getInt(2), rs3.getInt(3), rs3.getDouble(6),
							prioriteType.valueOf(rs3.getString(5)),
							etatActuel.valueOf(rs3.getString(8)),
							etatDefaultType.valueOf(rs3.getString(7)),
							rs3.getDouble(10));
					chargelist.add(c);
				}

				// find the groupe who is related with interrupteurvirtuel
				String sql4 = "select * from groupe where id in( select id_groupe from interrupteur_virtuel_groupe  where id_inter ="
						+ id + ")";
				ResultSet rs4 = db.executeQuery(sql4);

				ArrayList<GroupeCharge> groupechargelist = new ArrayList<GroupeCharge>();
				while (rs4.next()) {

					GroupeCharge gc = new GroupeCharge(rs4.getInt(0),
							rs4.getString(1), rs4.getDouble(3),
							getchargeofgroupe(rs4.getInt(0)), Etat.valueOf(rs4
									.getString(2)));

					groupechargelist.add(gc);
				}

				InterrupteurVirtuel ip = new InterrupteurVirtuel(id, name,
						chargelist, groupechargelist);

				ivlist.add(ip);
				return ivlist;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ivlist;
	}

	// get those charges of group with id id1
	public ArrayList<Charge> getchargeofgroupe(int groupeid) {
		ArrayList<Charge> ac = new ArrayList<Charge>();

		try {
			String s = "select * from charge where id=" + groupeid;
			ResultSet rs3 = db.executeQuery(s);

			while (rs3.next()) {

				Charge c = new Charge(rs3.getInt(0), rs3.getString(1),
						rs3.getInt(2), rs3.getInt(3), rs3.getDouble(6),
						prioriteType.valueOf(rs3.getString(5)),
						etatActuel.valueOf(rs3.getString(8)),
						etatDefaultType.valueOf(rs3.getString(7)),
						rs3.getDouble(10));

				ac.add(c);
			}
			return ac;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ac;

	}

}
