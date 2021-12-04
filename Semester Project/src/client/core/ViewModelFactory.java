package client.core;

import client.view.admin.createAccount.AdminCreateAccountViewModel;
import client.view.bookRooms.BookRoomViewModel;
import client.view.chat.ChatViewModel;
import client.view.customer.doubleBedroom.DoubleBedRoomViewModel;
import client.view.customer.luxuryRoom.LuxuryRoomViewModel;
import client.view.customer.singleRoom.SingleRoomViewModel;
import client.view.login.createAccount.CreateAccountViewModel;
import client.view.login.loginExisting.LoginViewModel;
import client.view.receptionist.CreateCustomerAccount.ReceptionistCreateCustomerAccountViewModel;
import client.view.receptionist.customerList.CustomerListViewModel;
import client.view.receptionist.editReservation.EditReservationViewModel;
import client.view.receptionist.searchReservation.SearchReservationViewModel;


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
    private SearchReservationViewModel searchReservationViewModel;
    private CustomerListViewModel customerListViewModel;
    private AdminCreateAccountViewModel adminCreateAccountViewModel;
    private ReceptionistCreateCustomerAccountViewModel receptionistCreateCustomerAccountViewModel;
    private EditReservationViewModel editReservationViewModel;
    private ChatViewModel chatViewModel;

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

    public SearchReservationViewModel getSearchReservationViewModel() {
        if (searchReservationViewModel == null) {
            searchReservationViewModel = new SearchReservationViewModel(modelFactory);
        }
        return searchReservationViewModel;
    }

    public CustomerListViewModel getCustomerListViewModel() {
        if (customerListViewModel==null){
            customerListViewModel= new CustomerListViewModel(modelFactory);
        }
        return customerListViewModel;
    }

    public AdminCreateAccountViewModel getAdminCreateAccountViewModel() {
        if (adminCreateAccountViewModel == null) {
            adminCreateAccountViewModel = new AdminCreateAccountViewModel(modelFactory);
        }
        return adminCreateAccountViewModel;
    }

    public ReceptionistCreateCustomerAccountViewModel getReceptionistCreateCustomerAccount() {
        if (receptionistCreateCustomerAccountViewModel == null) {
            receptionistCreateCustomerAccountViewModel = new ReceptionistCreateCustomerAccountViewModel(modelFactory);
        }
        return receptionistCreateCustomerAccountViewModel;
    }

    public EditReservationViewModel getEditReservationViewModel() {
        if (editReservationViewModel == null) {
            editReservationViewModel = new EditReservationViewModel(modelFactory);
        }
        return editReservationViewModel;
    }

    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null) {
            chatViewModel = new ChatViewModel(modelFactory);
        }
        return chatViewModel;
    }
}
