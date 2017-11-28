/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Crud_Columna2;
import Dao.Crud_InterectionFlow;
import Dao.Crud_SelectionField;
import Dao.Crud_SimpleField;
import Vo.Columna;
import Vo.Form;
import Vo.Parameter;
import Vo.ParameterBinding;
import Vo.SelectionField;
import Vo.SimpleField;
import Vo.ViemContainer;
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
public class columna extends HttpServlet {

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
            int id = Integer.parseInt(ID);
            String nombre = request.getParameter("NOMBRE");
            String Type = request.getParameter("Type");
            String size1 = request.getParameter("size");
            int size = Integer.parseInt(size1);
            String defaultValue = request.getParameter("defaultValue");
            String isRequired1 = request.getParameter("isRequired");
            boolean isRequired = Boolean.parseBoolean(isRequired1);
            String accepNull1 = request.getParameter("accepNull");
            boolean accepNull = Boolean.parseBoolean(accepNull1);
            String alias = request.getParameter("alias");
            String comment = request.getParameter("comment");
            String helpmessage = request.getParameter("helpmessage");

            Crud_Columna2 cr1 = new Crud_Columna2();
            Crud_InterectionFlow flow = new Crud_InterectionFlow();
            Crud_SelectionField field = new Crud_SelectionField();
            Crud_SimpleField simple = new Crud_SimpleField();

            if (crear == 1) {

                Columna col = new Columna(id, nombre, Type, size, defaultValue, isRequired, accepNull, alias, comment, helpmessage, crear);
                try {
                    cr1.insert(col);
                } catch (SQLException ex) {
                    Logger.getLogger(columna.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(columna.class.getName()).log(Level.SEVERE, null, ex);
                }
                Parameter par = new Parameter();
                par.setId(id);
                Form fo = new Form(nombre);
                SimpleField si = new SimpleField(fo, Type, helpmessage, comment, defaultValue);
                SelectionField se = new SelectionField(fo, Type, helpmessage, comment, defaultValue);

                ViemContainer viem2 = new ViemContainer();

                ViemElement vi = new ViemElement() {
                };
                vi.setName(nombre);

                ParameterBinding par1 = new ParameterBinding(par);
                InterectionFlow inte = new InterectionFlow(vi, par1, Type) {
                };

                flow.insert(inte);
                field.insert(se);
                simple.insert(si);

                request.getRequestDispatcher("Columna.jsp").forward(request, response);

            }
            if (modificar == 2) {
                Columna col = new Columna(id, nombre, Type, size, defaultValue, isRequired, accepNull, alias, comment, helpmessage, modificar);
                cr1.update(col);
                request.getRequestDispatcher("Columna.jsp").forward(request, response);
            }
            if (eliminar == 3) {
                Columna col = new Columna(id, nombre, Type, size, defaultValue, isRequired, accepNull, alias, comment, helpmessage, eliminar);
                cr1.delete(col);
                request.getRequestDispatcher("Columna.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(columna.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
