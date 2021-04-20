package com.example.jersy_rest_api;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnector {

  public static Connection connect()
  {
      Connection connect = null;

      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf", "root", "");
      } catch (Exception e) {
        e.printStackTrace();
      }

      return connect;
  }

}
