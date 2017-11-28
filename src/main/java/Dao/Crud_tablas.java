/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Vo.Esquema;
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
public class Crud_tablas {

    public List<Tabla> findAll() throws SQLException {
        List<Tabla> departamentos = null;
        String query = "SELECT * FROM tablee";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id;
            String nombre;
            int id2 = 0;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Tabla>();
                }

                Tabla registro = new Tabla();
                id = rs.getInt("IdTable");
                registro.setIdTabla(id);

                nombre = rs.getString("NameTable");
                registro.setNameTabla(nombre);

                id2 = rs.getInt("Idschema2");
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

    public boolean insert(Tabla t) throws SQLException, IOException, ClassNotFoundException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into tablee (IdTable,NameTable,Idschema2) " + "values (?,?,?)";
        PreparedStatement preparedStmt = null;
        Crud_esquemas esq = new Crud_esquemas();
        List<Esquema> esquemas = esq.findAll();
        int decision = esquemas.size();
        decision = decision-1;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdTabla());
            preparedStmt.setString(2, t.getNameTabla());
            preparedStmt.setInt(3, esquemas.get(decision).getIdEsquema());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Tabla t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update tablee set NameTable = ? where IdTable = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getNameTabla());
            preparedStmt.setInt(2, t.getIdTabla());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(Tabla t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from tablee where IdTable = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdTabla());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
