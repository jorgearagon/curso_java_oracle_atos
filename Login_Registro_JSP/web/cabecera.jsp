<%-- 
    Document   : cabecera
    Created on : 20-feb-2019, 16:50:46
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header><h1>Ejercicio Gestión de Usuarios</h1></header>
<nav>
    <%
        String[] urls = {"index.jsp","login.jsp","registro.jsp","act_registro.jsp","borrar_registro.jsp"};
        String[] nombres = {"Index","Login","Registrarse","Actualizar Usuario","Borrar Usuario"};
        for(int i = 0; i < urls.length; i++)
        {
    %>
            <a href="<%= urls[i] %>"><%= nombres[i] %></a>
    <%  
        } 
    %>
</nav>
<%!
    private String dameTitulo(String titulo){
        return "<h2 style='color: green;'>"+ titulo+"</h2>";
    }
%>
    </body>
</html>
