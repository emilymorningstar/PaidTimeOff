<%@ page import="com.riis.JDBC" %><%--
  Created by IntelliJ IDEA.
  User: Emily
  Date: 2019-08-22
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%if(!JDBC.accountExists(request.getParameter("email")))
{
    JDBC.newUser(request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),2,request.getParameter("password"));
    out.print("account created</br>");
}
else{
       out.print("account already exists</br>");
    }
    %>

<a href="login.jsp">login</a>
</body>
</html>
