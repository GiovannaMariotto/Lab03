package it.polito.tdp.spellchecker;

/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
import java.net.URL;
import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;

import java.util.ArrayList;
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
			this.txtInserito.setText("Selezionare una lingua");
			this.btnSpellCheck.setDisable(true);
			this.btnClearText.setDisable(true);
			boxLingua.getItems().addAll("English","Italian");
			this.dizionario=model;
			
		}
		
	
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private ComboBox<String> boxLingua;
  

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
    	this.txtRisultato.clear();
    	List<String> input = new LinkedList<String>();
    	
    	if(boxLingua.getValue()==null) {
    		this.txtInserito.setText("Selezione una lingua!");
    		return;
    	}
    	if(!dizionario.loadDictionary(boxLingua.getValue().toString())) {
    		this.txtRisultato.setText("Errore nel caricamento del dizionario");
    		return;
    	}
    	
    	String inputText=this.txtInserito.getText();
    	if(inputText.isEmpty()) {
    		this.txtRisultato.setText("Inserire un testo da correggere!");
    		return;
    	}
    	
    	inputText.replaceAll("\n", " ");
    	inputText = inputText.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
    	StringTokenizer st = new StringTokenizer(inputText, " ");
    	
    	while(st.hasMoreTokens()) {
    		input.add(st.nextToken());
    	}
    	
    	long start = System.nanoTime();
    	List<RichWord> outputTextList;
    	outputTextList = dizionario.spellCheckText(input);
    	long end = System.nanoTime();
    	int numErrori =0;
    	
    	StringBuilder richText = new StringBuilder();
    	
    	for(RichWord r : outputTextList) {
    		if(!r.isCorreta()) {
    			numErrori++;
    			richText.append(r.getParola()+"\n");
    		}
    	}
    	
    	this.txtRisultato.setText(richText.toString());
    	this.txtRisultato.appendText("\n"+"Number of Errors:"+numErrori);
    	
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


