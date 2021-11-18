package server.database.roomType;

public interface ViewRoomTypeDAO
{
  String getRoomDescriptionByCategory(String roomType);



  int getRoomPriceByCategory(String roomType);
}
