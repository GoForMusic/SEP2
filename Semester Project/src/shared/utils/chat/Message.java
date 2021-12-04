package shared.utils.chat;

public class Message {
    private String userName;
    private boolean isSenderReceptionist;
    private String messageBody;

    public Message(String userName, boolean isSenderReceptionist, String messageBody) {
        this.userName = userName;
        this.isSenderReceptionist = isSenderReceptionist;
        this.messageBody = messageBody;
    }
}
