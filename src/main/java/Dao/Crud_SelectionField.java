/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controlador.ViemElement;
import Vo.Form;
import Vo.SelectionField;
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
public class Crud_SelectionField {

    public List<SelectionField> findAll() throws SQLException {
        List<SelectionField> departamentos = null;
        String query = "SELECT * FROM SelectionField";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String Name;
            String Type1;
            String helpmessage;
            String comment1;
            String initialValue;
            boolean isMultiSelection;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<SelectionField>();
                }

                SelectionField registro = new SelectionField();
                ViemContainer reg = new ViemContainer();

                Name = rs.getString("Name");
                Form fo = new Form(Name);
                registro.setName(registro.getName());

                Type1 = rs.getString("Type1");
                registro.setType(Type1);

                helpmessage = rs.getString("helpmessage");
                registro.setHelpmessage(helpmessage);

                comment1 = rs.getString("comment1");
                registro.setComment(comment1);

                initialValue = rs.getString("initialValue");
                registro.setInitialValue(initialValue);

                isMultiSelection = rs.getBoolean("isMultiSelection");
                registro.setIsMultiSelection(isMultiSelection);
                

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(SelectionField t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into SelectionField (Name,Type1,helpmessage,comment1,initialValue,isMultiSelection) " + "values (?,?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        ViemElement vi = new ViemElement() {
        };
        Form fo = new Form(vi.getName());

        String name = String.valueOf(t.getName());
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, t.getType());
            preparedStmt.setString(3, t.getHelpmessage());
            preparedStmt.setString(4, t.getComment());
            preparedStmt.setString(5, t.getInitialValue());
            preparedStmt.setBoolean(6, t.isIsMultiSelection());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(SelectionField t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update SelectionField set Name = ? where Name = ?";
        PreparedStatement preparedStmt = null;
        ViemElement vi = new ViemElement() {
        };
        Form fo = new Form(vi.getName());
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

    public boolean delete(SelectionField t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from SelectionField where Name = ?";
        PreparedStatement preparedStmt = null;
        ViemElement vi = new ViemElement() {
        };
        Form fo = new Form(vi.getName());
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
