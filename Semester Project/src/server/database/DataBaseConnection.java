package server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class was created to return the connection with the database.
 *
 * @author Adrian
 * @version 0.1
 */
public class DataBaseConnection
{
  /**
   * A public static function that will call the connection with the database everytime where an SQL command is executed.
   *
   * @return the connection with the server.
   * @throws SQLException = will show on the console the specific message from database
   */
  //TODO set this with localhost before hand-in
  public static Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(
        "jdbc:postgresql://abul.db.elephantsql.com/bdqygxwv?currentSchema=\"Hesam\"",
        "bdqygxwv", "hyDt-rqHEb40VxSY04oiSSr-5RyVQFpY");
  }
}
