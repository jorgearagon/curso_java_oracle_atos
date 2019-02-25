<%-- 
    Document   : eliminarcualquierusuario
    Created on : 25-feb-2019, 12:52:16
    Author     : USUARIO
--%>

<%@page import="modelo.Persona"%>
<%@page import="modelo.logica.GestionUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <form name="form1" method="post" action="procesar.do">
        <table border="1">
            <tr>
                <th></th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Email</th>
                <th>Contraseña</th>
            </tr>
        <%
        GestionUsuarios gu = GestionUsuarios.getInstancia();
        for(Persona pers:gu.listarUsuarios())
        {
        %>    <tr>
                <td><input type="radio" name="persona" value="<%=pers.getEmail()%>" checked="checked"></td>
                <td><%=pers.getNombre()%></td>
                <td><%=pers.getEdad()%></td>
                <td><%=pers.getEmail()%></td>
                <td><%=pers.getPassword()%></td>
              </tr><%
        }
        %>
        <tr><td colspan="2">Metodo:</td><td colspan="3"><input type="text" name="metodo" id="metodo" size="25" value="DELETE2" readonly="readonly"/></td></tr>
        </table>
        <input type="submit" value="Eliminar"/>
        </form>
    </body>
</html>
