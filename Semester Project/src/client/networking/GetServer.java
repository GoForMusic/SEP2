package client.networking;

import shared.networking.serverInterfaces.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Adrian, Sachin, Emil, Marian, Himal
 * A class that will initialize the RMI protocol between Client and server
 */
public class GetServer {
    public static Server getServerFromRmi(){
        Registry registry=null;
        Server server = null;//
        try {
            registry = LocateRegistry.getRegistry(1099);
            server = (Server) registry.lookup("Server");

        } catch (RemoteException e) {
//            e.printStackTrace();
            System.out.println("Cannot connect to server");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return server;
    }
}
