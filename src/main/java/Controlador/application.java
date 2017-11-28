/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vo.ViemContainer;
import Dao.Crud_Application;
import Dao.Crud_ViemContainer;
import Vo.Application;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JCBOT
 */
public class application extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            int crear;
            int modificar;
            int eliminar;

            if (request.getParameter("crear") == null) {
                crear = 0;
            } else {
                crear = Integer.parseInt(request.getParameter("crear"));

            }

            if (request.getParameter("modificar") == null) {
                modificar = 0;
            } else {
                modificar = Integer.parseInt(request.getParameter("modificar"));
            }

            if (request.getParameter("eliminar") == null) {
                eliminar = 0;
            } else {
                eliminar = Integer.parseInt(request.getParameter("eliminar"));
            }

            String name = request.getParameter("name");;
            String Descripcion = request.getParameter("Descripcion");

            Crud_Application cr = new Crud_Application();
            Crud_ViemContainer cr1 = new Crud_ViemContainer();

            if (crear == 1) {
                ViemContainer v1 = new ViemContainer();
          

                ViemElement t = new ViemElement() {
                };
                t.setName(name);
                Application ap = new Application(name, Descripcion);

                try {
                    cr.insert(ap);
                    cr1.insert(v1);
                    request.getRequestDispatcher("Application.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (modificar == 2) {

                Application ap = new Application(name, Descripcion);

                try {
                    cr.update(ap);
                    request.getRequestDispatcher("Application.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (eliminar == 3) {

                Application ap = new Application(name, Descripcion);

                try {
                    cr.delete(ap);
                    request.getRequestDispatcher("Application.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }
}
