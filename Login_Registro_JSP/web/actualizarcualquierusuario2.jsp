<%-- 
    Document   : actualizarcualquierusuario2
    Created on : 25-feb-2019, 14:04:17
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
        <form name="form1" method="post" action="procesar.do">
            <p>Persona que vas a actualizar: <input type="text" id="email_act" name="email_act" value="<%=session.getAttribute("pers_act")%>" readonly="readonly"></p>
            <table border="1">
                <tr><td>Nombre:</td><td><input type="text" name="nombre" id="nombre" size="25" value=""/></td></tr>
                <tr><td>Edad(Mayor de 18):</td><td><input type="number" name="edad" id="edad" size="25" value=""/></td></tr>
                <tr><td>Email:</td><td><input type="text" name="email" id="email" size="25" value=""/></td></tr>
                <tr><td>Password:</td><td><input type="password" name="pass" id="pass" size="25" value="" required="required"/></td></tr>
                <tr><td>Metodo:</td><td><input type="text" name="metodo" id="metodo" size="25" value="PUT3" readonly="readonly"/></td></tr>
                </table>
            <input type="submit" value="Enviar"/>
            <a href="registro">Registrarse</a>
        </form>
    </body>
</html>
