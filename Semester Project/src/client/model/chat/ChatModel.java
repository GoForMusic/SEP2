package client.model.chat;

import shared.utils.Request;

public interface ChatModel {
    Request sendMessage(String messa);
}
