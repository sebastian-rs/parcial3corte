/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controlador.InterectionFlow;
import Controlador.ViemElement;
import Vo.Parameter;
import Vo.ParameterBinding;
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
public class Crud_InterectionFlow {

    public List<InterectionFlow> findAll() throws SQLException {
        List<InterectionFlow> departamentos = null;
        String query = "SELECT * FROM InterectionFlow";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            String name;
            int id;
            String TypeEvent;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<InterectionFlow>();
                }

                ViemElement vi = new ViemElement(rs.getString("name")) {
                };
                Parameter pa1 = new Parameter();
                ParameterBinding pa = new ParameterBinding(pa1);
                InterectionFlow registro = new InterectionFlow(vi, pa, rs.getString("name")) {
                };

                name = rs.getString("name");
                registro.setName(vi);

                id = rs.getInt("id");
                registro.setId(pa);

                TypeEvent = rs.getString("TypeEvent");
                registro.setTypeEvent(TypeEvent);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(InterectionFlow t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();

        String query = " insert into InterectionFlow (name,id,TypeEvent) " + "values (?,?,?)";
        PreparedStatement preparedStmt = null;
        ViemContainer v12 = new ViemContainer();
        ViemElement vi = new ViemElement() {
        };
        Parameter pa1 = new Parameter();
        String name = String.valueOf(t.getName());

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, pa1.getId());
            preparedStmt.setString(3, t.getTypeEvent());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(InterectionFlow t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update InterectionFlow set name = ? where name = ?";
        PreparedStatement preparedStmt = null;
        ViemElement vi = new ViemElement() {
        };
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, vi.getName());
            preparedStmt.setString(2, vi.getName());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(InterectionFlow t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from InterectionFlow where name = ?";
        PreparedStatement preparedStmt = null;
        ViemElement vi = new ViemElement() {
        };
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, vi.getName());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
