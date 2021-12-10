package client.core;

import client.model.chat.ChatModel;
import client.model.chat.ChatModelImpl;
import client.model.cleaner.CleanerModel;
import client.model.cleaner.CleanerModelImpl;
import client.model.create.CreateImpl;
import client.model.create.CreateModel;
import client.model.customer.CustomerModel;
import client.model.customer.CustomerModelImpl;
import client.model.login.LoginModel;
import client.model.login.LoginModelImpl;
import client.model.receptionist.ReceptionistModel;
import client.model.receptionist.ReceptionistModelImpl;
import client.model.roomType.EditRoomTypeImpl;
import client.model.roomType.EditRoomTypeModel;
import client.model.rooms.RoomsModel;
import client.model.rooms.RoomsModelImpl;

/**
 * @author Sachin Baral
 * The class that creates and stores all models
 */
public class ModelFactory {
    private ClientFactory clientFactory;
    private LoginModel loginModel;
    private CreateModel createModel;
    private RoomsModel roomsModel;
    private CustomerModel customerModel;
    private ChatModel chatModel;
    private CleanerModel cleanerListModel;
    private ReceptionistModel receptionistModel;
    private EditRoomTypeModel editRoomTypeModel;

    public ModelFactory(ClientFactory clientFactory){
        this.clientFactory=clientFactory;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = new LoginModelImpl(clientFactory.getLoginClient(),clientFactory.getChatClient());
        }
        return loginModel;
    }

    public CreateModel getCreateModel() {
        if (createModel == null) {
            createModel = new CreateImpl(clientFactory.getCreateClient());
        }
        return createModel;
    }

    public RoomsModel getRoomsModel() {
        if (roomsModel == null) {
            roomsModel = new RoomsModelImpl(clientFactory.getViewRoomCLient());
        }
        return roomsModel;
    }

    public CustomerModel getCustomerModel() {
        if (customerModel==null){
            customerModel= new CustomerModelImpl(clientFactory.getCustomerInfoClient());
        }
        return customerModel;
    }

    public ChatModel getChatModel() {
        if (chatModel == null) {
            chatModel = new ChatModelImpl(clientFactory.getChatClient());
        }
        return chatModel;
    }

    public CleanerModel getCleanerModel()
    {
        if (cleanerListModel == null)
        {
            cleanerListModel = new CleanerModelImpl((clientFactory.getCleanerInfoClient()));
        }
        return cleanerListModel;
    }

    public ReceptionistModel getReceptionistModel()
    {
        if(receptionistModel == null)
        {
            receptionistModel = new ReceptionistModelImpl((clientFactory.getReceptionistInfoClient()));

        }
        return receptionistModel;
    }

    public EditRoomTypeModel getEditRoomTypeModel()
    {
        if(editRoomTypeModel == null)
        {
            editRoomTypeModel = new EditRoomTypeImpl(clientFactory.getEditRoomTypeClient());
        }
        return editRoomTypeModel;
    }
}
