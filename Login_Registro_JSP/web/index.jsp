<%-- 
    Document   : index
    Created on : 22-feb-2019, 12:37:01
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
        <div>GESTION USUARIOS</div>
        <h3><a href="login.jsp">Login</a></h3>
        <h3><a href="registro.jsp">Registro</a></h3>
        <% if (session.getAttribute("email")!=null){ %>
        <h3><a href="actualizarusuario.jsp">Actualizar</a></h3>
        <h3><a href="eliminarusuario.jsp">Eliminar</a></h3>
        <h3><a href="cerrarsesion.jsp">Cerrar Sesion</a></h3>
        <% } %>
    </body>
</html>
