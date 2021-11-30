package server.model.viewRooms;

import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.List;

public class RoomProxy implements RoomHandler {

    private RoomHandler roomHandler;
    private String descriptionSingle, descriptionDouble, descriptionLuxury;
    private String priceSingle, priceDouble, priceLuxury;

    public RoomProxy() {
        roomHandler = new RoomImpl();
    }

    @Override
    public void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        roomHandler.searchRoom(dateFrom, dateTo, roomType);
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        if (roomType.toString().equals(RoomType.SINGLE.toString())) {
            if (descriptionSingle == null || descriptionSingle.equals("")) {
                descriptionSingle = roomHandler.getDescriptionByCategory(RoomType.SINGLE);
            }
            return descriptionSingle;
        } else if (roomType.toString().equals(RoomType.DOUBLE.toString())) {
            if (descriptionDouble == null || descriptionDouble.equals("")) {
                descriptionDouble = roomHandler.getDescriptionByCategory(RoomType.DOUBLE);
            }
            return descriptionDouble;
        } else if (roomType.toString().equals(RoomType.LUXURY.toString())) {
            if (descriptionLuxury == null || descriptionLuxury.equals("")) {
                descriptionLuxury = roomHandler.getDescriptionByCategory(RoomType.LUXURY);
            }
            return descriptionLuxury;
        } else {
            return "Error";
            //return "Error in database.. maybe invalid input";
        }

    }


    @Override
    public String getPriceByCategory(RoomType roomType) {
        if (roomType.equals(RoomType.SINGLE)) {
            if (priceSingle == null || priceSingle.equals("")) {
                priceSingle = roomHandler.getPriceByCategory(RoomType.SINGLE);
            }
            return priceSingle;
        } else if (roomType.equals(RoomType.DOUBLE)) {
            if (priceDouble == null || priceDouble.equals("")) {
                priceDouble = roomHandler.getPriceByCategory(RoomType.DOUBLE);
            }
            return priceDouble;
        } else if (roomType.equals(RoomType.LUXURY)) {
            if (priceLuxury == null || priceLuxury.equals("")) {
                priceLuxury = roomHandler.getPriceByCategory(RoomType.LUXURY);
            }
            return priceLuxury;
        } else {
            return "Something went wrong in server";
        }
    }

    @Override
    public Request bookRoom(Reservation reservation) {
      return roomHandler.bookRoom(reservation);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        roomHandler.addListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        roomHandler.removeListener(eventName, listener);
    }
}
