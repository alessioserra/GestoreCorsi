package it.polito.tdp.corsi.model;

import java.util.Map;
import java.util.Map.Entry;

//CLASSE PER I TEST

public class TestModel {

	public void run() {
		GestioneCorsi model = new GestioneCorsi();
		
		Map<Corso,Integer> res = model.getIscrittiCorsi(1);
		
		for (Entry<Corso, Integer> entry : res.entrySet()) {
			System.out.println(entry.getKey().getNome() + " = " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		TestModel main = new TestModel();
		main.run();
	}
	
}
