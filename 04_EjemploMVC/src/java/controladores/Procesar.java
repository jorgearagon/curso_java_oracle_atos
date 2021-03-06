/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;
import modelo.logica.GestionPersona;
import modelo.persistencia.FicheroPersona;

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
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        
//        if (nombre.equals("") || edad.equals(""))
//        {
//            request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
//        }
//        else
//        {
//            try
//            {
//                int iEdad = Integer.parseInt(edad);
//                Persona p1 = new Persona(nombre,iEdad);
//                request.getSession().setAttribute("persona1", p1);
//                request.getRequestDispatcher("exito.jsp").forward(request, response);
//            }catch(NumberFormatException nfe){
//                request.getRequestDispatcher("errornumero.jsp").forward(request, response);
//            }
//        }
        GestionPersona gp = GestionPersona.getInstacia();
        GestionPersona.TipoResultado resultado;
        resultado=gp.guardarPersona(nombre, edad);
        switch(resultado){
            case OK:
                request.getSession().setAttribute("persona1", gp.getPersona());
                request.getRequestDispatcher("exito.jsp").forward(request, response);
                break;
            case SIN_VALORES:
                request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
                break;
            case EDAD_MAL:
                request.getRequestDispatcher("errornumero.jsp").forward(request, response);
                break;
            case ERR_IO:
                request.getRequestDispatcher("errorio.jsp").forward(request, response);
                break;
        }
        //System.out.println(gp.guardarPersona(nombre, edad));
        //MI FORMA DE HACERLO
//        if(gp.guardarPersona(nombre, edad) == GestionPersona.TipoResultado.OK)
//        {
//            request.getSession().setAttribute("persona1", gp.getPersona());
//            request.getRequestDispatcher("exito.jsp").forward(request, response);
//        }
//        else if(gp.guardarPersona(nombre, edad) == GestionPersona.TipoResultado.SIN_VALORES)
//        {
//            request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
//        }
//        else
//        {
//            request.getRequestDispatcher("errornumero.jsp").forward(request, response);
//        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
