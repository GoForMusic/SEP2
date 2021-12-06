package client.core;

import client.networking.chat.ChatClient;
import client.networking.chat.ChatClientImpl;
import client.networking.customer.CustomerInfoClient;
import client.networking.customer.CustomerInfoImpl;
import client.networking.login.LoginClient;
import client.networking.login.LoginClientImpl;
import client.networking.create.CreateClient;
import client.networking.create.CreateClientImpl;
import client.networking.rooms.RoomsClient;
import client.networking.rooms.RoomsClientImp;

import java.rmi.RemoteException;

/**
 * @author Sachin
 * The class that creates and stores all the clients
 */
public class ClientFactory {
    private LoginClient loginClient;
    private ChatClient chatClient;
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

    public ChatClient getChatClient() {
        if (chatClient == null) {
                chatClient = new ChatClientImpl();
        }
        return chatClient;
    }
}
