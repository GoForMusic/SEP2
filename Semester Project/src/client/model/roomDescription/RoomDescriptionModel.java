package client.model.roomDescription;

/**
 * @author Sachin Baral
 * The model that deals with sending and receiving datas from client regarding the Room description...
 */
public interface RoomDescriptionModel {
    /**
     * Gets the description from client
     * @param category the room category of which the description is needed..
     * @return the description from the client...
     */
    String getDescription(String category);

    /**
     * Gets the price from the client
     * @param category the category of the room to  get the price from client
     * @return the price of the category
     */
    double getPrice(String category);
}
