package javafx.tableview;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.model.Cliente;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLTableViewController implements Initializable {

    @FXML
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;

    @FXML
    private TableColumn<Cliente, String> tableColumnClienteTelefone;

    @FXML
    private Button buttonRemover;

    private List<Cliente> listClientes = new ArrayList();

    private ObservableList<Cliente> observableListClientes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewClientes();

        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));
    }

    public void carregarTableViewClientes() {

        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClienteTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        Cliente c1 = new Cliente("Rafael", "1111-2222");
        Cliente c2 = new Cliente("João", "3333-4444");

        listClientes.add(c1);
        listClientes.add(c2);

        observableListClientes = FXCollections.observableArrayList(listClientes);

        tableViewClientes.setItems(observableListClientes);
    }

    public void selecionarItemTableViewClientes(Cliente cliente) {
        if (cliente != null) {
            System.out.println("Cliente selecionado no TableView: " + cliente.getNome());
        }
    }

    @FXML
    public void removerItemTableViewClientes() {
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            System.out.println("Cliente removido do TableView: " + cliente.getNome());
            tableViewClientes.getItems().remove(cliente);
        }
        //observableListClientes.remove(cliente);
    }

}
