package client.core;

import client.model.create.CreateImpl;
import client.model.create.CreateModel;
import client.model.customer.CustomerModel;
import client.model.customer.CustomerModelImpl;
import client.model.login.LoginModel;
import client.model.login.LoginModelImpl;
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

    public ModelFactory(ClientFactory clientFactory){
        this.clientFactory=clientFactory;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModel;
    }

    public CreateModel getCreateModel() {
        if (createModel == null) {
            createModel = new CreateImpl(clientFactory.getCreateClient());
        }
        return createModel;
    }

    public CustomerModel getCustomerModel() {
        if (customerModel == null) {
            customerModel = new CustomerModelImpl(clientFactory.getCustomerInfoClient());
        }
        return customerModel;
    }

    public RoomsModel getViewRoomsModel() {
        if (roomsModel == null) {
            roomsModel = new RoomsModelImpl(clientFactory.getViewRoomCLient());
        }
        return roomsModel;
    }

}
