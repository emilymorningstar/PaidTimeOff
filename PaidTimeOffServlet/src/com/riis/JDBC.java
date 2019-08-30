package com.riis;

import java.sql.*;
//import com.microsoft.sqlserver.jdbc.*;

public class JDBC {
private final static String url="jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123";

    public static String getUrl(){
        return url;
    }
    public static Connection connect(String url) {

        try (Connection connection = DriverManager.getConnection(url);) {
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int newUser(String f, String l, String email, int roleID, String p) {
        try {
            Connection connection = DriverManager.getConnection(getUrl());
            Statement stmt = connection.createStatement();
            String q = "USE PaidTimeOff INSERT INTO employees VALUES ('" + f + "', '" + l + "', '" + email + "', '" + roleID + "', '" + p + "');";
            System.out.println(q);
            stmt.execute(q);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;

    }

    public static int CreateRequest(String ds, String de, int eid) {
        Date dayS = Date.valueOf(ds);
        Date dayE = Date.valueOf(de);
        //status 2 is pending
        try {
            Connection connection = DriverManager.getConnection(getUrl());
            Statement stmt = connection.createStatement();
            String q = "USE PaidTimeOff INSERT INTO Requests VALUES ('" + eid + "', '" + ds + "', '" + de + "',2);";
            System.out.println(q);
            stmt.execute(q);

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getEmployeeId(String s) {
        try {
            Connection connection = DriverManager.getConnection(getUrl());
            Statement stmt = connection.createStatement();
            String q = "USE PaidTimeOff SELECT id from Employees Where email='" + s + "';";
            ResultSet rs = stmt.executeQuery(q);
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String login(String Username, String Password) {
        try {

            Connection connection = DriverManager.getConnection(getUrl());
            Statement stmt = connection.createStatement();
            String q = "USE PaidTimeOff SELECT email from Employees Where email='" + Username + "'AND password='" + Password + "';";
            System.out.println(q);
            ResultSet rs = stmt.executeQuery(q);
            if (rs.next()) {
                return rs.getString("email");
            }
            return "Log in error please enter the correct information";
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public static ResultSet view(int id) {
        try {
            Connection connection = DriverManager.getConnection(getUrl());
            Statement stmt = connection.createStatement();
            String q = "USE PaidTimeOff SELECT StartDate, EndDate, Status FROM Requests Where EmployeeID="+id+";";
            System.out.println(q);
            ResultSet rs = stmt.executeQuery(q);
            System.out.println(rs);

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getStatus(int i) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(getUrl());
            Statement stmt = connection.createStatement();
            String q = "USE PaidTimeOff SELECT Status FROM [status] WHERE id="+i+"";
            System.out.println(q);
            ResultSet rs = stmt.executeQuery(q);
            if (rs.next()) {
                return rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static String addRequest(Date start, Date end, String uname) {
        try{Connection connection = null;
        connection = DriverManager.getConnection(getUrl());
        PreparedStatement stmt =connection.prepareStatement("USE PaidTimeOff  INSERT INTO Requests VALUES (?,?,?,?)");
        stmt.setString(1,""+getEmployeeId(uname));
        stmt.setString(2,start.toString());
        stmt.setString(3,end.toString());
        stmt.setString(4,"2");
        stmt.executeUpdate();
        return "ok";}
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean accountExists(String email){
        try {
            Connection connection = null;
            connection = DriverManager.getConnection(getUrl());
            PreparedStatement stmt =connection.prepareStatement(  "USE PaidTimeOff select * from Employees where email = ?");
            stmt.setString(1,email);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int accountType(String email) {
        try{
            Connection connection = null;
            connection = DriverManager.getConnection(getUrl());
            PreparedStatement stmt =connection.prepareStatement("USE PaidTimeOff select RoleID from Employees where email = ?");
            stmt.setString(1,email);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
            return(rs.getInt("RoleID"));}
            else
                return -1;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static ResultSet getPendingRequests() {
        try{
            Connection connection = null;
            connection = DriverManager.getConnection(getUrl());
            PreparedStatement stmt =connection.prepareStatement("use PaidTimeOff SELECT EmployeeID,Firstname,Lastname,email,StartDate, Enddate,Requests.Id FROM Requests JOIN Employees on Requests.EmployeeID=Employees.id WHERE [Status]=2");
            ResultSet rs=stmt.executeQuery();
            return rs;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void approve(int i) {
        try{
            Connection connection = null;
            connection = DriverManager.getConnection(getUrl());
            PreparedStatement stmt =connection.prepareStatement("use PaidTimeOff update requests set [status]=1 where id=?");
            stmt.setString(1,i+"");
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deny(int i) {
        try{
            Connection connection = null;
            connection = DriverManager.getConnection(getUrl());
            PreparedStatement stmt =connection.prepareStatement("use PaidTimeOff update requests set [status]=3 where id=?");
            stmt.setString(1,i+"");
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
