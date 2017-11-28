/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Vo.Columna;
import Vo.Tabla;
import java.io.IOException;
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
public class Crud_Columna2 {

    public List<Columna> findAll() throws SQLException {
        List<Columna> departamentos = null;
        String query = "SELECT * FROM columnn";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id;
            String nombre;
            int id2 = 0;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Columna>();
                }

                Columna registro = new Columna();
                id = rs.getInt("IdColumn");
                registro.setIdColumna(id);

                nombre = rs.getString("NameColumn");
                registro.setNameColumna(nombre);

                id2 = rs.getInt("IdTable2");
                registro.setDesicion(id2);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(Columna t) throws SQLException, IOException, ClassNotFoundException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into columnn (IdColumn,NameColumn,IdTable2) " + "values (?,?,?)";
        PreparedStatement preparedStmt = null;

        Crud_tablas esq = new Crud_tablas();
        List<Tabla> tablas = esq.findAll();
        int decision = tablas.size();
        decision = decision-1;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdColumna());
            preparedStmt.setString(2, t.getNameColumna());
            preparedStmt.setInt(3, tablas.get(decision).getIdTabla());

            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Columna t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update columnn set NameColumn = ? where IdColumn = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getNameColumna());
            preparedStmt.setInt(2, t.getIdColumna());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(Columna t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from columnn where IdColumn = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdColumna());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
