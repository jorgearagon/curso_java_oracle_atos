<%-- 
    Document   : 03_ejer_scriptlet
    Created on : 19-feb-2019, 17:13:56
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="miestilo.css">
    </head>
    <body>
        <h1>Tabla de multiplicar del numero 7</h1>
        <%!
        //Declaracion de variables
        int i, j;
        %>
        <%-- Muestra una Tabla con sus TRs y sus TDs de la tabla de multiplicar del 7 --%>
        <table>
            <tr>
                <th>Expresion</th>
                <th>Resultado</th>
            </tr>
            <%
            int numero = 7;
            for (i = 0; i <=10; i++)
            {%>
                <tr>
                    <td><%= numero +" x "+ i%></td>
                    <td><%= numero*i%></td>
                </tr>
            <%           
            }
            %>
                
        </table>
        <h1>Tabla de multiplicar del numero 1 al 10</h1>
        <%-- Muestra una Tabla con sus TRs y sus TDs de la tabla de multiplicar del 7 --%>
        <%
        for (i = 1; i <=10; i++)
        {%>
        <div  class="flotar">
        <h2>Tabla del <%=i%></h2>
        <table>
            <tr>
                <th style="text-align: center" colspan="2">Tabla del x</th>
            </tr>
            <tr>
                <th>Expresion</th>
                <th>Resultado</th>
            </tr>
            <%
            for (j = 0; j <=10; j++)
            {%>
                <tr>
                    <td><%= i +" x "+ j%></td>
                    <td><%= i*j%></td>
                </tr>
        <%           
            }
        %>
        </table>
        </div>
        <%
        }
        %>
                
        
    </body>
</html>
