<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
<%
    if (session!=null) {
        session.invalidate();
    }
    out.print("<META http-equiv=\"refresh\" content=\"0;URL=login.jsp\">");
%>
</body>
</html>
