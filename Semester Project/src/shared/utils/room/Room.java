package shared.utils.room;

import java.io.Serializable;

/**
 * @author Sachin Baral
 * The object room
 */
public class Room implements Serializable {
    private String type;
    private double price;
    private boolean isClean;

    /**
     * Constructor that creates a room
     * @param type type of room
     * @param price the price per night
     */
    public Room(String type, double price) {
        this.type = type;
        this.price = price;
        isClean=true;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    /**
     *
     * @return the price of the room per night
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return the type of the room
     */
     public String getType() {
        return type;
    }

    /**
     *
     * @return true if the room is clean , false if not
     */
    public boolean isCleanOrNot(){
        return isClean;
    }
}
