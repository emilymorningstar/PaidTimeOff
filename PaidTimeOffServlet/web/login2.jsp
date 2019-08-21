<%--
  Created by IntelliJ IDEA.
  User: Emily
  Date: 2019-08-19
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.riis.JDBC"%>
<html>
<head>

    <title>Title</title>
    <%
        String s=JDBC.login(JDBC.getUrl(),request.getParameter("username"),request.getParameter("password"));

        if(s!=null&&s!="Log in error please enter the correct information")
        {
            session.setAttribute( "username", request.getParameter("username") );
            session.setAttribute( "password", request.getParameter("password") );
            out.print("<form id=\"myForm\" action=\"main.jsp\" method=\"POST\"> " );//+
            out.print("<script>\n" +
                   "    document.getElementById(\"myForm\").submit();\n" +
                   "\n" +
                   "</script>");
        }
        else{
        out.println(s);
        out.print("<META http-equiv=\"refresh\" content=\"3;URL=login.jsp\">");
    }
    %>

</head>
<body>

</body>
</html>
