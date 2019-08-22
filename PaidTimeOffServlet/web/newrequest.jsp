<%--
  Created by IntelliJ IDEA.
  User: Emily
  Date: 2019-08-21
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new request</title>
</head>
<body>
<%
    if(session.getAttribute("username")==null){
        out.print("please log in to continue");
        out.print("<META http-equiv=\"refresh\" content=\"3;URL=login.jsp\">");
    }
    else {
        out.print("<form name = \"newRequestForm\" action = \"request2.jsp\" method=post>\n" +
                "                start date: &nbsp<input type = \"date\" name=sdate>\n" +
                "                end date:  &nbsp<input type = \"date\" name=edate>\n" +
                "    <input type = \"submit\" >");

    }%>
</form>
</body>
</html>
