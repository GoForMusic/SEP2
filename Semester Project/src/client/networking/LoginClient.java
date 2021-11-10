package client.networking;

import shared.utils.User;

/**
 * The client class that deals with the login
 */
public interface LoginClient {

    String isLoginPossible(User user);
}
