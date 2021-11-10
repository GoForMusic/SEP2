package client.core;

import client.view.login.createAccount.CreateAccountViewModel;
import client.view.login.loginExisting.LoginViewModel;

/**
 * @author Sachin Baral
 * Creates and stores all the view models
 */
public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        if (createAccountViewModel == null) {
            createAccountViewModel = new CreateAccountViewModel(modelFactory);
        }
        return createAccountViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory);
        }
        return loginViewModel;
    }
}
