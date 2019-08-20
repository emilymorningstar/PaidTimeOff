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
        String s=JDBC.login("jdbc:sqlserver://localhost;user=sa;password=reallyStrongPwd123",request.getParameter("username"),request.getParameter("password"));

        if(s!=null&&s!="Log in error please enter the correct information")
        {
            //out.println("<b>username:</b>"+request.getParameter("username"));
            //out.println("<b>password:</b>"+request.getParameter("password"));
            out.println(s);
            out.print("<form id=\"form\" action=\"main.jsp\" method=\"POST\"> " +
                    "<input type=\"hidden\" name=\"username\" value=\"<?php echo $username ?>\">" +
                    "\"<input type=\\\"hidden\\\" name=\\\"password\\\" value=\\\"<?php echo $password ?>\\\">");

            out.print("<script>document.getElementById(\"form\").submit();<script>");
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
