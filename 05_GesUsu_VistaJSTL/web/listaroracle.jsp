<%-- 
    Document   : listaroracle
    Created on : 28-feb-2019, 12:15:31
    Author     : USUARIO
--%>
<%@include file="head.jsp" %>
<html>
    <%= head() %>
    <body>
        <!--
        RECORDAR EN SQL DATASOURCE, QUE HAY QUE USR EL ATRIBUTO sql="..."
        -->
        <%@include file="header.jsp" %>
        <h1>Todos los usuarios con ORACLE</h1>
        <%--Para usar la base de datos de derby habria que cambiar tanto el driver como la url, user and password--%>
        <form action="listaroracle.jsp" method="post" name="form_nota">
            Nota: <input type="number" min="0" max="10" id="nota" name="nota" required/>
            <input type="submit" value="Enviar" name="enviar"/><br><br>
        </form>
        <sql:setDataSource var = "arra_usu" driver = "oracle.jdbc.driver.OracleDriver"
            url = "jdbc:oracle:thin:@localhost:1521:XE"
            user = "system"  password = "oracle"/>
        <c:choose>
            <c:when test="${empty param.nota}">
                No hay minimo
                <sql:query dataSource = "${arra_usu}" var = "result">
                    <%--SELECT * FROM Usuarios--%>
                    SELECT * FROM USUARIO
                </sql:query>
            </c:when>
            <c:otherwise>
                Nota minima: ${param.nota}
                <sql:query dataSource = "${arra_usu}" var = "result">
                    <%--SELECT * FROM Usuarios--%>
                    SELECT * FROM USUARIO WHERE NOTA > ${param.nota}
                </sql:query>
            </c:otherwise>
        </c:choose>
        
        <div border="2">
            <c:forEach var = "row" items = "${result.rows}">
                <form action="usuarios.do" method="post" name="form_<c:out value = "${row.id}"/>">
                    <input id="id" name="id" type="text" size="4" readonly="true" value="<c:out value = "${row.id}"/>"/>
                    <input id="nombre" name="nombre" type="text" size="10" required="true" value="<c:out value = "${row.nombre}"/>"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="<c:out value = "${row.edad}"/>"/>
                    <input id="email" name="email" type="email" size="12" required="true" value="<c:out value = "${row.email}"/>"/>
                    <input id="password" name="password" type="password" size="5" required="true" value="<c:out value = "${row.password}"/>"/>
                    <input id="apellidos" name="apellidos" type="text" size="8" required="true" value="<c:out value = "${row.apellidos}"/>"/>
                    <input id="descripcion" name="descripcion" type="text" required="true" value="<c:out value = "${row.descripcion}"/>"/>
                    <input id="fecha_registro" name="fecha_registro" type="text" required="true" value="<c:out value = "${row.fecha_registro}"/>"/>
                    <input id="nota_2" name="nota_2" type="number" size="2" required="true" value="<c:out value = "${row.nota}"/>"/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>

                    <input type="submit" value="EDIT" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                    <input type="submit" value="ELIM" onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>
                </form>
            </c:forEach>
        </div>
    </body>
</html>
