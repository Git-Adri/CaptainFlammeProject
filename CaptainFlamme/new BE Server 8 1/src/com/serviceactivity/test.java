package com.serviceactivity;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import beans.Charge;
import beans.InterrupteurPhysique;

public class test {

	
	
	
	
	
	public static void main(String[] args) {
		
		
		 List list = new ArrayList();
		 
		 ArrayList<Charge>   clist = new ArrayList<Charge>();
		 
		 
		 Charge c1 = new Charge(1);
		 Charge c2 = new Charge(2);
		 clist.add(c1);
		 clist.add(c2);
		 
		 
		 InterrupteurPhysique  i = new InterrupteurPhysique(1,"d",1,1,clist);
		 
		 list.add(i);
		 
		 
		 JSONArray ja =JSONArray.fromObject(list);
		 System.out.println(ja.toString());
		 
		 

		
		
	}
}
