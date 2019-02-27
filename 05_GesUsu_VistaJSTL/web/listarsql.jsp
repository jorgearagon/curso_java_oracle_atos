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
        <h1>Todos los usuarios con SQL</h1>
        
        <sql:setDataSource var = "arra_usu" driver = "org.apache.derby.jdbc.ClientDriver"
            url = "jdbc:derby://localhost:1527/UsuariosDB"
            user = "test"  password = "test"/>
        
        <sql:query dataSource = "${arra_usu}" var = "result">
            SELECT * FROM Usuarios
        </sql:query>
        <div border="2">
            <c:forEach var = "row" items = "${result.rows}">
                <form action="usuarios.do" method="post" name="form_<c:out value = "${row.id}"/>">
                    <input id="id" name="id" type="text"  size="4" readonly="true" value="<c:out value = "${row.id}"/>"/>
                    <input id="nombre" name="nombre" type="text" required="true" value="<c:out value = "${row.nombre}"/>"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="<c:out value = "${row.edad}"/>"/>
                    <input id="email" name="email" type="email" required="true" value="<c:out value = "${row.email}"/>"/>
                    <input id="password" name="password" type="password" required="true" value="<c:out value = "${row.pass}"/>"/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>

                    <input type="submit" value="EDIT" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                    <input type="submit" value="ELIM" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>
                </form>
            </c:forEach>
        </div>
    </body>
</html>