package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestioneCorsi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {
	
	GestioneCorsi model = new GestioneCorsi();
	
	public void setModel(GestioneCorsi model) {
		this.model=model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPeriodo;

    @FXML
    private Button cercaCorsi;

    @FXML
    private Button statCorsi;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcolaStat(ActionEvent event) {

    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	int periodo;
    	
    	//Controllo degli errori sul formato
    	try {
    	  periodo= Integer.parseInt(txtPeriodo.getText());
    	} catch(NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	if(periodo !=1 && periodo!=2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	//metodo
    	List<Corso> corsi = this.model.getCorsiPerPeriodo(periodo);
    	for(Corso c: corsi) {
    		txtResult.appendText(c.toString()+"\n");
    	}
    	

    }

    @FXML
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert cercaCorsi != null : "fx:id=\"cercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert statCorsi != null : "fx:id=\"statCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

    }
}

