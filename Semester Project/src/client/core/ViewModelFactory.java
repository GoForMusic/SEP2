package client.core;

import client.view.admin.createARoom.CreateARoomViewModel;
import client.view.admin.createAccount.AdminCreateAccountViewModel;
import client.view.bookRooms.BookRoomViewModel;
import client.view.cleaner.CleanerHomePageViewModel;
import client.view.chat.ChatViewModel;
import client.view.customer.doubleBedroom.DoubleBedRoomViewModel;
import client.view.customer.luxuryRoom.LuxuryRoomViewModel;
import client.view.customer.overview.overviewViewModel;
import client.view.customer.profile.AccountInformationModel;
import client.view.customer.singleRoom.SingleRoomViewModel;
import client.view.login.createAccount.CreateAccountViewModel;
import client.view.login.loginExisting.LoginViewModel;
import client.view.receptionist.CreateCustomerAccount.ReceptionistCreateCustomerAccountViewModel;
import client.view.receptionist.customerList.CustomerListViewModel;
import client.view.receptionist.editReservation.EditReservationViewModel;
import client.view.receptionist.searchReservation.SearchReservationViewModel;


/**
 * @author Sachin, Hiaml, Marian, Adrian, Emil
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
    private overviewViewModel overviewViewModel;
    private CleanerHomePageViewModel cleanerHomePageViewModel;
    private ChatViewModel chatViewModel;
    private  AccountInformationModel accountInformationModel;
    public CreateARoomViewModel createARoomViewModel;

    /**
     * A constructor that will initialize modelFactory
     */
    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    /**
     * A function that will return createAccountViewModel
     * @return createAccountViewModel
     */
    public CreateAccountViewModel getCreateAccountViewModel() {
        if (createAccountViewModel == null) {
            createAccountViewModel = new CreateAccountViewModel(modelFactory);
        }
        return createAccountViewModel;
    }

    /**
     * A function that will return loginViewModel
     * @return loginViewModel
     */
    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory);
        }
        return loginViewModel;
    }

    /**
     * A function that will return luxuryRoomViewModel
     * @return luxuryRoomViewModel
     */
    public LuxuryRoomViewModel getLuxuryRoomViewModel() {
        if (luxuryRoomViewModel == null) {
            luxuryRoomViewModel = new LuxuryRoomViewModel(modelFactory);
        }
        return luxuryRoomViewModel;
    }

    /**
     * A function that will return doubleBedRoomViewModel
     * @return doubleBedRoomViewModel
     */
    public DoubleBedRoomViewModel getDoubleBedRoomViewModel() {
        if (doubleBedRoomViewModel == null) {
            doubleBedRoomViewModel = new DoubleBedRoomViewModel(modelFactory);
        }
        return doubleBedRoomViewModel;
    }

    /**
     * A function that will return singleRoomViewModel
     * @return singleRoomViewModel
     */
    public SingleRoomViewModel getSingleRoomViewModel() {
        if (singleRoomViewModel == null) {
            singleRoomViewModel = new SingleRoomViewModel(modelFactory);
        }
        return singleRoomViewModel;
    }

    /**
     * A function that will return bookRoomViewModel
     * @return bookRoomViewModel
     */
    public BookRoomViewModel getDisplayRoomsViewModel() {
        if (bookRoomViewModel == null) {
            bookRoomViewModel = new BookRoomViewModel(modelFactory);
        }
        return bookRoomViewModel;
    }

    /**
     * A function that will return searchReservationViewModel
     * @return searchReservationViewModel
     */
    public SearchReservationViewModel getSearchReservationViewModel() {
        if (searchReservationViewModel == null) {
            searchReservationViewModel = new SearchReservationViewModel(modelFactory);
        }
        return searchReservationViewModel;
    }

    /**
     * A function that will return customerListViewModel
     * @return customerListViewModel
     */
    public CustomerListViewModel getCustomerListViewModel() {
        if (customerListViewModel==null){
            customerListViewModel= new CustomerListViewModel(modelFactory);
        }
        return customerListViewModel;
    }

    /**
     * A function that will return adminCreateAccountViewModel
     * @return adminCreateAccountViewModel
     */
    public AdminCreateAccountViewModel getAdminCreateAccountViewModel() {
        if (adminCreateAccountViewModel == null) {
            adminCreateAccountViewModel = new AdminCreateAccountViewModel(modelFactory);
        }
        return adminCreateAccountViewModel;
    }

    /**
     * A function that will return receptionistCreateCustomerAccountViewModel
     * @return receptionistCreateCustomerAccountViewModel
     */
    public ReceptionistCreateCustomerAccountViewModel getReceptionistCreateCustomerAccount() {
        if (receptionistCreateCustomerAccountViewModel == null) {
            receptionistCreateCustomerAccountViewModel = new ReceptionistCreateCustomerAccountViewModel(modelFactory);
        }
        return receptionistCreateCustomerAccountViewModel;
    }

    /**
     * A function that will return editReservationViewModel
     * @return editReservationViewModel
     */
    public EditReservationViewModel getEditReservationViewModel() {
        if (editReservationViewModel == null) {
            editReservationViewModel = new EditReservationViewModel(modelFactory);
        }
        return editReservationViewModel;
    }

    /**
     * A function that will return overviewViewModel
     * @return overviewViewModel
     */
    public overviewViewModel getOverviewViewModel(){
        if (overviewViewModel == null){
            overviewViewModel = new overviewViewModel(modelFactory);
        }
        return overviewViewModel;
    }

    /**
     * A function that will return cleanerHomePageViewModel
     * @return cleanerHomePageViewModel
     */
    public CleanerHomePageViewModel getCleanerHomePageViewModel() {
        if(cleanerHomePageViewModel ==null){
            cleanerHomePageViewModel =new CleanerHomePageViewModel(modelFactory);
        }
        return cleanerHomePageViewModel;
    }

    /**
     * A function that will return chatViewModel
     * @return chatViewModel
     */
    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null) {
            chatViewModel = new ChatViewModel(modelFactory);
        }
        return chatViewModel;
    }

    /**
     * A function that will return accountInformationModel
     * @return accountInformationModel
     */
    public AccountInformationModel getCustomerAccountInfoModel()
    {
        if(accountInformationModel == null){
            accountInformationModel = new AccountInformationModel(modelFactory);
        }
        return accountInformationModel ;
    }

    /**
     * A function that will return createARoomViewModel
     * @return createARoomViewModel
     */
    public CreateARoomViewModel getCreateARoomViewModel(){
        if (createARoomViewModel == null){
            createARoomViewModel = new CreateARoomViewModel(modelFactory);
        }
        return createARoomViewModel;
    }
}
