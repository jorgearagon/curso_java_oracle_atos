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
        <%--Para usar la base de datos de derby habria que cambiar tanto el driver como la url, user and password--%>
        <sql:setDataSource var = "arra_usu" driver = "oracle.jdbc.driver.OracleDriver"
            url = "jdbc:oracle:thin:@192.168.0.226:1521:XE"
            user = "system"  password = "oracle"/>
        
        <sql:query dataSource = "${arra_usu}" var = "result">
            <%--SELECT * FROM Usuarios--%>
            SELECT * FROM L_USUARIO
        </sql:query>
        <div border="2">
            <c:forEach var = "row" items = "${result.rows}">
                <form action="usuarios.do" method="post" name="form_<c:out value = "${row.id}"/>">
                    <input id="id" name="id" type="text"  size="4" readonly="true" value="<c:out value = "${row.id}"/>"/>
                    <input id="nombre" name="nombre" type="text" required="true" value="<c:out value = "${row.nombre}"/>"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="<c:out value = "${row.edad}"/>"/>
                    <input id="email" name="email" type="email" required="true" value="<c:out value = "${row.email}"/>"/>
                    <input id="password" name="password" type="password" required="true" value="<c:out value = "${row.password}"/>"/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>

                    <input type="submit" value="EDIT" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                    <input type="submit" value="ELIM" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>
                </form>
            </c:forEach>
        </div>
    </body>
</html>