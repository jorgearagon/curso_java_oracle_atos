<%-- 
    Document   : header
    Created on : 21-feb-2019, 20:43:31
    Author     : IEUser
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.logica.ServicioUsuarios"%>
<%--
<% 
    //Usuario usuario = (Usuario) session.getAttribute("usuario");
    String error = (String) session.getAttribute("mensajeError");
%>
--%>
<h2>Aplicación Gestión MVC JSP</h2>
<nav>
    <a href="index.jsp">Inicio</a>
    <c:catch var="excepcion">
        <jsp:useBean id="usuario" type="modelo.Usuario" scope="session">
            <jsp:getProperty property="" name="usuario"></jsp:getProperty>
            <%--Property lo que hace es coger las propiedades de cada elemento.
            Tambien podriamos hacerlo uno a uno y obtendria los metodos get de cada uno de ellos al ser getProperty-
            Si usasemos setProperty, obtendriamos los set de cada uno que pusiesemos.
            Por eso en la clase usuario deben llamarse set... o get... los metodos que obtengan o modifiquen los valores
            de los atributos--%>
            <%--<jsp:getProperty property="id" name="usuario"></jsp:getProperty>
            <jsp:getProperty property="email" name="usuario"></jsp:getProperty>--%>
        </jsp:useBean>
            <a href="listar.jsp">Listar</a>
            <a href="listarsql.jsp">Listar SQL</a>
            <a href="listaroracle.jsp">Listar ORACLE</a>
            <a href="eliminar.jsp">Eliminar</a>
            <form action="usuarios.do" style="display: inline-block">
                <input id="email" name="email" type="hidden" value="LOGOUT"/>
                <input TYPE="submit" value="Salir"/>
            </form>
    </c:catch>
    <c:if test="${not empty excepcion}">
        <a href="login.jsp">Login</a>
        <a href="registrarse.jsp">Registrarse</a>
    </c:if>
 </nav>
<!--Esto es igual que lo de abajo pero con etiquetas jsf o jstl no se como es exactamente-->
<c:if test="${sessionScope.mensajeError!=null}">
    <h3 style="color: orange">${sessionScope.mensajeError}</h3>
    <c:remove var="mensajeError" scope="session"/>
</c:if>
<%--
<% if (error != null && !error.isEmpty())
{%>
    <h3 style="color: red"><%=error%></h3> 
    <% session.removeAttribute("mensajeError");
}%>
--%>