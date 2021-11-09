package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements ViewController
{

  @FXML  private AnchorPane SIgnUpLayer;
  @FXML  private Label upCreateAccount;
  @FXML  private Label inSignIn;
  @FXML  private TextField upName;
  @FXML  private TextField upUsername;
  @FXML  private PasswordField  upPassword;
  @FXML  private Button signUpButton;
  @FXML  private TextField inUsername;
  @FXML  private Button SignInButton;
  @FXML  private PasswordField inPassword;
  @FXML  private AnchorPane layer2;
  @FXML  private Label upWelcome;
  @FXML  private Button SignInButtonInUp;
  @FXML  private Button signUpButton1;
  @FXML  private Label inText;
  @FXML  private Label inText2;

  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.upName.setVisible(true);
    this.upPassword.setVisible(true);
    this.upUsername.setVisible(true);
    this.inText.setVisible(false);
    this.inText2.setVisible(false);
    this.signUpButton1.setCancelButton(false);
    this.inPassword.setVisible(false);
    this.inSignIn.setVisible(false);
    this.inUsername.setVisible(false);

    this.viewModelFactory = vmf;
    this.viewHandler=vh;

  }

  public void btn2()
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

  public void btn(MouseEvent mouseEvent)
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


}
