package client.view.login;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.customer.CustomerModel;
import client.view.ViewController;
import client.view.customer.profile.AccountInformationModel;
import client.view.login.createAccount.CreateAccountViewModel;
import client.view.login.loginExisting.LoginViewModel;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import shared.utils.User.Usertype;

public class LoginController implements ViewController {

    @FXML
    private AnchorPane SIgnUpLayer;
    @FXML
    private Label createTopic;
    @FXML
    private Label inSignIn;
    @FXML
    private TextField signUpFirstName;
    @FXML
    private TextField signUpLastName;
    @FXML
    private TextField signUpUsername;
    @FXML
    private PasswordField signUpPassword;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField signInUsername;
    @FXML
    private Button signInButton;
    @FXML
    private PasswordField signInPassword;
    @FXML
    private AnchorPane layer2;
    @FXML
    private Label upWelcome;
    @FXML
    private Label upWelcome2;
    @FXML
    private Label loginWarning;
    @FXML
    private Button SignInButtonInUp;
    @FXML
    private Button signUpButton1;
    @FXML
    private Label inText;
    @FXML
    private Label createError;

    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;

    private AccountInformationModel accountInformationModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModelFactory = vmf;
        loginViewModel = viewModelFactory.getLoginViewModel();
        this.createAccountViewModel = viewModelFactory.getCreateAccountViewModel();
        bindEverythingWithLogin();
        bindEverythingWithSignUp();
        accountInformationModel= viewModelFactory.getCustomerAccountInfoModel();


        // signInAnimation();

    }

    private void bindEverythingWithSignUp() {
        createTopic.visibleProperty().bind(createAccountViewModel.getSignupScene());
        signUpFirstName.visibleProperty().bind(createAccountViewModel.getSignupScene());
        signUpLastName.visibleProperty().bind(createAccountViewModel.getSignupScene());
        signUpUsername.visibleProperty().bind(createAccountViewModel.getSignupScene());
        signUpPassword.visibleProperty().bind(createAccountViewModel.getSignupScene());
        signUpButton.visibleProperty().bind(createAccountViewModel.getSignupScene());
        upWelcome.visibleProperty().bind(createAccountViewModel.getSignupScene());
        SignInButtonInUp.visibleProperty().bind(createAccountViewModel.getSignupScene());
        upWelcome2.visibleProperty().bind(createAccountViewModel.getSignupScene());
        createError.visibleProperty().bind(createAccountViewModel.getSignupScene());

        // text properties
        signUpFirstName.textProperty().bindBidirectional(createAccountViewModel.getSignUpFirstName());
        signUpLastName.textProperty().bindBidirectional(createAccountViewModel.getSignUpLastName());
        signUpPassword.textProperty().bindBidirectional(createAccountViewModel.getSignUpPassword());
        signUpUsername.textProperty().bindBidirectional(createAccountViewModel.getSignUpUsername());
        createError.textProperty().bind(createAccountViewModel.getErrorLabel());

    }

    private void bindEverythingWithLogin() {

        inSignIn.visibleProperty().bind(loginViewModel.getSignInScene());
        signInUsername.visibleProperty().bind(loginViewModel.getSignInScene());
        signInPassword.visibleProperty().bind(loginViewModel.getSignInScene());
        signUpButton.visibleProperty().bind(loginViewModel.getSignInScene());
        inText.visibleProperty().bind(loginViewModel.getSignInScene());
        signUpButton1.visibleProperty().bind(loginViewModel.getSignInScene());
        signInButton.visibleProperty().bind(loginViewModel.getSignInScene());
        loginWarning.visibleProperty().bind(loginViewModel.getSignInScene());
        // binding text properties..
        signInUsername.textProperty().bindBidirectional(loginViewModel.getUsernameLogin());
        signInPassword.textProperty().bindBidirectional(loginViewModel.getPasswordLogin());
        loginWarning.textProperty().bind(loginViewModel.getErrorLogin());

    }


    public void signUpAnimation() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.9D));
        slide.setNode(this.layer2);
        slide.setToX(-370D);
        slide.play();
        this.SIgnUpLayer.setTranslateX(0);
        createAccountViewModel.playSignUpAnimation();
        loginViewModel.playSignUpAnimation();

    }

    public void signInAnimation() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.9D));
        slide.setNode(this.layer2);
        slide.setToX(0);
        slide.play();
        this.SIgnUpLayer.setTranslateX(0.0D);
        createAccountViewModel.playSignInAnimation();
        loginViewModel.playSignInAnimation();

    }

    @FXML
    private void signIn(ActionEvent event) {
      String temp= loginViewModel.login();
      if (temp.equals(Usertype.CUSTOMER.toString())){
          accountInformationModel.setUserNameFromLogin(signInUsername.getText());
            accountInformationModel.setCustomer();
          viewHandler.openCustomerMainView();
      }else if(temp.equals(Usertype.RECEPTIONIST.toString())){
          viewHandler.openReceptionistMainView();
      }
      else if (temp.equals(Usertype.ADMIN.toString())){
          viewHandler.openAdminMainView();
      }else if(temp.equals(Usertype.CLEANER.toString())){
          viewHandler.openClenerMainView();
      }
    }

    @FXML
    private void createAccount(ActionEvent event) {
        createAccountViewModel.createAccount();
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setContentText("Example");
//        alert.show();
    }

    @FXML   // this is the animation one
    private void signInPressed(ActionEvent event) {
        signInAnimation();
    }

    @FXML  // // this is the animation one
    private void signUpPressed(ActionEvent event) {
        signUpAnimation();
    }
}
