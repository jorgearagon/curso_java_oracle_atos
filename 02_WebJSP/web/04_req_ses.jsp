<%-- 
    Document   : 04_req_ses
    Created on : 20-feb-2019, 9:26:30
    Author     : Jorge Aragón Hernández
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de peticiones y respuestas JSP</title>
    </head>
    <body>
        <h1>Gestión de peticiones y respuestas JSP</h1>
        <form action="04_req_ses.jsp" method="get">
            <p>Nombre y apellidos:</p>
            <p><input type="text" name="nombre_apell" id="nombre_apell" 
                      autocomplete="true" size="50" maxlength="100"/></p>
        </form>
    </body>
</html>
