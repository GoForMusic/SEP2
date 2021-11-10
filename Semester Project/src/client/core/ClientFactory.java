package client.core;

import client.model.viewRooms.ViewRoomsModel;
import client.networking.login.LoginClient;
import client.networking.login.LoginClientImpl;
import client.networking.create.CreateClient;
import client.networking.create.CreateClientImpl;
import client.networking.viewRooms.ViewRoomClient;
import client.networking.viewRooms.ViewRoomImp;

/**
 * @author Sachin
 * The class that creates and stores all the clients
 */
public class ClientFactory {
    private LoginClient loginClient;
    private CreateClient createClient;
    private ViewRoomClient viewRoomClient;



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

    public ViewRoomClient getViewRoomCLient() {
        if (viewRoomClient == null) {
            viewRoomClient = new ViewRoomImp();
        }
        return viewRoomClient;
    }
}
