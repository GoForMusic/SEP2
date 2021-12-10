package client.core;

import client.model.cleaner.CleanerModel;
import client.model.receptionist.ReceptionistModel;
import client.networking.chat.ChatClient;
import client.networking.chat.ChatClientImpl;
import client.networking.cleaner.CleanerInfoClient;
import client.networking.cleaner.CleanerInfoImpl;
import client.networking.customer.CustomerInfoClient;
import client.networking.customer.CustomerInfoImpl;
import client.networking.login.LoginClient;
import client.networking.login.LoginClientImpl;
import client.networking.create.CreateClient;
import client.networking.create.CreateClientImpl;
import client.networking.receptionist.ReceptionistInfoClient;
import client.networking.receptionist.ReceptionistInfoImpl;
import client.networking.roomType.RoomTypeInfoClient;
import client.networking.roomType.RoomTypeInfoImpl;
import client.networking.rooms.RoomsClient;
import client.networking.rooms.RoomsClientImp;
import shared.utils.User.Receptionist;

/**
 * @author Sachin
 * The class that creates and stores all the clients
 */
public class ClientFactory {
    private LoginClient loginClient;
    private ChatClient chatClient;
    private CreateClient createClient;
    private RoomsClient roomsClient;
    private CleanerInfoClient cleanerInfoClient;
    private ReceptionistInfoClient receptionistInfoClient;
    private CustomerInfoClient customerInfoClient;
    private RoomTypeInfoClient roomTypeInfoClient;
    LoginClient getLoginClient() {
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

    public CleanerInfoClient getCleanerInfoClient()
    {
        if (cleanerInfoClient == null)
        {
            cleanerInfoClient = new CleanerInfoImpl();
        }
       return cleanerInfoClient;
    }

    public ReceptionistInfoClient getReceptionistInfoClient()
    {
        if(receptionistInfoClient == null)
        {
            receptionistInfoClient = new ReceptionistInfoImpl();
        }
        return receptionistInfoClient;
    }

    public RoomTypeInfoClient getEditRoomTypeClient() {
        if(roomTypeInfoClient == null)
        {
            roomTypeInfoClient = new RoomTypeInfoImpl();
        }
        return roomTypeInfoClient;
    }
}
