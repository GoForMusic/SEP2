package client.core;


import client.networking.customer.CustomerInfoClient;
import client.networking.customer.CustomerInfoImpl;
import client.networking.login.LoginClient;
import client.networking.login.LoginClientImpl;
import client.networking.create.CreateClient;
import client.networking.create.CreateClientImpl;
import client.networking.rooms.RoomsClient;
import client.networking.rooms.RoomsClientImp;
import client.view.bookRooms.BookRoomViewModel;

/**
 * @author Sachin
 * The class that creates and stores all the clients
 */
public class ClientFactory {
    public ModelFactory modelFactory;
    private LoginClient loginClient;
    private CreateClient createClient;
    private RoomsClient roomsClient;
    private CustomerInfoClient customerInfoClient;




    public LoginClient getLoginClient() {
        if (loginClient == null) {
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }

    public CreateClient getCreateClient() {
        if (createClient == null) {
            createClient = new CreateClientImpl();
        }
        return createClient;
    }

    public RoomsClient getViewRoomCLient() {
        if (roomsClient == null) {
            roomsClient = new RoomsClientImp();
        }
        return roomsClient;
    }

    public CustomerInfoClient getCustomerInfoClient() {
        if (customerInfoClient == null) {
            customerInfoClient = new CustomerInfoImpl();
        }
        return customerInfoClient;
    }

    public RoomsClient getRoomsClient(){
        if(roomsClient==null){
            roomsClient = new RoomsClientImp();
        }
        return roomsClient;
    }



}
