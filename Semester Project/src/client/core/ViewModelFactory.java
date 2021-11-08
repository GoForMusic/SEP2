package client.core;

import client.view.login.LoginViewModel;
import com.sun.webkit.Timer;

public class ViewModelFactory {
    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory){
        this.modelFactory=modelFactory;
    }

    private LoginViewModel loginViewModel;
    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory);
        }
        return loginViewModel;
    }
}
