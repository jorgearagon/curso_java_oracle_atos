<%-- 
    Document   : cerrarsesion
    Created on : 22-feb-2019, 12:39:03
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
        <% if(session.getAttribute("email") != null)
            {
                session.removeAttribute("email");%>
                <h3>Has cerrado sesion con exito</h3>
                <a href="index.jsp">Volver al Index</a>
        <%    }
        else
        {%>
            <h3>No has iniciado sesion todavía</h3>
            <a href="index.jsp">Volver al Index</a>
            <%} %>
    </body>
</html>
