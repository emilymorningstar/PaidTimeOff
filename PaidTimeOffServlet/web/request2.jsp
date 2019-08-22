<%@ page import="java.sql.Date" %>
<%@ page import="com.riis.JDBC" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Emily
  Date: 2019-08-21
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request</title>
</head>
<body>
<%
        if(session.getAttribute("username")==null){
            out.print("please log in to continue");
            out.print("<META http-equiv=\"refresh\" content=\"3;URL=login.jsp\">");
        }
        else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parseds = format.parse(request.getParameter("sdate"));
            java.util.Date parsede = format.parse(request.getParameter("edate"));
            //out.print(session.getAttribute("username"));
            java.sql.Date sd = new java.sql.Date(parseds.getTime());
            java.sql.Date ed = new java.sql.Date(parsede.getTime());
            String u= session.getAttribute("username").toString();
            JDBC.addRequest(sd,ed,u);
        }%>

</body>
</html>
