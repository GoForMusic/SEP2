package shared.utils.roomType;


import java.io.Serializable;

public class RoomType implements Serializable {
    private String roomType;
    private int price;
    private String description;

    public RoomType(String roomType, int price, String description)
    {
        this.roomType = roomType;
        this.price = price;
        this.description = description;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getPrice(){
        return price;
    }

    public String getDescription()
    {
        return description;
    }
}


