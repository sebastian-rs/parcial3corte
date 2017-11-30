/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Conexion;
import Dao.Crud_recoleccion;
import Vo.recoleccionfi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class Recoleccion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            int insertar;
      

            if (request.getParameter("insertar") == null) {
                insertar = 0;
            } else {
                insertar = Integer.parseInt(request.getParameter("insertar"));

            }

         

            String Fecha = request.getParameter("Fecha");
            String Recolector = request.getParameter("Recolector");
            String Colmena = request.getParameter("Colmena");
            String Kilosdemiel = request.getParameter("Kilosdemiel");
            int temp=Integer.parseInt(Kilosdemiel);
            Crud_recoleccion cr = new Crud_recoleccion();

            if (insertar == 1) {
                recoleccionfi final1 = new recoleccionfi(Fecha, Recolector, Colmena, temp);
                Crud_recoleccion cr1 = new Crud_recoleccion();
                try {
                    cr1.insert(final1);
                    request.getRequestDispatcher("recoleccion.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(Recoleccion.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

      

        }
    }
}
