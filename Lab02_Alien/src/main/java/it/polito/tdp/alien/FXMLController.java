package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserimento;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtDizionario;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	txtInserimento.clear();
    	txtDizionario.clear();
    	model.ripulisci();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String parole[];
    	String testo=txtInserimento.getText();
    	parole=testo.split(" ");
    	if(parole.length==1) {
    		if(model.verificaParola(parole[0])==false) {
    			txtDizionario.setText("Hai inserito una parola con caratteri sbagliati");
    			txtInserimento.clear();
    			return;}
    		String traduzione=model.traduci(parole[0]);
    		if(traduzione!=null)
    		txtDizionario.setText(""+parole[0]+" la cui traduzione e: "+traduzione);
    		else
    			txtDizionario.setText("Hai cercato una parola per cui non hai ancora inserito una traduzione");
    		txtInserimento.clear();
    		return;
    	}
    	
    	if(parole.length>2) {
    		txtDizionario.setText("Hai inserito troppi campi");
    		txtInserimento.clear();
    		return;
    	}
    	
    	if(parole.length==2) {
    		if(model.verificaParole(parole[0], parole[1])==false) {
    			txtDizionario.setText("Hai inserito almeno una parola con caratteri sbagliati");
    			txtInserimento.clear();
    			return;
    		}	
    		txtDizionario.setText("Parola aggiunta correttamente");
    		txtInserimento.clear();
    		return;
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert txtInserimento != null : "fx:id=\"txtInserimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDizionario != null : "fx:id=\"txtDizionario\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
