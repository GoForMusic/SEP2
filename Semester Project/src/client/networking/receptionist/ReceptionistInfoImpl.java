package client.networking.receptionist;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.Receptionist;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ReceptionistInfoImpl implements ReceptionistInfoClient{

    private Server server;

    public ReceptionistInfoImpl()
    {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateReceptionist(Receptionist receptionist, String oldUsername) {
        try {
            server.getReceptionistListServer().updateReceptionist(receptionist,oldUsername);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeReceptionist(Receptionist receptionist) {
        try {
            server.getReceptionistListServer().removeReceptionist(receptionist);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Receptionist getReceptionist(String username) {
        try {
            return server.getReceptionistListServer().getReceptionist(username);
        } catch (RemoteException e) {
            System.out.println("Cannot connect!");
            return null;
        }
    }

    @Override
    public ArrayList<Receptionist> getReceptionists() {
        try {
            return server.getReceptionistListServer().getReceptionists();
        } catch (RemoteException e) {
            System.out.println("Cannot connect!");
            return null;
        }
    }
}
