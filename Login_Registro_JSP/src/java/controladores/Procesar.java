/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.logica.GestionUsuarios;

/**
 *
 * @author USUARIO
 */
public class Procesar extends HttpServlet {

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
        String nombre = request.getParameter("nom");
        int edad = Integer.parseInt(request.getParameter("eda"));
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        GestionUsuarios gu = GestionUsuarios.getInstancia();
        GestionUsuarios.TipoResultado resultado;
        resultado=gu.guardarUsuario(nombre, email, email, pass);
        switch(resultado){
            case OK:
                //request.getSession().setAttribute("persona1", gp.getPersona());
                request.getRequestDispatcher("exito.jsp").forward(request, response);
                break;
//            case SIN_VALORES:
//                request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
//                break;
            case EDAD_MAL:
                request.getRequestDispatcher("errornumero.jsp").forward(request, response);
                break;
            case ERR_IO:
                request.getRequestDispatcher("errorio.jsp").forward(request, response);
                break;
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
