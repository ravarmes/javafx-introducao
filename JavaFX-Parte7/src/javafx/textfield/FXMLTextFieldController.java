package javafx.textfield;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLTextFieldController implements Initializable {
    
    @FXML
    private Label labelNome;
    
    @FXML
    private Label labelIdade;
    
    @FXML
    private TextField textFieldNome;
    
    @FXML
    private TextField textFieldIdade;
    
    @FXML
    private Button buttonCadastrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void cadastrarCliente(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro de Cliente");
        alert.setHeaderText("Informações sobre o Cadastro");
        alert.setContentText("Cliente " + textFieldNome.getText() + " foi cadastrado com sucesso!");
        alert.show();
    }
    
}
