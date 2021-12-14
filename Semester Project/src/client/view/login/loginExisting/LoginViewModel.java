package client.view.login.loginExisting;

import client.core.ModelFactory;
import client.model.login.LoginModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.utils.Request;
import shared.utils.User.User;

/**
 * @author Sachin
 * A class that will use login details from database to GUI
 */
public class LoginViewModel {
    private StringProperty errorLogin, usernameLogin, passwordLogin;
    private BooleanProperty signInScene;
    private LoginModel loginModel;

    /**
     * Constructor
     * @param modelFactory
     */
    public LoginViewModel(ModelFactory modelFactory) {
        this.loginModel=modelFactory.getLoginModel();
        initializeAllProperties();
        signInScene.setValue(true);

    }

    /**
     * A method that will initialize everthing
     */
    private void initializeAllProperties() {
        errorLogin = new SimpleStringProperty();
        usernameLogin = new SimpleStringProperty();
        passwordLogin = new SimpleStringProperty();
        signInScene = new SimpleBooleanProperty();
    }

    /**
     * A method that will return error message
     * @return error message
     */
    public StringProperty getErrorLogin() {
        return errorLogin;
    }

    /**
     * A method that will return username
     * @return username
     */
    public StringProperty getUsernameLogin() {
        return usernameLogin;
    }

    /**
     * A method that will return password
     * @return password
     */
    public StringProperty getPasswordLogin() {
        return passwordLogin;
    }

    /**
     * A method that will return sign-in scene
     * @return sign-in scene
     */
    public BooleanProperty getSignInScene() {
        return signInScene;
    }

    /**
     * A method that will play sign-in animation
     */
    public void playSignInAnimation() {
        signInScene.setValue(true);
    }

    /**
     * A method that will play sign-up animation
     */
    public void playSignUpAnimation() {
        signInScene.setValue(false);
    }

    /**
     * A method that will login
     * @return a message
     */
    public String login() {
        //  System.out.println(usernameLogin.get());
        if (usernameLogin.get() == null || usernameLogin.get().isEmpty()) {
            errorLogin.set("Username cannot be empty !!");
            return "";
        } else if (passwordLogin.get() == null || passwordLogin.get().isEmpty()) {
            errorLogin.set("Password cannot be empty !!");
            return "";
        } else {
            Request temp = loginModel.login(usernameLogin.get(), passwordLogin.get());
            if (temp.getObject() != null) {
                loginModel.setUsername(((User) temp.getObject()).getUserName());
                loginModel.setUserType(temp.getType());
            }
            errorLogin.set(temp.getType());
            return temp.getType();
        }
    }


    /**
     * A method that will clean the fields
     */
    private void clearAll() {
        usernameLogin.set(null);
        passwordLogin.set(null);
    }

}
