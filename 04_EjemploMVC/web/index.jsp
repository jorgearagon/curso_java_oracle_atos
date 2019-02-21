<%-- 
    Document   : index
    Created on : 21-feb-2019, 9:45:23
    Author     : USUARIO
--%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.logica.GestionPersona"%>
<%
    String nombre = "";
    int edad = 0;
    if (GestionPersona.getInstacia().getPersona()!=null)
    {
        nombre = GestionPersona.getInstacia().getPersona().getNombre();
        edad = GestionPersona.getInstacia().getPersona().getEdad();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC</title>
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <form action="procesar.do" method="get">
            Nombre: <input type="text" id="nombre" name="nombre" value="<%=nombre %>"/><br>
            Edad: <input type="text" id="edad" name="edad" value="<%=edad %>"/><br>
            <input type="submit" value="Enviar datos"/>
        </form>
    </body>
</html>
