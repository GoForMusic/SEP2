package shared.utils;

public class Room {
    private String type;
    private double price;
    private boolean isClean;

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

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
    public boolean isCleanOrNot(){
        return isClean;
    }
}
