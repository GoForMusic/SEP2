package shared.utils.chat;

import java.io.Serializable;

/**
 * @author Sachin Baral
 * Message object used for chatting
 */
public class Message implements Serializable {
    private String userNameSender;
    private String userNameReceiver;
    private String messageBody;

    /**
     * Constructor
     * @param userNameSender the username of the user sending the message
     * @param userNameReceiver the username of the user receiving the message
     * @param messageBody the message to send
     */
    public Message(String userNameSender, String userNameReceiver, String messageBody) {
        this.userNameSender = userNameSender;
        this.userNameReceiver = userNameReceiver;
        this.messageBody = messageBody;
    }

    public String getUserNameSender() {
        return userNameSender;
    }
    public String getMessageBody() {
        return messageBody;
    }

    public String getUserNameReceiver() {
        return userNameReceiver;
    }
}
