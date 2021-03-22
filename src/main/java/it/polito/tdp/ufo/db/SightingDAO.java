package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {

	public List<String> readShape(){
		try {
			Connection conn =DBConnect.getConnection();
			String sql="SELECT DISTINCT shape FROM sighting WHERE shape<>'' ORDER BY shape ASC";
			//si da valore dopo avere definito query
			PreparedStatement st=conn.prepareStatement(sql);
			//esecuzione query e risultati salvati nel set
			ResultSet res=st.executeQuery(sql);
			//lettura risultati
			List<String> formeUFO=new ArrayList<>();
			
			while(res.next()) {
				String forma=res.getString("shape");
				formeUFO.add(forma);
			}
			st.close();
			conn.close();
			return formeUFO;
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Database error in readShape",sqle);
		}
	}
	
	public int countByShape(String shape) {

		try {
			Connection conn =DBConnect.getConnection();
			String sql2="SELECT COUNT(*) AS cnt FROM sighting\r\n WHERE shape=?";
			String shapeScelta="circle";
			
			PreparedStatement st2=conn.prepareStatement(sql2);
			st2.setString(1, shapeScelta);
			ResultSet res2=st2.executeQuery();
			res2.first();
			int count=res2.getInt("cnt");
			st2.close();
			//chiusura connessione
			conn.close();
			return count;
		} catch (SQLException sqle) {
			throw new RuntimeException("Database error in countByShape",sqle);
		}
	}
}
