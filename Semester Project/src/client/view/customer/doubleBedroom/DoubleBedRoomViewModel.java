package client.view.customer.doubleBedroom;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.*;
import shared.utils.room.RoomType;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * The view model that deals with the double room
 */
public class DoubleBedRoomViewModel {

    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private RoomsModel roomsModel;
    private StringProperty description;
    private StringProperty price;

    public DoubleBedRoomViewModel(ModelFactory modelFactory) {
        this.roomsModel = modelFactory.getRoomsModel();
        initializeData();
        getDescriptionByCategory();
        getPriceByCategory();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    private void getDescriptionByCategory() {
        String description = roomsModel.getDescriptionByCategory(RoomType.DOUBLE);
        this.description.set(description);
    }

    private void getPriceByCategory() {
        String price = roomsModel.getPriceByCategory(RoomType.DOUBLE);
        this.price.set(price);
    }

    /**
     * Passes the dates and rooms to the model
     */
    public void searchRooms() {
        roomsModel.setTempStartAndEndDate(dateFrom.get(),dateTo.get());
        roomsModel.searchRooms(dateFrom.get(), dateTo.get(), RoomType.DOUBLE);
    }

    public StringProperty getDescription() {
        return description;
    }

    public StringProperty getPricePerNight() {
        return price;
    }
    private void initializeData() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now());
        description = new SimpleStringProperty();
        price = new SimpleStringProperty();
    }
}
