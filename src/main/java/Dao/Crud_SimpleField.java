/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controlador.Field;
import Vo.Form;
import Vo.SimpleField;
import Vo.ViemContainer;
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
public class Crud_SimpleField {

    public List<SimpleField> findAll() throws SQLException {
        List<SimpleField> departamentos = null;
        String query = "SELECT * FROM SimpleField";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id;
            String nombre;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<SimpleField>();
                }

                Form fo = new Form(rs.getString("Name"));
                SimpleField registro = new SimpleField(fo, rs.getString("Type1"), rs.getString("helpmessage"), rs.getString("comment1"), rs.getString("initialValue"));
                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(SimpleField t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
              
        
        String query = " insert into SimpleField (Name,Type1,helpmessage,comment1,initialValue,editionMask,defaultValue,ValidationMessage) " + "values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = null;

        ViemContainer reg = new ViemContainer();
        Form fo = new Form(reg.getName());
        Field fr = new Field() {
        };
        String name=String.valueOf(t.getName());

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, fr.getType());
            preparedStmt.setString(3, fr.getHelpmessage());
            preparedStmt.setString(4, fr.getComment());
            preparedStmt.setString(5, fr.getInitialValue());
            preparedStmt.setString(6, t.getEditionMask());
            preparedStmt.setString(7, t.getDefaultValue());
            preparedStmt.setString(8, t.getValidationMessage());

            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(SimpleField t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update SimpleField set name = ? where name = ?";
        PreparedStatement preparedStmt = null;
        ViemContainer reg = new ViemContainer();
        Form fo = new Form(reg.getName());
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, fo.getName());
            preparedStmt.setString(2, fo.getName());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(SimpleField t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from SimpleField where name = ?";
        PreparedStatement preparedStmt = null;
        ViemContainer reg = new ViemContainer();
        Form fo = new Form(reg.getName());
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, fo.getName());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
