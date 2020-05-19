package javafx.combobox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.model.Cliente;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class FXMLComboBoxController implements Initializable {

    @FXML
    private ComboBox<Cliente> comboBoxClientes;

    @FXML
    private Button buttonRemover;

    private List<Cliente> listClientes = new ArrayList<>();

    private ObservableList<Cliente> observableListClientes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarComboBoxClientes();
    }

    public void carregarComboBoxClientes() {
        Cliente c1 = new Cliente("Rafael", "1111-2222");
        Cliente c2 = new Cliente("João", "3333-4444");

        listClientes.add(c1);
        listClientes.add(c2);

        observableListClientes = FXCollections.observableArrayList(listClientes);

        comboBoxClientes.setItems(observableListClientes);
    }

    @FXML
    public void selecionarItemComboBoxClientes() {
        Cliente cliente = comboBoxClientes.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            System.out.println("Cliente selecionado no ComboBox: " + cliente.getNome());
        }
    }

    @FXML
    public void removerItemComboBoxClientes() {
        Cliente cliente = comboBoxClientes.getSelectionModel().getSelectedItem();
        System.out.println("Cliente removido do ComboBox: " + cliente.getNome());
        comboBoxClientes.getItems().remove(cliente);
        //observableListClientes.remove(cliente);
    }

}
