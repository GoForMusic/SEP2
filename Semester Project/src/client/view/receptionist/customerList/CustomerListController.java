package client.view.receptionist.customerList;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import shared.utils.User.Customer;

public class CustomerListController implements ViewController {
    public ListView<HBox> customerList;
    public Pane editUserInfo;
    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public TextField textFieldUsername;
    public TextField textFieldPassword;
    public Text errorLabel;
    private ViewHandler viewHandler;
    private CustomerListViewModel vm;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        vm = vmf.getCustomerListViewModel();
        loadCustomerList();
        editUserInfo.visibleProperty().bindBidirectional(vm.getEditCustomer());
        textFieldFirstName.textProperty().bindBidirectional(vm.getFirstName());
        textFieldLastName.textProperty().bindBidirectional(vm.getLastName());
        textFieldUsername.textProperty().bindBidirectional(vm.getUsername());
        textFieldPassword.textProperty().bindBidirectional(vm.getPassword());
        errorLabel.textProperty().bindBidirectional(vm.getErrorLabel());
    }

    private void loadCustomerList()
    {
        vm.loadUsers();
        customerList.setItems(vm.getCustomerList());
    }

    @FXML
    public void updateUserInfo(MouseEvent mouseEvent) {
        try{
            StringProperty oldUsername = new SimpleStringProperty();
            oldUsername.bindBidirectional(vm.getOldUsernameStored());
            Customer customer = new Customer(textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUsername.getText(),textFieldPassword.getText());
            vm.updateCustomer(customer,oldUsername.get());
            CancelEditAction(mouseEvent);
        }catch (IllegalStateException e)
        {
            errorLabel.setText(e.getMessage());
        }
        loadCustomerList();
    }

    @FXML
    public void CancelEditAction(MouseEvent mouseEvent) {
        editUserInfo.setVisible(false);
    }
}
