<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.riis.JDBC" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<h5>welcome,&nbsp <%= session.getAttribute( "username" ) %>&nbsp<a href="logout.jsp">logout</a></h5>
<table>
    <tr><th>start date</th><th>end date</th><th>status</th></tr>

<%
if(session.getAttribute("username")==null){
    out.print("please log in to continue");
    out.print("<META http-equiv=\"refresh\" content=\"3;URL=login.jsp\">");
}
else{
    ResultSet rs= JDBC.view(JDBC.getUrl(),JDBC.getEmployeeId(JDBC.getUrl(),(String)session.getAttribute( "username" )));

    while (rs.next()) {
        // retrieve and print the values for the current row
        Date d1 = rs.getDate("StartDate");
        Date d2 = rs.getDate("EndDate");
        int i = rs.getInt("Status");
        out.println("<tr><td>"+d1 + "</td><td>" + d2 + "</td><td>" + JDBC.getStatus(i)+"</td></tr>");
    }
}
%>
</table>
<form action="newrequest.jsp">
<input type="submit">
</form>
</body>
</html>
