package client.view.login.loginExisting;

import client.core.ModelFactory;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.utils.Request;

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

    public void playSignInAnimation() {
        signInScene.setValue(true);
    }

    public void playSignUpAnimation() {
        signInScene.setValue(false);
    }

    public String login() {
        //  System.out.println(usernameLogin.get());
        if (usernameLogin.get().isEmpty()) {
            return "Username cannot be empty !!";
        } else if (passwordLogin.get().isEmpty()) {
            return "Password cannot be empty !!";
        } else {
            Request temp = modelFactory.getLoginModel().login(usernameLogin.get(), passwordLogin.get());
            errorLogin.set(temp.getType());
            return temp.getType();
        }
    }


    private void clearAll() {
        usernameLogin.set(null);
        passwordLogin.set(null);
    }

}
