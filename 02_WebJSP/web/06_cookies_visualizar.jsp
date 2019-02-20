<%-- 
    Document   : 06_cookies_visualizar
    Created on : 20-feb-2019, 16:23:30
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
        <p>Visualizar contenido de las cookies</p>
        <%
            Cookie[] cookies=request.getCookies();
            out.println("<p>Las cookies existentes son: "+cookies.length+"</p>");
            for(int i=0;i<cookies.length;i++)
            {
               // if(cookies[i].getName().equals("nombre_c"))
               // {
                    out.println("Hola(Valor de la cookie) "+cookies[i].getValue());
                    out.println("Hola(Nombre de la cookie) "+cookies[i].getName());
                    %> <br><%
                //}
            }
        %>
    </body>
</html>
