/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Crud_Usuarios;
import Vo.principale;
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
public class Principal extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            int crear;
            int entrar;

            if (request.getParameter("crear") == null) {
                crear = 0;
            } else {
                crear = Integer.parseInt(request.getParameter("crear"));

            }

            if (request.getParameter("entrar") == null) {
                entrar = 0;
            } else {
                entrar = Integer.parseInt(request.getParameter("entrar"));
            }

            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");

            if (crear == 1) {
                principale in = new principale(usuario, contrasena);
                String message = "El usuario a sido creado satisfactoriamente vuelva a ingresar";
                Crud_Usuarios cr = new Crud_Usuarios();

                try {
                    cr.create_user(in);
                    cr.privilegios(in);
                    cr.insert(in);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("Index.jsp").forward(request, response);

            }

            if (entrar == 2) {
                principale in = new principale(usuario, contrasena);
                Crud_Usuarios uss = new Crud_Usuarios();
                List<principale> index1 = null;
                try {
                    index1 = uss.findAll();
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int i = 0; i < index1.size(); i++) {

                    if (index1.get(i).getContrasena().equals(contrasena)) {
                        request.getRequestDispatcher("Application.jsp").forward(request, response);
                    }

                }

                String message = "El usuario no esta registrado en la base de datos";
                request.setAttribute("message", message);
                request.getRequestDispatcher("Index.jsp").forward(request, response);

            }

        }
    }
}
