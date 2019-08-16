package com.riis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    public static Connection connect(String url){
        try (Connection connection = DriverManager.getConnection(url);) {
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   public static int newUser(String u,String f, String l, String email, int id, int roleID, String p ){
        try{
            Connection connection = DriverManager.getConnection(u);
            Statement stmt = connection.createStatement();
            String q="USE PaidTimeOff INSERT INTO EMPLOYEES VALUES ('"+f+"', '"+l+"', '"+email+"', '"+roleID+"', '"+p+"');";
            System.out.println(q);
            stmt.execute(q);

        }
       catch(Exception e) {
           e.printStackTrace();
           return -1;
       }return 0;

   }
}
