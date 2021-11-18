package shared.utils.room;

import java.io.Serializable;

/**
 * @author Sachin Baral
 * The object room
 */
public class Room implements Serializable {
    private String category;
    private boolean isClean;

    /**
     * Constructor that creates a room
     * @param category type of room
     */
    public Room(String category) {
        this.category = category;
        isClean=true;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }



    /**
     *
     * @return the type of the room
     */
     public String getCategory() {
        return category;
    }

    /**
     *
     * @return true if the room is clean , false if not
     */
    public boolean isCleanOrNot(){
        return isClean;
    }
}
