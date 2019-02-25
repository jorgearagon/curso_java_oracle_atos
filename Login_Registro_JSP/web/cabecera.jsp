<%-- 
    Document   : cabecera
    Created on : 20-feb-2019, 16:50:46
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header><h1>Ejercicio Gestión de Usuarios</h1></header>
<nav>
    <%
        String[] urls = {"index.jsp","login.jsp","registro.jsp","actualizarcualquierusuario.jsp","eliminarcualquierusuario.jsp","actualizarusuario.jsp","eliminarusuario.jsp","cerrarsesion.jsp"};
        String[] nombres = {"Index","Login","Registrarse","Actualizar un Usuario","Eliminar un Usuario","Actualizar Usuario","Borrar Usuario","Cerrar Sesion"};
        for(int i = 0; i < urls.length; i++)
        {
            if(i>=5 && session.getAttribute("email") != null)
            {
    %>
            <a href="<%= urls[i] %>"><%= nombres[i] %></a>
    <%  
            }
            else
                if(i<=4)
                {%>
                    <a href="<%= urls[i] %>"><%= nombres[i] %></a>
               <% }
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
