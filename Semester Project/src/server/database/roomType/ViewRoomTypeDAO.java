package server.database.roomType;

import java.time.LocalDate;

public interface ViewRoomTypeDAO
{
  String getRoomDescriptionByCategory(String roomType);
  int getRoomPriceByCategory(String roomType);
}
