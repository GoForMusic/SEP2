package client.view.login.loginExisting;

import client.core.ModelFactory;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {
    private StringProperty errorLogin, usernameLogin, passwordLogin;
    private BooleanProperty signInScene;

    private ModelFactory modelFactory;

    public LoginViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        initializeAllProperties();
        signInScene.setValue(true);

    }

    private void initializeAllProperties() {
        errorLogin = new SimpleStringProperty();
        usernameLogin = new SimpleStringProperty();
        passwordLogin = new SimpleStringProperty();
        signInScene = new SimpleBooleanProperty();
    }

    public StringProperty getErrorLogin() {
        return errorLogin;
    }
    public StringProperty getUsernameLogin() {
        return usernameLogin;
    }
    public StringProperty getPasswordLogin() {
        return passwordLogin;
    }
    public BooleanProperty getSignInScene() {
        return signInScene;
    }
    public void playSignInAnimation(){
        signInScene.setValue(true);
    }
    public void playSignUpAnimation(){
        signInScene.setValue(false);
    }

    public String login() {
        return modelFactory.getLoginModel().isLoginPossible(usernameLogin.get(), passwordLogin.get());
    }
}
