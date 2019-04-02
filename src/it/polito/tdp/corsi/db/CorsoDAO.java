package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {
	
	public List<Corso> listAllByPd(int periodo){
		
		String sql = "SELECT * FROM corso WHERE pd = ?";
		List<Corso> result = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectionDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, periodo);
			
			ResultSet rs = st.executeQuery();
			
			while ( rs.next() ) {
				
				Corso c = new Corso(rs.getString("codins"),
					            	rs.getInt("crediti"),
						            rs.getString("nome"),
						            rs.getInt("pd"));
				
				result.add(c);
			}
			
			//Chiudo connessione
			conn.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		//restituisco risultato
		return result;
	}

	public Map<Corso,Integer> getIscrittiCorsi(int periodo){ 
	
	String sql = "SELECT c.codins, c.nome, c.crediti, c.pd, COUNT(*) as tot FROM corso c, iscrizione i WHERE c.codins = i.codins AND c.pd=? GROUP BY c.codins, c.nome";
	
	Map<Corso,Integer> result = new HashMap<Corso,Integer>();
	
	try {
		Connection conn = ConnectionDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, periodo);
		
		ResultSet rs = st.executeQuery();
		
		while ( rs.next() ) {
			
			Corso c = new Corso(rs.getString("codins"),
	            	rs.getInt("crediti"),
		            rs.getString("nome"),
		            rs.getInt("pd"));
			
			result.put( c , rs.getInt("tot"));		
		}
		
		conn.close();
	
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	
	return result;
  }
}
