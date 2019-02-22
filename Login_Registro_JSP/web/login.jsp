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
        <% if(session.getAttribute("email") == null) {%>
        <h1>Introduce tus datos</h1>
        <form name="form" method="post" action="procesar.do">
            <table border="1">
                <tr><td>Email:</td><td><input type="text" name="email" id="email" size="25" value=""/></td></tr>
                <tr><td>Password:</td><td><input type="password" name="pass" id="pass" size="25" value=""/></td></tr>
                <tr><td>Metodo:</td><td><input type="text" name="metodo" id="metodo" size="25" value="GET" readonly="readonly"/></td></tr>
                </table>
            <input type="submit" value="Enviar"/>
            <a href="registro.jsp">Registrarse</a>
        </form>
        <% }
        else
        {
            out.println("<h3>Ya estas logueado como "+session.getAttribute("email")+"</h3>");
            out.println("<a href=\"index.jsp\">Volver al Index</a>");
        }%>
    </body>
</html>
