<%-- 
    Document   : registrado
    Created on : 21-feb-2019, 23:21:10
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<html>
    <%= head()%>
    <body>
        <%@include file="header.jsp" %>
        <h1>Registrado correctamente</h1>
        <%--<h2><%= usuario.getNombre() + " - " + usuario.getEmail()%></h2>--%>
        <h2>
            <c:out value="${usuario.nombre}: <${usuario.email}> edad: ${usuario.edad}"></c:out>
        </h2>
    </body>
</html>
