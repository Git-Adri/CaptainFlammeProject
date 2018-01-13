package beans;

import java.util.ArrayList;

public class InterrupteurVirtuel extends Interrupteur {

	private ArrayList <GroupeCharge> groupesCharge;
	public InterrupteurVirtuel(int id, String nom, ArrayList <Charge> charges,ArrayList<GroupeCharge> groupesCharge ) {
		super(id, etatActuelType.OFF,nom, charges);
		this.groupesCharge=groupesCharge;
	}
	public ArrayList<GroupeCharge> getGroupesCharge() {
		return groupesCharge;
	}
	public void setGroupes_charge(ArrayList<GroupeCharge> groupesCharge) {
		this.groupesCharge = groupesCharge;
	}
	public void addGroupe_Charge(GroupeCharge groupeCharge) {
		this.groupesCharge.add(groupeCharge);
	}
	public void rmGroupe_Charge(int igroupeCharge) {
		this.charges.remove(igroupeCharge);
	}
	
}
