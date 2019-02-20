<%-- 
    Document   : 04_req_ses
    Created on : 20-feb-2019, 9:26:30
    Author     : Jorge Aragón Hernández
--%>

<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de peticiones y respuestas JSP</title>
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body class="container">
        <%@include file="cabecera.jsp" %>
        <%= dameTitulo("Gestión de peticiones y respuestas JSP")%>
        <!--<h1>Gestión de peticiones y respuestas JSP</h1>-->
        <%
            String nomApell = request.getParameter("nombre_apell");
            String desc = request.getParameter("desc");
            String email = request.getParameter("email");
            if(nomApell == null || desc == null || email == null)
            {
        %>
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <script>
                function preguntarSiEnviar()
                {
                    if(document.getElementById("nombre_apell").value != "" && document.getElementById("nombre_apell").value.length > 1)
                    {
                        let siQuiereEnviar = window.confirm("Deseas enviar esto?");
                        return siQuiereEnviar;
                    }
                    else
                    {
                        alert("nombre debe ser maayor de 1 caracter");
                        return false;
                    }
                }
            </script>
            <form action="04_req_ses.jsp" method="get" class="form-inline" onsubmit="return preguntarSiEnviar()">
                <p>Nombre y apellidos:</p>
                <p><input type="text" name="nombre_apell" id="nombre_apell" 
                          autocomplete="true" size="50" maxlength="100" 
                          required="true" placeholder="Introduzca nombre y apellidos" class="form-control"/></p>
                <p>Descripcion:</p>
                <p><textarea id="desc" name="desc" required="true" cols="100" rows="10"
                        placeholder="Introduzca una descripcion detallada" class="form-control">
                   </textarea></p>
                <p>Email:</p>
                <p><input type="email" name="email" id="email" 
                          autocomplete="true" size="50" maxlength="100" 
                          required="true" placeholder="Introduzca su email" class="form-control"/></p>
                <p><input type="submit" value="Enviar" class="btn btn-default"/></p>
            </form>
        </div>
        <div class="col-lg-2"></div>
        <%
            }
            else//Cuando parece que todo esta OK
            {
                Pattern pc=Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
                Matcher m=pc.matcher(email);
                //otra opcion es if(email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                //"[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$"));
                if(nomApell != "" || desc != "" || email != "")
                {
                    if(nomApell != null && nomApell.length()>1)
                    {
                        if (desc != null && desc.length() > 5)
                        {
                            //Validacion del mail
                            if(m.matches())
                            {
                                try
                                {
                                    FileWriter fw = new FileWriter("C:\\Users\\USUARIO\\Desktop\\solicitudes.txt");
                                    PrintWriter pw = new PrintWriter(fw);
                                    pw.printf("Nombre='%s'\r\nDescripcion='%s'\r\nE-mail='%s'", nomApell,desc,email);
                                    pw.close();
                                    out.println("<h2>Ha funcionado</h2>");
                                }catch(IOException ioe){
                                    %><h2 style="color: red">Fallo en fichero</h2><%
                                }
                            }
                            else
                            {
                                out.println("<h3>El correo es incorrecto</h3>");
                            }
                        }
                        else
                        {
                            out.println("<h3>La descripcion debe ser mayor que 5</h3>");
                        }
                    }
                    else
                    {
                        %>
                        <h3>El nombre y apellidos debe tener al menos un caracter</h3>
                        <%
                    }
                }
                
            }
        %>
        <!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
