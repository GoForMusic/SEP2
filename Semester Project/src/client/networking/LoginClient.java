package client.networking;

import shared.utils.User;

public interface LoginClient {
    boolean isConnectionPossible(String username);
    String isLoginPossible(User user);
}
