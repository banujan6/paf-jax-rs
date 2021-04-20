package com.example.jersy_rest_api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/students")
public class StudentResource {

  @GET
  @Produces("application/json")
  public String getAll() {
    String data = "";

    try {
      Connection connection = dbConnector.connect();
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM test");

      while(rs.next()) {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");

        if (data == "") {
          data = "{\"id\": "+id.toString()+", \"name\": \""+name+"\"}";
        } else {
          data += ",{\"id\": " + id.toString() + ", \"name\": \"" + name + "\"}";
        }
      }

      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return "["+data+"]";
  }

  @GET
  @Path("{id}")
  @Produces("application/json")
  public String getById(@PathParam("id") String id) {
    return "{}";
  }

}
