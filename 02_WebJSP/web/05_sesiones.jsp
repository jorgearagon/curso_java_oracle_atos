<%-- 
    Document   : 05_sesiones
    Created on : 20-feb-2019, 14:04:44
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de sesiones JSP</title>
    </head>
    <body>
        <%@include file="cabecera.jsp" %>
        <%= dameTitulo("Gestion de sesiones JSP")%>
        <%!
            int totalPeticiones = 0;//Variable global(es como una variable statica)
        %>
        <!--<h1>Gestion de sesiones JSP</h1>-->
        <h2>Calculo de un factorial</h2>
        <form action="05_sesiones.jsp" method="get">
            <p>N&uacute;mero: <input type="number" id="num" name="num"/></p>
            <p><input type="submit" value="Calcular"/></p>
        </form>
        <%
            int numero=0;
            double factorial=1;
            boolean error = false;
            String numeroRecogido = request.getParameter("num");
            if (numeroRecogido != null)
            {
                try
                {
                    numero = Integer.parseInt(numeroRecogido);
                    if(numero < 1)
                    {
                        error = true;
                    }
                    else
                    {
                        for(int i=numero; i>0 ;i--)
                        {
                            factorial *= i;
                        }
                        totalPeticiones++;
                    }
                }catch(NumberFormatException nfe){
                    error=true;
                }
            }
            if(error)
            {
                out.println("<p style='color: red'> Indicar un numero mayor que 0</p>");
            }
            else
            {
                out.println("Resultado de "+numero+": "+factorial);
                out.println("Total de peticiones: "+totalPeticiones);
            }
            if(session.isNew())
            {
                session.setMaxInactiveInterval(300);
            }
            Integer contador = (Integer) session.getAttribute("contadorVisitas");
            if(contador != null)
            {
                contador = Integer.valueOf(contador);
            }
            else
            {
                contador=0;
            }
            if(contador != 0)
            {
                %><p>Ejecuciones de este JSP en esta sesión: <%=contador %></p><%
            }
            contador++;
            session.setAttribute("contadorVisitas", contador);
        %>
    </body>
</html>
