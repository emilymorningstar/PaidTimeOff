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
  //approve
    String s=request.getParameter("id");
    if(s.indexOf("approve")!=-1){
        String s2=s.substring(0,s.indexOf("approve"));
    JDBC.approve(Integer.parseInt(s2));}


    //deny
    if(s.indexOf("deny")!=-1){
        String s2=s.substring(0,s.indexOf("deny"));
        JDBC.deny(Integer.parseInt(s2));}
    out.print("<META http-equiv=\"refresh\" content=\"0;URL=admin.jsp\">");
%>
</body>
</html>
