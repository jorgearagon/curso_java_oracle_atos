<%-- 
    Document   : eliminarusuario
    Created on : 22-feb-2019, 14:43:02
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
        <% if(session.getAttribute("email") != null)
            {%>
        <%=dameTitulo("Eliminar")%>
        <form name="form1" method="post" action="procesar.do">
            <table border="1">
                <tr><td>Email:</td><td><input type="text" name="email" id="email" size="25" value="<%=session.getAttribute("email")%>" readonly="readonly"/></td></tr>
                <tr><td>Metodo:</td><td><input type="text" name="metodo" id="metodo" size="25" value="DELETE" readonly="readonly"/></td></tr>
                </table>
            <input type="submit" value="Eliminar"/>
        </form>
        <%}%>
    </body>
</html>
