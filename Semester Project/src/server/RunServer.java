package server;

import server.model.create.CreateHandler;
import server.model.create.CreateImpl;
import server.model.login.LoginHandler;
import server.model.login.LoginHandlerImpl;
import server.model.viewRooms.ViewRoomHandler;
import server.model.viewRooms.ViewRoomImpl;
import server.networking.ServerImpl;
import server.networking.login.CreateServerImpl;
import server.networking.login.LoginServerImpl;
import server.networking.viewRooms.ViewRoomServerSide;
import shared.networking.serverInterfaces.CreateAccountServer;
import shared.networking.serverInterfaces.LoginServer;
import shared.networking.serverInterfaces.Server;
import shared.networking.serverInterfaces.ViewRoomServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        LoginHandler loginHandler= new LoginHandlerImpl();
        LoginServer loginServer = new LoginServerImpl(loginHandler);

        CreateHandler createHandler = new CreateImpl();
        CreateAccountServer createAccountServer = new CreateServerImpl(createHandler);

        ViewRoomHandler viewRoomHandler = new ViewRoomImpl();
        ViewRoomServer viewRoomServer = new ViewRoomServerSide(viewRoomHandler);

        Server server = new ServerImpl(loginServer,createAccountServer,viewRoomServer);
        server.startServer();
    }
}
