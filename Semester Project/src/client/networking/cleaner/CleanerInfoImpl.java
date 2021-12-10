package client.networking.cleaner;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.Cleaner;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class CleanerInfoImpl implements CleanerInfoClient{

    private Server server;

    public CleanerInfoImpl()
    {
        try{
            server = GetServer.getServerFromRmi();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void updateCleaner(Cleaner cleaner, String oldUserName) {
        try{
            server.getCleanerListServer().updateCleaner(cleaner, oldUserName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeCleaner(Cleaner cleaner) {
       try{
           server.getCleanerListServer().removeCleaner(cleaner);
       } catch (RemoteException e)
       {
           e.printStackTrace();
       }
    }

    @Override
    public Cleaner getCleaner(String username) {
        try {
            return server.getCleanerListServer().getCleaner(username);
        } catch (RemoteException e) {
            System.out.println("Cannot connect!");
            return null;
        }
    }

    @Override
    public ArrayList<Cleaner> getCleaners() {
        try {
            return server.getCleanerListServer().getCleaners();
        } catch (RemoteException e) {
            System.out.println("Cannot connect!");
            return null;
        }
    }
}
