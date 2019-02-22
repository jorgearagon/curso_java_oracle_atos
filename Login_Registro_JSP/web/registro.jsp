<%-- 
    Document   : registro
    Created on : 20-feb-2019, 17:44:25
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <%=dameTitulo("Registrate")%>
        <% if(session.getAttribute("email") == null) {%>
        <form name="form" method="post" action="procesar.do">
            <table border="1">
                <tr><td>Nombre:</td><td><input type="text" name="nom" id="nom" size="25" value=""/></td></tr>
                <tr><td>Edad:</td><td><input type="number" name="eda" id="eda" size="25" value=""/></td></tr>
                <tr><td>Email:</td><td><input type="text" name="email" id="email" size="25" value=""/></td></tr>
                <tr><td>Password:</td><td><input type="password" name="pass" id="pass" size="25" value="" required="required"/></td></tr>
                <tr><td>Metodo:</td><td><input type="text" name="metodo" id="metodo" size="25" value="POST" readonly="readonly"/></td></tr>
            </table>
            <input type="submit" value="Enviar"/>
        </form>
        <% }
        else
        {
            out.println("<h3>Ya estas logueado como "+session.getAttribute("email")+"</h3>");
            out.println("<a href=\"index.jsp\">Volver al Index</a>");
        }%>
    </body>
</html>
