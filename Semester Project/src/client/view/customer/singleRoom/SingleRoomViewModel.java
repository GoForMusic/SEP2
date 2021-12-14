package client.view.customer.singleRoom;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.*;
import shared.utils.room.RoomType;

import java.time.LocalDate;

/**
 * @author Sachin, Emil
 * A class that will set-up sinple room details
 */
public class SingleRoomViewModel {
    private ObjectProperty<LocalDate> dateFrom;
    private ObjectProperty<LocalDate> dateTo;
    private StringProperty description;
    private StringProperty price;
    private RoomsModel roomsModel;

    public SingleRoomViewModel(ModelFactory modelFactory) {
        this.roomsModel = modelFactory.getRoomsModel();
        initializeValues();
        getDescriptionByCategory();
        getPriceByCategory();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    public void searchRooms() {
        roomsModel.setTempStartAndEndDate(dateFrom.get(),dateTo.get());
        roomsModel.searchRooms(dateFrom.get(), dateTo.get(), RoomType.SINGLE);
    }

    public StringProperty getPrice() {
        return price;
    }

    public void getDescriptionByCategory(){
        String description = roomsModel.getDescriptionByCategory(RoomType.SINGLE);
        this.description.set(description);
    }
    public void getPriceByCategory(){
        String price = roomsModel.getPriceByCategory(RoomType.SINGLE);
        this.price.set(price);
    }
    private void initializeValues() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now().plusDays(1));
        description = new SimpleStringProperty();
        price = new SimpleStringProperty();
    }

    public StringProperty getDescription() {
        return description;
    }
}
