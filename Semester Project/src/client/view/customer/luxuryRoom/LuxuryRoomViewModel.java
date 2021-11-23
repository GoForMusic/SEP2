package client.view.customer.luxuryRoom;

import client.core.ModelFactory;
import client.model.viewRooms.ViewRoomsModel;
import javafx.beans.property.*;
import shared.utils.room.RoomType;

import java.time.LocalDate;

public class LuxuryRoomViewModel {
    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ModelFactory modelFactory;
    private ViewRoomsModel viewRoomsModel;
    private StringProperty description;
    private StringProperty price;

    public LuxuryRoomViewModel(ModelFactory modelFactory) {
        this.viewRoomsModel = modelFactory.getViewRoomsModel();
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

    public void searchRooms() {
        viewRoomsModel.searchRooms(dateFrom.get(), dateTo.get(), RoomType.LUXURY);
    }

    public StringProperty getDescription() {
        return description;
    }

    public StringProperty getPrice() {
        return price;
    }

    private void getDescriptionByCategory(){
        String description = viewRoomsModel.getDescriptionByCategory(RoomType.LUXURY);
        this.description.set(description);
    }
    private void getPriceByCategory(){
        String price = viewRoomsModel.getPriceByCategory(RoomType.LUXURY);
        this.price.set(price);
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
