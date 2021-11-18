package server.database.roomType;

import server.database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewRoomTypeDAOImpl implements ViewRoomTypeDAO
{

  /**
   * This class is the connection with database where is the actions getting description for room and getting price are executed.
   *
   * @author Himal
   * @version 0.1
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

      while (resultSet.next()){
        Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
        row[0] = resultSet.getString(1);
        temp= ((String) row[0]);
      }



    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
      System.out.println("It is mistake on ViewRoomTypeDAOImpl could not get Description");
    }
    return temp;

  }

  @Override public int getRoomPriceByCategory(String roomType)
  {
    int price = 0;
    try(Connection connection = DataBaseConnection.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement( "select \"Price per Night\" from roomtypes where \"Room Type\" = ?;");
      statement.setString(1,roomType);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()){
        Object row[] = new Object[resultSet.getMetaData().getColumnCount()];
        row[0]=resultSet.getInt(1);
        price =((int) row[0]);

      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }

    return price;
  }





}
