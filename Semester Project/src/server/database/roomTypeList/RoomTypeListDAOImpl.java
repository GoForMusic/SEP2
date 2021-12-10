package server.database.roomTypeList;

import server.database.DataBaseConnection;
import shared.utils.roomType.RoomType;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

public class RoomTypeListDAOImpl implements RoomTypeListDAO{

    public RoomTypeListDAOImpl() throws SQLException
    {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateRoomType(RoomType roomType) {
        try (Connection connection = DataBaseConnection.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("UPDATE roomtypes set (\"Room Type\", \"Price per Night\", \"Description\") = (?,?,?) where \"Room Type\"=?;");
            statement.setString(1, roomType.getRoomType());
            statement.setInt(2,roomType.getPrice());
            statement.setString(3, roomType.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public RoomType getRoomType(String type) {

        try{
            Connection connection = DataBaseConnection.getConnection();
            {
                PreparedStatement statement = connection.prepareStatement("SELECT * from \"roomtypes\" where \"Room Type\" = ?;");
                statement.setString(1, type);
                ResultSet resultSet = statement.executeQuery();
                if( resultSet.next())
                {
                    String rType = resultSet.getString("roomType");
                    int rPrice = resultSet.getInt("price");
                    String rDescription = resultSet.getString("description");
                    connection.close();
                    return new RoomType(rType, rPrice, rDescription);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public ArrayList<RoomType> getRoomTypes() {
        ArrayList<RoomType> list = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from \"roomtypes\";");
            ResultSet resultSet = statement.executeQuery();
            while( resultSet.next())
            {
                String rType = resultSet.getString("Room Type");
                int rPrice = resultSet.getInt("Price per night");
                String rDescription = resultSet.getString("Description");
                connection.close();
                list.add(new RoomType(rType, rPrice, rDescription));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
        return list;
    }
}
