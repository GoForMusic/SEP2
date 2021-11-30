package client.core;

import client.view.customer.bookRooms.BookRoomViewModel;
import client.view.customer.doubleBedroom.DoubleBedRoomViewModel;
import client.view.customer.luxuryRoom.LuxuryRoomViewModel;
import client.view.customer.singleRoom.SingleRoomViewModel;
import client.view.login.createAccount.CreateAccountViewModel;
import client.view.login.loginExisting.LoginViewModel;


/**
 * @author Sachin Baral
 * Creates and stores all the view models
 */
public class ViewModelFactory {
    private BookRoomViewModel bookRoomViewModel;
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private LuxuryRoomViewModel luxuryRoomViewModel;
    private DoubleBedRoomViewModel doubleBedRoomViewModel;
    private SingleRoomViewModel singleRoomViewModel;

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

    public LuxuryRoomViewModel getLuxuryRoomViewModel() {
        if (luxuryRoomViewModel == null) {
            luxuryRoomViewModel = new LuxuryRoomViewModel(modelFactory);
        }
        return luxuryRoomViewModel;
    }

    public DoubleBedRoomViewModel getDoubleBedRoomViewModel() {
        if (doubleBedRoomViewModel == null) {
            doubleBedRoomViewModel = new DoubleBedRoomViewModel(modelFactory);
        }
        return doubleBedRoomViewModel;
    }

    public SingleRoomViewModel getSingleRoomViewModel() {
        if (singleRoomViewModel == null) {
            singleRoomViewModel = new SingleRoomViewModel(modelFactory);
        }
        return singleRoomViewModel;
    }

    public BookRoomViewModel getDisplayRoomsViewModel() {
        if (bookRoomViewModel == null) {
            bookRoomViewModel = new BookRoomViewModel(modelFactory);
        }
        return bookRoomViewModel;
    }
}
