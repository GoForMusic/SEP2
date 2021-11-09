package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.login.loginExisting.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements ViewController
{

  @FXML  private AnchorPane SIgnUpLayer;
  @FXML  private Label createTopic;
  @FXML  private Label inSignIn;
  @FXML  private TextField signUpFirstName;
  @FXML  private TextField signUpLastName;
  @FXML  private TextField signUpUsername;
  @FXML  private PasswordField  signUpPassword;
  @FXML  private Button signUpButton;
  @FXML  private TextField signInUsername;
  @FXML  private Button signInButton;
  @FXML  private PasswordField signInPassword;
  @FXML  private AnchorPane layer2;
  @FXML  private Label upWelcome;
  @FXML  private Label upWelcome2;
  @FXML  private Button SignInButtonInUp;
  @FXML  private Button signUpButton1;
  @FXML  private Label inText;
  @FXML  private Label inText2;

  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private LoginViewModel loginViewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler=vh;
    this.viewModelFactory=vmf;
    loginViewModel= viewModelFactory.getLoginViewModel();
    bindEverythingwithLogin();
    bindEverythingwithSignUp();


  }

  private void bindEverythingwithSignUp() {
    
  }

  private void bindEverythingwithLogin(){
    inSignIn.visibleProperty().bind(loginViewModel.getSignInScene());
    signInUsername.visibleProperty().bind(loginViewModel.getSignInScene());
    signInPassword.visibleProperty().bind(loginViewModel.getSignInScene());
    signUpButton.visibleProperty().bind(loginViewModel.getSignInScene());
    inText.visibleProperty().bind(loginViewModel.getSignInScene());
    signUpButton1.visibleProperty().bind(loginViewModel.getSignInScene());
  }

  /*
  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.upName.setVisible(true);
    this.upPassword.setVisible(true);
    this.upUsername.setVisible(true);
    this.inText.setVisible(false);
    this.inText2.setVisible(false);
    this.signUpButton1.setCancelButton(false);
    this.signInPassword.setVisible(false);
    this.inSignIn.setVisible(false);
    this.signInPassword.setVisible(false);

    this.viewModelFactory = vmf;
    this.viewHandler=vh;

  }

  public void signUpAnimation()
  {
    TranslateTransition slide = new TranslateTransition();
    slide.setDuration(Duration.seconds(0.9D));
    slide.setNode(this.layer2);
    slide.setToX(-370D);
    slide.play();
    this.SIgnUpLayer.setTranslateX(0);
    this.SignInButton.setVisible(false);
    this.SignInButtonInUp.setVisible(true);
    this.upName.setVisible(true);
    this.upPassword.setVisible(true);
    this.upUsername.setVisible(true);
    this.inText.setVisible(false);
    this.inText2.setVisible(false);
    this.signUpButton1.setVisible(false);
    this.inPassword.setVisible(false);
    this.inSignIn.setVisible(true);
    this.inUsername.setVisible(true);
    this.upWelcome.setVisible(true);
    this.upCreateAccount.setVisible(true);
    this.signUpButton.setVisible(true);
    slide.setOnFinished((e) -> {
    });
  }

  public void signInAnimation()
  {
    TranslateTransition slide = new TranslateTransition();
    slide.setDuration(Duration.seconds(0.9D));
    slide.setNode(this.layer2);
    slide.setToX(0);
    slide.play();
    this.SIgnUpLayer.setTranslateX(0.0D);
    this.SignInButton.setVisible(true);
    this.SignInButtonInUp.setVisible(false);
    this.upName.setVisible(true);
    this.upPassword.setVisible(true);
    this.upUsername.setVisible(true);
    this.inText.setVisible(true);
    this.inText2.setVisible(true);
    this.signUpButton1.setVisible(true);
    this.inPassword.setVisible(true);
    this.inSignIn.setVisible(true);
    this.inUsername.setVisible(true);
    this.upWelcome.setVisible(false);
    this.upCreateAccount.setVisible(true);
    this.signUpButton.setVisible(true);


    slide.setOnFinished((e) -> {
    });
  }

*/
}
