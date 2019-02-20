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
        <h1>Hello World!</h1>
        <%
            out.println("<form name='form1' method='post' action='registro.jsp'>");
            out.println("<table border='1'>");
            out.println("<tr><td>Nombre:</td><td><input type='text' name='nom' id='nom' size='25' value=''/></td></tr>");
            out.println("<tr><td>Edad:</td><td><input type='number' name='eda' id='eda' size='25' value=''/></td></tr>");
            out.println("<tr><td>Email:</td><td><input type='text' name='email' id='email' size='25' value=''/></td></tr>");
            out.println("<tr><td>Password:</td><td><input type='password' name='pass' id='pass' size='25' value='' required='required'/></td></tr>");
            out.println("</table>");
            out.println("<input type='submit' value='Enviar'/>");
            out.println("</form>");
        %>
    </body>
</html>
