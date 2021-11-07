package shared.networking.serverInterfaces;

import java.rmi.Remote;

public interface LoginServer extends Remote {
    boolean isConnectionPossible(User user);
    String  isLoginPossible(User user);

}
