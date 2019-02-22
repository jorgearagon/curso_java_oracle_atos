<%-- 
    Document   : errorcampos
    Created on : 21-feb-2019, 9:57:17
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
        <h1>Complete los campos</h1>
        <a href="login.jsp">Volver</a>
        <%
            if(request.getParameter("email") == "")
            { %>
                <h2>Falta email</h2>
        <%  }
            if(request.getParameter("pass") == "")
            {%>
                <h2>Falta pass</h2>
         <% }       
        %>
    </body>
</html>
