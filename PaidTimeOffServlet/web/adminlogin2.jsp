<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.riis.JDBC"%>
<html>
<head>

    <title>Title</title>
    <%
        String s=JDBC.login(request.getParameter("username"),request.getParameter("password"));
        int i=JDBC.accountType(request.getParameter("username"));
        if(s!=null&&s!="Log in error please enter the correct information"&&i==1)
        {
            session.setAttribute( "username", request.getParameter("username") );
            session.setAttribute( "password", request.getParameter("password") );
            session.setAttribute( "permission", 1 );
            out.print("<form id=\"myForm\" action=\"admin.jsp\" method=\"POST\"> " );//+
            out.print("<script>\n" +
                    "    document.getElementById(\"myForm\").submit();\n" +
                    "\n" +
                    "</script>");
        }
        else{
            out.print("Log in error please enter the correct information.");
            out.print("<br>");
            out.print("you may not have permission to access this page.");
            out.print("<META http-equiv=\"refresh\" content=\"3;URL=adminlogin.jsp\">");
        }
    %>

</head>
<body>

</body>
</html>
