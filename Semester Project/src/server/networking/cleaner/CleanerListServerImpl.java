package server.networking.cleaner;

import server.model.cleaner.CleanerListHandler;
import shared.networking.serverInterfaces.CleanerListServer;
import shared.utils.User.Cleaner;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CleanerListServerImpl implements CleanerListServer {

    private CleanerListHandler cleanerListHandler;

    public CleanerListServerImpl(CleanerListHandler cleanerListHandler) throws RemoteException{
        this.cleanerListHandler = cleanerListHandler;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void updateCleaner(Cleaner cleaner, String oldUsername) throws RemoteException {
        cleanerListHandler.updateCleaner(cleaner, oldUsername);
    }

    @Override
    public void removeCleaner(Cleaner cleaner) throws RemoteException {
        cleanerListHandler.removeCleaner(cleaner);
    }

    @Override
    public Cleaner getCleaner(String username) throws RemoteException {
        return cleanerListHandler.getCleaner(username);
    }

    @Override
    public ArrayList<Cleaner> getCleaners() throws RemoteException {
        return cleanerListHandler.getCleaners();
    }
}
