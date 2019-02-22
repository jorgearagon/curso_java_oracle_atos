<%-- 
    Document   : actualizarusuario
    Created on : 22-feb-2019, 12:01:00
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
        <%=dameTitulo("Actualizar")%>
        <h1>Introduce tus datos</h1>
        <form name="form1" method="put" action="procesar.do">
            <table border="1">
                <tr><td>Nombre:</td><td><input type="text" name="nombre" id="nombre" size="25" value=""/></td></tr>
                <tr><td>Edad:</td><td><input type="number" name="edad" id="edad" size="25" value=""/></td></tr>
                </table>
            <input type="submit" value="Enviar"/>
            <a href="registro">Registrarse</a>
        </form>
    </body>
</html>
