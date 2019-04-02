package it.polito.tdp.corsi.model;

import java.util.*;

import it.polito.tdp.corsi.db.CorsoDAO;

public class GestioneCorsi {
	
	public List<Corso> getCorsiPerPeriodo(int periodo){
		
		CorsoDAO dao = new CorsoDAO();
		
		//Restituisco valori gia' trovati dalla Query
		return dao.listAllByPd(periodo);
	}
	
	public Map<Corso,Integer> getIscrittiCorsi(int periodo){ 
		CorsoDAO dao = new CorsoDAO();
		
		return dao.getIscrittiCorsi(periodo);
	}

}
