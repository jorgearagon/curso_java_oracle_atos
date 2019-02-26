<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<html>
    <%= head() %>
    <body>
        <!--
        
        RECORDAR EN SQL DATASOURCE, QUE HAY QUE USR EL ATRIBUTO sql="..."
        
        
        -->
        <%@include file="header.jsp" %>
        <h1>Todos los usuarios</h1>
        <jsp:useBean id="arra_usu" type="java.util.ArrayList" scope="session">
            <jsp:getProperty property="" name="arra_usu"></jsp:getProperty>
        </jsp:useBean>
        <div border="2">
           <%-- <% for(Usuario usu : ServicioUsuarios.getInstancia().obtenerTodos())
            {%> 
                <form action="usuarios.do" method="post" name="form_<%=usu.getId()%>">
                    
                        <input id="id" name="id" type="text"  size="4" readonly="true" value="<%=usu.getId()%>"/>
                        <input id="nombre" name="nombre" type="text" required="true" value="<%=usu.getNombre()%>"/>
                        <input id="edad" name="edad" type="number" required="true"  size="4" value="<%=usu.getEdad() %>"/>
                        <input id="email" name="email" type="email" required="true" value="<%=usu.getEmail()%>"/>
                        <input id="password" name="password" type="password" required="true" value="<%=usu.getPassword()%>"/>
                        <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>

                        <input type="submit" value="EDIT" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                        <input type="submit" value="ELIM" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>
                    
                </form>
            <%}%> --%>
            <c:forEach items="${arra_usu}" var="usuarios">
                <form action="usuarios.do" method="post" name="form_${usuarios.id}">
                    <input id="id" name="id" type="text"  size="4" readonly="true" value="${usuarios.id}"/>
                    <input id="nombre" name="nombre" type="text" required="true" value="${usuarios.nombre}"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="${usuarios.edad}"/>
                    <input id="email" name="email" type="email" required="true" value="${usuarios.email}"/>
                    <input id="password" name="password" type="password" required="true" value="${usuarios.password}"/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>

                    <input type="submit" value="EDIT" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                    <input type="submit" value="ELIM" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>

                </form>
            </c:forEach>
        </div>
    </body>
</html>