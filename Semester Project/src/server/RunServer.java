package server;

import server.model.create.CreateHandler;
import server.model.create.CreateImpl;
import server.model.login.LoginHandler;
import server.model.login.LoginHandlerImpl;
import server.model.viewRooms.RoomHandler;
import server.model.viewRooms.RoomProxy;
import server.networking.ServerImpl;
import server.networking.login.CreateServerImpl;
import server.networking.login.LoginServerImpl;
import server.networking.viewRooms.RoomServerSide;
import shared.networking.serverInterfaces.CreateAccountServer;
import shared.networking.serverInterfaces.LoginServer;
import shared.networking.serverInterfaces.Server;
import shared.networking.serverInterfaces.RoomServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        LoginHandler loginHandler= new LoginHandlerImpl();
        LoginServer loginServer = new LoginServerImpl(loginHandler);

        CreateHandler createHandler = new CreateImpl();
        CreateAccountServer createAccountServer = new CreateServerImpl(createHandler);

        RoomHandler roomHandler = new RoomProxy();
        RoomServer roomServer = new RoomServerSide(roomHandler);

        Server server = new ServerImpl(loginServer,createAccountServer, roomServer);
        server.startServer();
    }
}
