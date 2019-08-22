<%--
  Created by IntelliJ IDEA.
  User: Emily
  Date: 2019-08-22
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create account</title>
    <h1>Create a new account</h1>
    <form action="newaccount2.jsp" method="post" name="newuserform" required>
        first name: <input type="text" name="firstname" required></br>
        last name: <input type="text" name="lastname" required></br>
        email: <input type="email" name="email" required></br>
        password: <input type="password" name="password" required></br>
        <input type="submit" value="submit">
    </form>
</head>
<body>

</body>
</html>
