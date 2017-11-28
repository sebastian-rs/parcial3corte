/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controlador.ViemElement;
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
public class Crud_ViemContainer {

    public List<ViemContainer> findAll() throws SQLException {
        List<ViemContainer> departamentos = null;
        String query = "SELECT * FROM ViemContainer";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String name = null;
            boolean isLandMark;
            boolean isDefault;
            boolean isXOR;
            boolean Protected;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<ViemContainer>();
                }

                ViemContainer registro = new ViemContainer();

                name = rs.getString("name");
                registro.setName(name);

                isLandMark = rs.getBoolean("isLandMark");
                registro.setIsLandMark(isLandMark);

                isDefault = rs.getBoolean("isDefault");
                registro.setIsDefault(isDefault);

                isXOR = rs.getBoolean("isXOR");
                registro.setIsXOR(isXOR);

                Protected = rs.getBoolean("Protected");
                registro.setProtected(Protected);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(ViemContainer t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into ViemContainer (name,isLandMark,isDefault,isXOR,Protected) " + "values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        ViemElement t1=new ViemElement() {};
        String name =String.valueOf(t1);
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setBoolean(2, t.isIsLandMark());
            preparedStmt.setBoolean(3, t.isIsDefault());
            preparedStmt.setBoolean(4, t.isIsXOR());
            preparedStmt.setBoolean(5, t.isProtected());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(ViemContainer t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update ViemContainer set name = ? where name = ?";
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

    public boolean delete(ViemContainer t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from ViemContainer where name = ?";
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
