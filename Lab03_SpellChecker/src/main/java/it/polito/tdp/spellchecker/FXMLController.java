package it.polito.tdp.spellchecker;

/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class FXMLController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> btnChoiseBox;

    @FXML
    private TextArea txtInserito;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnClearText;

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnChoiseBox != null : "fx:id=\"btnChoiseBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserito != null : "fx:id=\"txtInserito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}


