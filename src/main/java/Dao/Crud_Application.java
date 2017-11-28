/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Vo.Application;
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
public class Crud_Application {

    public List<Application> findAll() throws SQLException {
        List<Application> departamentos = null;
        String query = "SELECT * FROM Application";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String name ;
            String decription ;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Application>();
                }

                Application registro = new Application();
                name = rs.getString("name");
                registro.setName(name);

                decription = rs.getString("decription");
                registro.setDecription(decription);
                

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(Application t) throws SQLException {

        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Application (name,decription) " + "values (?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getName());
            preparedStmt.setString(2, t.getDecription());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Application t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update Application set name = ? where name = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getName());
            preparedStmt.setString(2, t.getName());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(Application t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from Application where name = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getName());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
