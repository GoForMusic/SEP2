package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import com.sun.glass.ui.Accessible;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;


public class LoginController implements ViewController {

    // related to log in

    @FXML
    private TextField usernameLogin;
    @FXML
    private TextField passwordLogin;
    @FXML
    private Label errorLogin;

    // related to create

    @FXML
    private TextField firstNameCreate;
    @FXML
    private TextField lastNameCreate;
    @FXML
    private TextField usernameCreate;
    @FXML
    private TextField passwordCreate;
    @FXML
    private Label errorCreate;

    // private fields

    private ViewHandler viewHandler;
    private LoginViewModel viewModel;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {

        this.viewHandler = vh;
        this.viewModel = vmf.getLoginViewModel();

        // bindings - text fields bound bi-directional while labels bound uni-directional.............

        usernameLogin.textProperty().bindBidirectional(viewModel.getUsernameLogin());
        errorLogin.textProperty().bind(viewModel.getErrorLogin());
        lastNameCreate.textProperty().bindBidirectional(viewModel.getLastNameCreate());
        passwordLogin.textProperty().bindBidirectional(viewModel.getPasswordLogin());
        firstNameCreate.textProperty().bindBidirectional(viewModel.getFirstNameCreate());
        usernameCreate.textProperty().bindBidirectional(viewModel.getUsernameCreate());
        passwordCreate.textProperty().bindBidirectional(viewModel.getPasswordCreate());
        errorCreate.textProperty().bind(viewModel.getErrorCreate());
    }
    @FXML
    public void onLogin(ActionEvent event){
        if (viewModel.login().equals("Approved")){
            //TODO open a new view here.........
        }
    }

}
