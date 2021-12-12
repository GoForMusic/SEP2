package server.database.roomType;

import server.database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is the connection with database where is the actions getting description for room and getting price are executed.
 * @author Himal
 * @version 0.1
 */
public class ViewRoomTypeDAOImpl implements ViewRoomTypeDAO
{


  /**
   * A function that will get room description by category
   * @param roomType
   * @return
   */
  @Override public String getRoomDescriptionByCategory(String roomType)
  {
    String temp = "It was connected but did not get Description";
    try (Connection connection = DataBaseConnection.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "select \"Description\" from roomtypes where \"Room Type\" = ?;");

      statement.setString(1,roomType);

      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()){
        temp = resultSet.getString("Description");
      }

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
      System.out.println("It is mistake on ViewRoomTypeDAOImpl could not get Description");
    }
    return temp;

  }

  /**
   * A function that will return the room price by cat
   * @param roomType
   * @return
   */
  @Override public int  getRoomPriceByCategory(String roomType)
  {
    int price = 0;
    try(Connection connection = DataBaseConnection.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement( "select \"Price per Night\" from roomtypes where \"Room Type\" = ?;");
      statement.setString(1,roomType);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()){
         price = resultSet.getInt("Price per Night");
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }

    return price;
  }





}
