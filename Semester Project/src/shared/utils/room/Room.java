package shared.utils.room;

import java.io.Serializable;

/**
 * @author Adrian Militaru , Sachin Baral
 * @version 2
 * The object room
 */
public class Room implements Serializable {
    private String name;
    private String type;
    private boolean isClean;

    /**
     * Constructor that creates a room
     * @param type type of room
     */
    public Room(String name,String type) {
        this.name=name;
        this.type = type;
        isClean=true;
    }

    public void setClean(boolean clean) {
        isClean = clean;
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
