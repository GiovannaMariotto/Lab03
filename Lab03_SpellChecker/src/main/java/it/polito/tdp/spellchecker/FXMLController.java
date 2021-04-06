package it.polito.tdp.spellchecker;

/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
import java.net.URL;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary dizionario;
	private List<String> inputText;

		public void setModel(Dictionary model) {
			this.dizionario=model;
			
			
		}
		
	
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private ComboBox<?> boxLingua;
    ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("English", "Italian"));
    

    @FXML
    private TextArea txtInserito;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnClearText;
    
    @FXML
    void doActivation(ActionEvent event) {

    	if(this.boxLingua.getValue()==null) {
    		this.txtRisultato.setText("Please, select a language");
    		this.txtInserito.setDisable(true);
    		this.btnSpellCheck.setDisable(true);
    		this.btnClearText.setDisable(true);
    		this.txtInserito.setDisable(true);
    		
    	} else {
    		this.btnClearText.setDisable(false);
    		this.btnSpellCheck.setDisable(false);
    		this.txtInserito.setDisable(false);
    		this.txtInserito.setDisable(false);
    	}
    	
    	
    }


    @FXML
    void doClearText(ActionEvent event) {
    	this.txtRisultato.clear();
    	this.txtInserito.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	List<String> input = new LinkedList<String>();
    	String language ;
    	StringTokenizer st ;
    	String s;
    	
    	if(boxLingua.getValue()==null) {
    		this.txtInserito.setText("Selezione una lingua!");
    		return;
    	}
    	
    	
    	
    	try {
    		 s = this.txtInserito.getText();
    		
    		
    	} catch(Exception e) {
    		throw new RuntimeException(e);
    	}
    	 st = new StringTokenizer(s," ");
    	 
    	 int count =0;
    	 while(st.hasMoreTokens()) {
    		 input.add(st.toString());
    		 count++;
    	 }
    	
    	  

     	if(this.boxLingua.accessibleTextProperty() != null) {
     		if(this.boxLingua.getAccessibleText().equals("English")) {
     			//TODO: Load Dictionary
     			
     			
     			//d.loadDictionary("English");
     			
     		} else {
     			//d.loadDictionary("Italian");
     		}
     	}
     	
    	
    	
    	
    }

    @FXML
    void initialize() {
    	assert boxLingua != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserito != null : "fx:id=\"txtInserito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";

    }
   
}


