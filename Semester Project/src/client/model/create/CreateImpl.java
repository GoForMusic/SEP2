package client.model.create;

import client.networking.create.CreateClient;

public class CreateImpl implements CreateModel{
    public CreateClient client;

    public CreateImpl(CreateClient client) {
        this.client = client;
    }

    @Override
    public void isConnectionPossible(String username) {
        client.isConnectionPossible(username);

    }

    @Override
    public void addUser(String firstname, String lastname, String username, String password) {

    }
}
