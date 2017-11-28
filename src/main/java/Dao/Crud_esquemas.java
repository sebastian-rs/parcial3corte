/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Vo.Esquema;
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
public class Crud_esquemas {

    public List<Esquema> findAll() throws SQLException {
        List<Esquema> departamentos = null;
        String query = "SELECT * FROM Schemaa";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id;
            String nombre;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Esquema>();
                }

                Esquema registro = new Esquema();
                id = rs.getInt("Idschema");
                registro.setIdEsquema(id);

                nombre = rs.getString("NameSchema");
                registro.setNameEsquema(nombre);
                
              

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(Esquema t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Schemaa (Idschema,NameSchema) " + "values (?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdEsquema());
            preparedStmt.setString(2, t.getNameEsquema());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Esquema t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update Schemaa set NameSchema = ? where Idschema = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getNameEsquema());
            preparedStmt.setInt(2, t.getIdEsquema());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(Esquema t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from Schemaa where Idschema = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdEsquema());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
