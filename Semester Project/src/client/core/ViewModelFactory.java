package client.core;

import client.view.login.createAccount.CreateAccountViewModel;
import client.view.login.loginExisting.LoginViewModel;
import client.view.viewRooms.ViewRoomsViewModel;

/**
 * @author Sachin Baral
 * Creates and stores all the view models
 */
public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private ViewRoomsViewModel viewRoomsViewModel;

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

    public ViewRoomsViewModel getViewRoomsViewModel() {
        if (viewRoomsViewModel == null) {
            viewRoomsViewModel = new ViewRoomsViewModel(modelFactory);
        }
        return viewRoomsViewModel;
    }
}
