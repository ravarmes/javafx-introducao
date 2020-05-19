package javafx.listview;

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
import javafx.scene.control.ListView;

public class FXMLListViewController implements Initializable {

    @FXML
    private ListView<Cliente> listViewClientes;

    @FXML
    private Button buttonRemover;

    private List<Cliente> listClientes = new ArrayList<>();

    private ObservableList<Cliente> observableListClientes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarListViewClientes();

        listViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemListViewClientes(newValue));
    }

    public void carregarListViewClientes() {

        Cliente c1 = new Cliente("Rafael", "1111-2222");
        Cliente c2 = new Cliente("João", "3333-4444");

        listClientes.add(c1);
        listClientes.add(c2);

        observableListClientes = FXCollections.observableArrayList(listClientes);

        listViewClientes.setItems(observableListClientes);

    }

    /*
    @FXML
    public void clicarMouseItemListViewClientes() {
        Cliente cliente = listViewClientes.getSelectionModel().getSelectedItem();
        System.out.println("Cliente selecionado pelo mouse do ListView: " + cliente.getNome());
    }*/
    @FXML
    public void selecionarItemListViewClientes(Cliente cliente) {
        if (cliente != null) {
            System.out.println("Cliente selecionado no ListView: " + cliente.getNome());
        }
    }

    @FXML
    public void removerItemListViewClientes() {
        Cliente cliente = listViewClientes.getSelectionModel().getSelectedItem();
        System.out.println("Cliente removido do ListView: " + cliente.getNome());
        listViewClientes.getItems().remove(cliente);
        //observableListClientes.remove(cliente);
    }

}
