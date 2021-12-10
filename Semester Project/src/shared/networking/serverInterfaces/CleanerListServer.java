package shared.networking.serverInterfaces;

import shared.utils.User.Cleaner;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CleanerListServer extends Remote {
    void updateCleaner(Cleaner cleaner, String oldUsername) throws RemoteException;
    void removeCleaner(Cleaner cleaner) throws RemoteException;
    Cleaner getCleaner(String username) throws RemoteException;
    ArrayList<Cleaner> getCleaners() throws RemoteException;

}
