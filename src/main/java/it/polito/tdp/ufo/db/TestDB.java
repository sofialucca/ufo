package it.polito.tdp.ufo.db;

import java.util.List;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SightingDAO dao=new SightingDAO();
		
		List<String> formeUFO=dao.readShape();
		for(String forma: formeUFO) {
			int count=dao.countByShape(forma);
			System.out.println("UFO di forma "+forma+" sono: "+count);
		}
	}
	
}
