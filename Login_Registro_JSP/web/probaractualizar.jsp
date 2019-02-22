<%-- 
    Document   : probaractualizar
    Created on : 22-feb-2019, 12:05:44
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
        <h1>Nombre: <%=request.getParameter("nombre")%> </h1>
        <h1>Edad: <%=request.getParameter("edad")%> </h1>
    </body>
</html>
