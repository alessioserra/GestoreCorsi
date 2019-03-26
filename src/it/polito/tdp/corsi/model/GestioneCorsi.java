package it.polito.tdp.corsi.model;

import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;

public class GestioneCorsi {
	
	public List<Corso> getCorsiPerPeriodo(int periodo){
		
		CorsoDAO dao = new CorsoDAO();
		
		//Restituisco valori gia' trovati dalla Query
		return dao.listAllByPd(periodo);
		
	}

}
