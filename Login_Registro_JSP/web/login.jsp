<%-- 
    Document   : login
    Created on : 20-feb-2019, 17:44:12
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <%=dameTitulo("Introduce tus Datos")%>
        <h1>Introduce tus datos</h1>
        <form name="form1" method="get" action="procesar.do">
            <table border="1">
                <tr><td>Email:</td><td><input type="text" name="email" id="email" size="25" value=""/></td></tr>
                <tr><td>Password:</td><td><input type="password" name="pass" id="pass" size="25" value=""/></td></tr>
                </table>
            <input type="submit" value="Enviar"/>
            <a href="registro">Registrarse</a>
        </form>
    </body>
</html>
