package shared.networking.serverInterfaces;

import shared.utils.User.Receptionist;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ReceptionistListServer extends Remote {
    void updateReceptionist(Receptionist receptionist, String oldUsername) throws RemoteException;
    void removeReceptionist(Receptionist receptionist) throws RemoteException;
    Receptionist getReceptionist(String username) throws RemoteException;
    ArrayList<Receptionist> getReceptionists() throws RemoteException;
}
