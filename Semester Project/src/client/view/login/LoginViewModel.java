package client.view.login;

import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {
    private StringProperty errorLogin,  usernameLogin, passwordLogin;
    private StringProperty errorCreate, usernameCreate, passwordCreate,firstNameCreate,lastNameCreate;

    private ModelFactory modelFactory;

    public LoginViewModel(ModelFactory modelFactory){
        this.modelFactory= modelFactory;
        errorLogin= new SimpleStringProperty();
        firstNameCreate= new SimpleStringProperty();
        lastNameCreate= new SimpleStringProperty();
        usernameLogin= new SimpleStringProperty();
        passwordLogin= new SimpleStringProperty();
        errorCreate= new SimpleStringProperty();
        usernameCreate= new SimpleStringProperty();
        passwordCreate= new SimpleStringProperty();
    }
    public StringProperty getErrorLogin(){
        return errorLogin;
    }
    public StringProperty getFirstNameCreate(){
        return firstNameCreate;
    }
    public StringProperty getLastNameCreate(){
        return lastNameCreate;
    }
    public StringProperty getUsernameLogin(){
        return usernameLogin;
    }
    public StringProperty getPasswordLogin(){
        return passwordLogin;
    }
    public StringProperty getErrorCreate(){
        return errorCreate;
    }
    public StringProperty getUsernameCreate(){
        return usernameCreate;
    }
    public StringProperty getPasswordCreate(){
        return passwordCreate;
    }

}
