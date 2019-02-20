<%-- 
    Document   : 06_cookies
    Created on : 20-feb-2019, 16:11:11
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Creamos las cookies
    Cookie cookie_nombre=new Cookie("nombre_c",request.getParameter("nombre"));
    Cookie cookie_apellidos=new Cookie("apellidos_c",request.getParameter("apellidos"));

    //CAambianos el tiempo de duracion de ambas cookies
    cookie_nombre.setMaxAge(60*60*24);//Time is in Minutes
    cookie_apellidos.setMaxAge(60*60*24);

    //Añadimos las cookies a la cabecera de respuesta
    response.addCookie(cookie_nombre);
    response.addCookie(cookie_apellidos);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionando cookies JSP</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <h1>Gestionando cookies JSP</h1>
        <ul>
            <li><p>Nombre: <%=request.getParameter("nombre") %></p></li>
            <li><p>Apellidos: <%=request.getParameter("apellidos") %></p></li>
        </ul>
        <a href="06_cookies_visualizar.jsp">Continue</a>
    </body>
</html>
