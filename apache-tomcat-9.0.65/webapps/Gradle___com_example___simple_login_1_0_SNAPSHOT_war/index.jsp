<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<style type="text/css">
    .login {
        height: 180px;
        width: 300px;
        margin: 0;
        padding: 10px;
        border:1px black solid;
    }
    .login input {
        padding: 5px;
        margin: 5px;
    }
</style>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form>
    <div class="login">
        <h2>Login</h2>
        <input type="text" name="username" size="30" placeholder="username">
        <input type="password" name="password" size="30" placeholder="password">
        <input type="submit" value="Sign in">
    </div>
</form>
</body>
</html>