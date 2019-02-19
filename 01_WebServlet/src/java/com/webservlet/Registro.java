/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class Registro extends HttpServlet {

    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Registro</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formulario de Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Introduce tus datos</h1>");
            out.println("<form name='form1' method='post' action='http://localhost:8084/01WebServlet/registro'>");
            out.println("<table border='1'>");
            out.println("<tr><td>Nombre:</td><td><input type='text' name='nom' id='nom' size='25' value=''/></td></tr>");
            out.println("<tr><td>Edad:</td><td><input type='number' name='eda' id='eda' size='25' value=''/></td></tr>");
            out.println("<tr><td>Email:</td><td><input type='text' name='email' id='email' size='25' value=''/></td></tr>");
            out.println("<tr><td>Password:</td><td><input type='password' name='pass' id='pass' size='25' value='' required='required'/></td></tr>");
            out.println("</table>");
            out.println("<input type='submit' value='Enviar'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Leyendo Parametro ParamServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if (Integer.parseInt(request.getParameter("eda")) < 18)
            {
                out.println("<p>Para registrate tienes que tener mas de 18 años</p>");
                out.println("<a href=\"registro\">Volver a Registro</a>");
                out.println("<a href=\"index.html\">Volver a Inicio</a>");
            }
            else
            {
                if(ComprobarParametros.comprEmail(request.getParameter("email")) && ComprobarParametros.comprPass(request.getParameter("pass")))
                {
                    Persona p = new Persona(request.getParameter("nom"), Integer.parseInt(request.getParameter("eda"))
                            , request.getParameter("email"), request.getParameter("pass"));
    //                registros.add(p);
                    ListadoUsuarios lu = ListadoUsuarios.getInstance();
                    lu.add(p);
                    //ListadoUsuarios.setRegistros(p);
                    //out.println("<p>"+ListadoUsuarios.getRegistros().get(0).getEmail()+"  "+ListadoUsuarios.getRegistros().get(0).getPassword());
                    out.println("<p>Registrado con Exito!</p>");
                    out.println("<a href=\"login\">Ir al Login</a>");
                    out.println("<a href=\"index.html\">Volver a Inicio</a>");
                }
                else
                {
                    out.println("<p>Email o contraseña incorrectas</p>");
                    out.println("<a href=\"registro\">Volver a Registro</a>");
                    out.println("<a href=\"index.html\">Volver a Inicio</a>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
