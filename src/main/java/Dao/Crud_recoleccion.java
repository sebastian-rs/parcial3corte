/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Vo.recoleccionfi;
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
public class Crud_recoleccion {

    public List<recoleccionfi> findAll() throws SQLException {
        List<recoleccionfi> departamentos = null;
        String query = "SELECT * FROM recoleccionfi";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            String Fecha;
            String Recolector;
            String Colmena;
            int Kilosdemiel;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<recoleccionfi>();
                }

                recoleccionfi registro = new recoleccionfi();

                Fecha = rs.getString("Fecha");
                registro.setFecha(Fecha);

                Recolector = rs.getString("Recolector");
                registro.setRecolector(Recolector);

                Colmena = rs.getString("Colmena");
                registro.setColmena(Colmena);

                Kilosdemiel = rs.getInt("Kilosdemiel");
                registro.setKilosdemiel(Kilosdemiel);
                
                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(recoleccionfi t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into recoleccionfi (Fecha,Recolector,Colmena,Kilosdemiel) " + "values (?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getFecha());
            preparedStmt.setString(2, t.getRecolector());
            preparedStmt.setString(3, t.getColmena());
            preparedStmt.setInt(4, t.getKilosdemiel());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
//
//    public boolean update(Esquema t) throws SQLException {
//        boolean result = false;
//        Connection connection = Conexion.getConnection();
//        String query = "update Schemaa set NameSchema = ? where Idschema = ?";
//        PreparedStatement preparedStmt = null;
//        try {
//            preparedStmt = connection.prepareStatement(query);
//            preparedStmt.setString(1, t.getNameEsquema());
//            preparedStmt.setInt(2, t.getIdEsquema());
//            if (preparedStmt.executeUpdate() > 0) {
//                result = true;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    public boolean delete(Esquema t) throws SQLException {
//        boolean result = false;
//        Connection connection = Conexion.getConnection();
//        String query = "delete from Schemaa where Idschema = ?";
//        PreparedStatement preparedStmt = null;
//        try {
//            preparedStmt = connection.prepareStatement(query);
//            preparedStmt.setInt(1, t.getIdEsquema());
//            result = preparedStmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }

}
