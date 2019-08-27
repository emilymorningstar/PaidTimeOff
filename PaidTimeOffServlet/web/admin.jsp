<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.riis.JDBC" %>
<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: Emily
  Date: 2019-08-23
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pending requests</title>
</head>
<body>
<%
    //TODO check permission
    if(session.getAttribute("username")==null){
        out.print("please log in to continue");
        session.invalidate();
        out.print("<META http-equiv=\"refresh\" content=\"3;URL=adminlogin.jsp\">");
    }
    else{
        ResultSet rs= JDBC.getPendingRequests();
        out.println("<table>");
        out.println("<form action = approve.jsp method = get>");
        while (rs.next()) {
            // retrieve and print the values for the current row

            String fname =rs.getString("FirstName");
            String lname =rs.getString("LastName");
            String email=rs.getString("email");
            Date d1 = rs.getDate("StartDate");
            Date d2 = rs.getDate("EndDate");
            int id = rs.getInt("id");
            out.println("<tr><td>"+ fname+"</td><td>"+ lname+"</td><td>" + email+"</td><td>"+ d1 + "</td><td>" + d2 + "</td><td>" + "<input type=radio name=id value="+id+ ">" +"</td></tr>");
        }
        out.println("</table><input type=submit value=submit></form>");
    }
%>
</body>
</html>
