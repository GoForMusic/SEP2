package server.model.viewRooms;

import shared.utils.room.RoomType;

import javax.print.attribute.standard.MediaSize;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

public class ViewRoomProxy implements ViewRoomHandler {

    private ViewRoomHandler viewRoomHandler;
    private String descriptionSingle, descriptionDouble, descriptionLuxury;
    private String priceSingle, priceDouble, priceLuxury;

    public ViewRoomProxy() {
        viewRoomHandler = new ViewRoomImpl();
    }
    @Override
    public void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        viewRoomHandler.searchRoom(dateFrom,dateTo,roomType);
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        if (roomType.toString().equals(RoomType.SINGLE.toString())) {
            if (descriptionSingle == null || descriptionSingle.equals("")) {
                descriptionSingle = viewRoomHandler.getDescriptionByCategory(RoomType.SINGLE);
            }
            return descriptionSingle;
        } else if (roomType.toString().equals(RoomType.DOUBLE.toString())) {
            if (descriptionDouble == null || descriptionDouble.equals("")) {
                descriptionDouble = viewRoomHandler.getDescriptionByCategory(RoomType.DOUBLE);
            }
            return descriptionDouble;
        } else if (roomType.toString().equals(RoomType.LUXURY.toString())) {
            if (descriptionLuxury == null || descriptionLuxury.equals("")) {
                descriptionLuxury = viewRoomHandler.getDescriptionByCategory(RoomType.LUXURY);
            }
            return descriptionLuxury;
        }
        else
        {
           return "Error";
            //return "Error in database.. maybe invalid input";
        }

    }



    @Override
    public String getPriceByCategory(RoomType roomType) {
        if (roomType.equals(RoomType.SINGLE)) {
            if (priceSingle == null || priceSingle.equals("")) {
                priceSingle = viewRoomHandler.getPriceByCategory(RoomType.SINGLE);
            }
            return priceSingle;
        } else if (roomType.equals(RoomType.DOUBLE)) {
            if (priceDouble == null || priceDouble.equals("")) {
                priceDouble = viewRoomHandler.getPriceByCategory(RoomType.DOUBLE);
            }
            return priceDouble;
        } else if (roomType.equals(RoomType.LUXURY)) {
            if (priceLuxury == null || priceLuxury.equals("")) {
                priceLuxury = viewRoomHandler.getPriceByCategory(RoomType.LUXURY);
            }
            return priceLuxury;
        }
        else
        {
            return "Something went wrong in server";
        }
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        viewRoomHandler.addListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        viewRoomHandler.removeListener(eventName,listener);
    }
}
