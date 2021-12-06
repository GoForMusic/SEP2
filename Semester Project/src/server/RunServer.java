package server;

import server.model.create.CreateHandler;
import server.model.create.CreateImpl;
import server.model.customer.CustomerListHandler;
import server.model.customer.CustomerListHandlerImpl;
import server.model.login.LoginHandler;
import server.model.login.LoginHandlerImpl;
import server.model.rooms.RoomHandler;
import server.model.rooms.RoomProxy;
import server.networking.ServerImpl;
import server.networking.customer.CustomerListServerImpl;
import server.networking.login.CreateServerImpl;
import server.networking.login.LoginServerImpl;
import server.networking.viewRooms.RoomServerSide;
import shared.networking.serverInterfaces.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer  {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        LoginHandler loginHandler= new LoginHandlerImpl();
        LoginServer loginServer = new LoginServerImpl(loginHandler);

        CreateHandler createHandler = new CreateImpl();
        CreateAccountServer createAccountServer = new CreateServerImpl(createHandler);

        RoomHandler roomHandler = new RoomProxy();
        RoomServer roomServer = new RoomServerSide(roomHandler);

        CustomerListHandler customerListHandler = new CustomerListHandlerImpl();
        CustomerListServer customerListServer = new CustomerListServerImpl(customerListHandler);

        Server server = new ServerImpl(loginServer,createAccountServer, roomServer,customerListServer);
        server.startServer();
    }
}
