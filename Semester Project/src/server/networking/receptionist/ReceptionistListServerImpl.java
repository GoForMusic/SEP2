package server.networking.receptionist;

import server.model.receptionist.ReceptionistListHandler;
import shared.networking.serverInterfaces.ReceptionistListServer;
import shared.utils.User.Receptionist;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReceptionistListServerImpl implements ReceptionistListServer {

    private ReceptionistListHandler receptionistListHandler;

    public ReceptionistListServerImpl(ReceptionistListHandler receptionistListHandler) throws RemoteException {
        this.receptionistListHandler = receptionistListHandler;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void updateReceptionist(Receptionist receptionist, String oldUsername) throws RemoteException {
        receptionistListHandler.updateReceptionist(receptionist, oldUsername);

    }

    @Override
    public void removeReceptionist(Receptionist receptionist) throws RemoteException {
        receptionistListHandler.removeReceptionist(receptionist);
    }

    @Override
    public Receptionist getReceptionist(String username) throws RemoteException {
        return receptionistListHandler.getReceptionist(username);
    }

    @Override
    public ArrayList<Receptionist> getReceptionists() throws RemoteException {
        return receptionistListHandler.getReceptionists();
    }
}
