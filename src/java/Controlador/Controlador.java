/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import ModeloDao.PersonaDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arica
 */
public class Controlador extends HttpServlet {
    
    String listar = "vistas/listar.jsp", add = "vistas/add.jsp", edit = "vistas/edit.jsp";
    Persona per = new Persona();
    PersonaDao dao = new PersonaDao();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (accion.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (accion.equalsIgnoreCase("Agregar")) {
            String dni = request.getParameter("txtDni"), nom = request.getParameter("txtNom");
            per.setDni(dni);
            per.setNom(nom);
            dao.add(per);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("edit")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        } else if (accion.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("txtDni"), nom = request.getParameter("txtNom");
            per.setId(id);
            per.setDni(dni);
            per.setNom(nom);
            dao.edit(per);
            acceso=listar;
        } else if (accion.equalsIgnoreCase("delete")) {
            id=Integer.parseInt(request.getParameter("id"));
            per.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
        processRequest(request, response);
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
