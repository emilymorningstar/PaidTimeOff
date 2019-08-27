<%@ page import="com.riis.JDBC" %><%--
  Created by IntelliJ IDEA.
  User: Emily
  Date: 2019-08-26
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>approve</title>
</head>
<body>
<%
    JDBC.approve(Integer.parseInt(request.getParameter("id")));
    out.print("<META http-equiv=\"refresh\" content=\"0;URL=admin.jsp\">");
%>
</body>
</html>
