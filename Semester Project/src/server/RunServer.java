package server;

import server.model.create.CreateHandler;
import server.model.create.CreateImpl;
import server.model.login.LoginHandler;
import server.model.login.LoginHandlerImpl;
import server.networking.ServerImpl;
import server.networking.login.CreateServerImpl;
import server.networking.login.LoginServerImpl;
import shared.networking.serverInterfaces.CreateAccountServer;
import shared.networking.serverInterfaces.LoginServer;
import shared.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        LoginHandler loginHandler= new LoginHandlerImpl();
        LoginServer loginServer = new LoginServerImpl(loginHandler);

        CreateHandler createHandler = new CreateImpl();
        CreateAccountServer createAccountServer = new CreateServerImpl(createHandler);

        Server server = new ServerImpl(loginServer,createAccountServer);
        server.startServer();

    }
}
