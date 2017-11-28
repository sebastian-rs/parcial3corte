/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Vo.principale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JCBOT
 */
public class Crud_Usuarios {

    public List<principale> findAll() throws SQLException {
        List<principale> departamentos = null;
        String query = "SELECT * FROM usuarios";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            String usuario ;
            String contrasena ;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<principale>();
                }

                principale registro = new principale();
                usuario = rs.getString("usuario");
                registro.setUsuario(usuario);

                contrasena = rs.getString("contrasena");
                registro.setContrasena(contrasena);
                

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
        }

        return departamentos;
    }

    public boolean create_user(principale t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String r1 = "CREATE USER '";
        String r2 = "'@'localhost' IDENTIFIED BY '";
        String r3 = "'";

        String query = r1 + t.getUsuario() + r2 + t.getContrasena() + r3;
        System.out.println(query);

        PreparedStatement preparedStmt = null;
        preparedStmt = connection.prepareStatement(query);
        result = preparedStmt.execute();

        return result;
    }

    public boolean privilegios(principale t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();

        String r1 = "GRANT ALL PRIVILEGES ON phpmyadmin.* TO '";
        String r2 = "'@'localhost'";

        String query = r1 + t.getUsuario() + r2;
        System.out.println(query);

        PreparedStatement preparedStmt = null;
        preparedStmt = connection.prepareStatement(query);
        result = preparedStmt.execute();

        return result;
    }

    public boolean insert(principale t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into usuarios (usuario,contrasena) " + "values (?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getUsuario());
            preparedStmt.setString(2, t.getContrasena());
            result = preparedStmt.execute();
        } catch (SQLException e) {
        }
        return result;
    }

    public boolean update(principale t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update usuarios set usuario = ? where usuario = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getUsuario());
            preparedStmt.setString(2, t.getUsuario());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
        }

        return result;
    }

    public boolean delete(principale t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from usuarios where usuario = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getUsuario());
            result = preparedStmt.execute();
        } catch (SQLException e) {
        }

        return result;
    }

}
