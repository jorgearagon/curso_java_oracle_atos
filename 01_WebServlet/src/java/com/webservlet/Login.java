/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class Login extends HttpServlet {

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
//            out.println("<title>Servlet Login</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
            out.println("<title>Formulario de Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Introduce tus datos</h1>");
            out.println("<form name='form1' method='post' action='http://localhost:8084/01WebServlet/login'>");
            out.println("<table border='1'>");
            out.println("<tr><td>Email:</td><td><input type='text' name='email' id='email' size='25' value=''/></td></tr>");
            out.println("<tr><td>Password:</td><td><input type='password' name='pass' id='pass' size='25' value=''/></td></tr>");
            out.println("</table>");
            out.println("<input type='submit' value='Enviar'/>");
            out.println("<a href=\"registro\">Registrarse</a>");
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
            out.println("<title>Leyendo Usuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            if(ListadoUsuarios.getInstance().existe(request.getParameter("email"), request.getParameter("pass")))
            {
                out.println("Bienvenido!");
            }
            else
            {
                out.println("Ese usuario no existe!");
                out.println("<a href=\"login\">Volver al Login</a>");
            }
//            boolean compr=false;
////            out.println("<p>hola22</p>");
//            Persona per= new Persona();
//            for(Persona p:ListadoUsuarios.getInstance().getRegistros())
//            {
////                out.println("<p>"+p.getEmail()+"</p>");
////                out.println("<p>"+p.getPassword()+"</p>");
//                if(p.getEmail().equals(request.getParameter("email")) && p.getPassword().equals(request.getParameter("pass")))
//                {
//                    compr=true;
//                }
//            }
//            if(compr==true)
//            {
//                out.println("Enhorabuena!");
//            }
//            else
//            {
//                out.println("Ese usuario no existe!");
//                out.println("<a href=\"login\">Volver al Login</a>");
//            }
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
