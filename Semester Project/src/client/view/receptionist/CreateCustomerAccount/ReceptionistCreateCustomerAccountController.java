package client.view.receptionist.CreateCustomerAccount;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReceptionistCreateCustomerAccountController implements ViewController {

    @FXML
    private TextField createFirstName;
    @FXML
    private TextField createUsername;
    @FXML
    private TextField createPassword;
    @FXML
    private TextField createLastName;
    @FXML
    private Label errorLabel;
    private String newUser;

    private ViewHandler viewHandler;
    private ReceptionistCreateCustomerAccountViewModel receptionistCreateCustomerAccountViewModel;
    private ViewModelFactory viewModelFactory;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {

        viewHandler = vh;
        viewModelFactory = vmf;
        receptionistCreateCustomerAccountViewModel = viewModelFactory.getReceptionistCreateCustomerAccount();
        bindEverything();

    }

    private void bindEverything() {
        createFirstName.textProperty().bindBidirectional(receptionistCreateCustomerAccountViewModel.getFirstNameProperty());
        createLastName.textProperty().bindBidirectional(receptionistCreateCustomerAccountViewModel.getLastNameProperty());
        createPassword.textProperty().bindBidirectional(receptionistCreateCustomerAccountViewModel.getPasswordProperty());
        createUsername.textProperty().bindBidirectional(receptionistCreateCustomerAccountViewModel.getUserNameProperty());
        errorLabel.textProperty().bind(receptionistCreateCustomerAccountViewModel.errorLabelProperty());
    }

    @FXML
    private void createAccount(ActionEvent actionEvent) {
        receptionistCreateCustomerAccountViewModel.createAccount();
    }
}
