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
import javax.servlet.http.HttpSession;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String metodo = request.getParameter("metodo");
        switch (metodo) {
            case "POST":
                {
                    String nombre = request.getParameter("nom");
                    String edad = request.getParameter("eda");
                    String email = request.getParameter("email");
                    String pass = request.getParameter("pass");
                    GestionUsuarios gu = GestionUsuarios.getInstancia();
                    GestionUsuarios.TipoResultado resultado;
                    resultado=gu.guardarUsuario(nombre, edad, email, pass);
                    switch(resultado){
                        case OK:
                            //request.getSession().setAttribute("persona1", gp.getPersona());
                            request.getRequestDispatcher("registroexito.jsp").forward(request, response);
                            break;
                        case NOM_MAL:
                            request.getRequestDispatcher("errornombre.jsp").forward(request, response);
                            break;
                        case EDAD_MAL:
                            request.getRequestDispatcher("erroredad.jsp").forward(request, response);
                            break;
                        case ERR_IO:
                            request.getRequestDispatcher("errorio.jsp").forward(request, response);
                            break;
                        case EMAIL_MAL:
                            request.getRequestDispatcher("erroremail.jsp").forward(request, response);
                            break;
                        case PASS_MAL:
                            request.getRequestDispatcher("errorpass.jsp").forward(request, response);
                            break;
                    }       break;
                }
            case "GET":
            {
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                GestionUsuarios gu = GestionUsuarios.getInstancia();
                GestionUsuarios.TipoResultado resultado;
                resultado=gu.leerUsuario(email, pass);
                switch(resultado){
                    case OK:
                        sesion.setAttribute("email", email);
                        request.getRequestDispatcher("loginexito.jsp").forward(request, response);
                        break;
                    case USU_NOEXISTE:
                        request.getRequestDispatcher("errorusuario.jsp").forward(request, response);
                        break;
                    case SIN_VALORES:
                        request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("errorempass.jsp").forward(request, response);
                        break;
                }       break;
            }
            case "PUT1":
            {
                String nombre = request.getParameter("nombre");
                String edad = request.getParameter("edad");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String email_actual = sesion.getAttribute("email").toString();
                GestionUsuarios gu = GestionUsuarios.getInstancia();
                GestionUsuarios.TipoResultado resultado;
                resultado=gu.actualizarUsuario(nombre, edad, email, pass, email_actual);
                switch(resultado){
                    case OK:
                        //request.getSession().setAttribute("persona1", gp.getPersona());
                        sesion.removeAttribute("email");
                        sesion.setAttribute("email", email);
                        request.getRequestDispatcher("actualizarexito.jsp").forward(request, response);
                        break;
                    case NOM_MAL:
                            request.getRequestDispatcher("errornombre.jsp").forward(request, response);
                            break;
                    case EDAD_MAL:
                        request.getRequestDispatcher("erroredad.jsp").forward(request, response);
                        break;
                    case ERR_IO:
                        request.getRequestDispatcher("errorio.jsp").forward(request, response);
                        break;
                    case EMAIL_MAL:
                        request.getRequestDispatcher("erroremail.jsp").forward(request, response);
                        break;
                    case PASS_MAL:
                        request.getRequestDispatcher("errorpass.jsp").forward(request, response);
                        break;
                }   break;
            }
            case "PUT2":
            {
                sesion.setAttribute("pers_act", request.getParameter("persona"));
                request.getRequestDispatcher("actualizarcualquierusuario2.jsp").forward(request, response);
                break;
            }
            case "PUT3":
            {
                String nombre = request.getParameter("nombre");
                String edad = request.getParameter("edad");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String email_actual = request.getParameter("email_act");
                GestionUsuarios gu = GestionUsuarios.getInstancia();
                GestionUsuarios.TipoResultado resultado;
                resultado=gu.actualizarUsuario(nombre, edad, email, pass, email_actual);
                switch(resultado){
                    case OK:
                        //request.getSession().setAttribute("persona1", gp.getPersona());
                        if(sesion.getAttribute("email")!=null)
                        {
                            sesion.removeAttribute("email");
                            sesion.setAttribute("email", email);
                        }
                        request.getRequestDispatcher("actualizarexito.jsp").forward(request, response);
                        break;
                    case NOM_MAL:
                            request.getRequestDispatcher("errornombre.jsp").forward(request, response);
                            break;
                    case EDAD_MAL:
                        request.getRequestDispatcher("erroredad.jsp").forward(request, response);
                        break;
                    case ERR_IO:
                        request.getRequestDispatcher("errorio.jsp").forward(request, response);
                        break;
                    case EMAIL_MAL:
                        request.getRequestDispatcher("erroremail.jsp").forward(request, response);
                        break;
                    case PASS_MAL:
                        request.getRequestDispatcher("errorpass.jsp").forward(request, response);
                        break;
                }   break;
            }
            case "DELETE1":
            {
                //BORRAR EL USUARIO LOGUEADO
                String email = request.getParameter("email");
                GestionUsuarios gu = GestionUsuarios.getInstancia();
                GestionUsuarios.TipoResultado resultado;
                resultado=gu.eliminarUsuario(email);
                switch(resultado){
                    case OK:
                        //request.getSession().setAttribute("persona1", gp.getPersona());
                        sesion.removeAttribute("email");
                        request.getRequestDispatcher("eliminarexito.jsp").forward(request, response);
                        break;
                    case ERR_IO:
                        request.getRequestDispatcher("errorio.jsp").forward(request, response);
                        break;
                }   break;
            }
            case "DELETE2":
            {
                //BORRAR CUALQUIER USUARIO
                String opcion_seleccionada=request.getParameter("persona");
                GestionUsuarios gu = GestionUsuarios.getInstancia();
                GestionUsuarios.TipoResultado resultado;
                resultado=gu.eliminarUsuario(opcion_seleccionada);
                switch(resultado){
                    case OK:
                        if(sesion.getAttribute("email")!=null)
                        {
                            sesion.removeAttribute("email");
                        }
                        request.getRequestDispatcher("eliminarexito.jsp").forward(request, response);
                        break;
                    case ERR_IO:
                        request.getRequestDispatcher("errorio.jsp").forward(request, response);
                        break;
                }   break;
                //BORRAR EL USUARIO LOGUEADO
//                String email = request.getParameter("email");
//                GestionUsuarios gu = GestionUsuarios.getInstancia();
//                GestionUsuarios.TipoResultado resultado;
//                resultado=gu.eliminarUsuario(email);
//                switch(resultado){
//                    case OK:
//                        //request.getSession().setAttribute("persona1", gp.getPersona());
//                        sesion.removeAttribute("email");
//                        request.getRequestDispatcher("eliminarexito.jsp").forward(request, response);
//                        break;
//                    case ERR_IO:
//                        request.getRequestDispatcher("errorio.jsp").forward(request, response);
//                        break;
//                }   break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
//        String email = request.getParameter("email");
//        String pass = request.getParameter("pass");
//        GestionUsuarios gu = GestionUsuarios.getInstancia();
//        GestionUsuarios.TipoResultado resultado;
//        resultado=gu.leerUsuario(email, pass);
//        switch(resultado){
//            case OK:
//                sesion.setAttribute("email", email);
//                request.getRequestDispatcher("loginexito.jsp").forward(request, response);
//                break;
//            case USU_NOEXISTE:
//                request.getRequestDispatcher("errorusuario.jsp").forward(request, response);
//                break;
//            case SIN_VALORES:
//                request.getRequestDispatcher("errorcampos.jsp").forward(request, response);
//                break;
//            default:
//                request.getRequestDispatcher("errorempass.jsp").forward(request, response);
//                break;
//        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        request.getRequestDispatcher("probaractualizar.jsp").forward(request, response);
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
