package client.view.receptionist.customerList;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
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
        customerList.setItems(vm.getCustomerList());
        editUserInfo.visibleProperty().bindBidirectional(vm.getEditCustomer());
        textFieldFirstName.textProperty().bindBidirectional(vm.getFirstName());
        textFieldLastName.textProperty().bindBidirectional(vm.getLastName());
        textFieldUsername.textProperty().bindBidirectional(vm.getUsername());
        textFieldPassword.textProperty().bindBidirectional(vm.getPassword());
        errorLabel.textProperty().bindBidirectional(vm.getErrorLabel());
    }

    @FXML
    public void updateUserInfo(MouseEvent mouseEvent) {
        try{
            Customer customer = new Customer(textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUsername.getText(),textFieldPassword.getText());
            //TODO send it to DB
        }catch (IllegalStateException e)
        {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void CancelEditAction(MouseEvent mouseEvent) {
        editUserInfo.setVisible(false);
    }
}
