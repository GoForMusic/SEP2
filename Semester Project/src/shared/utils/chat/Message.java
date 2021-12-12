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

    /**
     * A function that will return username sender
     * @return username sender
     */
    public String getUserNameSender() {
        return userNameSender;
    }

    /**
     * A function that will return message body
     * @return message body
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * A function that will return username receiver
     * @return username receiver
     */
    public String getUserNameReceiver() {
        return userNameReceiver;
    }
}
