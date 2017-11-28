/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Crud_esquemas;
import Vo.Esquema;
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
public class esquema extends HttpServlet {

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

            String ID = request.getParameter("ID");
            String nombre = request.getParameter("NOMBRE");
            int id = Integer.parseInt(ID);

            Crud_esquemas cr = new Crud_esquemas();

            if (crear == 1) {
                Esquema esq = new Esquema(id, nombre, crear);
          

                try {
                    cr.insert(esq);
             
                    request.getRequestDispatcher("Esquema.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (modificar == 2) {
                Esquema esq = new Esquema(id, nombre, modificar);
                try {
                    cr.update(esq);
                    request.getRequestDispatcher("Esquema.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(esquema.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (eliminar == 3) {
                Esquema esq = new Esquema(id, nombre, eliminar);
                try {
                    cr.delete(esq);
                    request.getRequestDispatcher("Esquema.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(esquema.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
