/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Dao.Crud_tablas;
import Vo.Tabla;
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
public class tabla extends HttpServlet {

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

            Crud_tablas cr = new Crud_tablas();
            if (crear == 1) {
                Tabla tab = new Tabla(id, nombre, crear);
                ViemComponent v1=new ViemComponent(nombre){};
               
                try {
                    try {
                        cr.insert(tab);
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.getRequestDispatcher("Tabla.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (modificar == 2) {
                Tabla tab = new Tabla(id, nombre, modificar);
                cr.update(tab);
                request.getRequestDispatcher("Tabla.jsp").forward(request, response);
            }
            if (eliminar == 3) {
                Tabla tab = new Tabla(id, nombre, eliminar);
                cr.delete(tab);
                request.getRequestDispatcher("Tabla.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
