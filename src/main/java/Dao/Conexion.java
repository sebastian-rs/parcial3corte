package Dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.*;

public class Conexion {

    private static Connection CONEXION = null;

    public static Connection getConnection() throws SQLException {
        if (CONEXION == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //Integracion Log4J
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            } catch (InstantiationException e) {
                //Integracion Log4J
                throw new SQLException(e);
            } catch (IllegalAccessException e) {
                //Integracion Log4J
                throw new SQLException(e);
            }

            try {
                CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcialito", "root", "root");
                System.out.println("voy");
            } catch (SQLException e) {
                throw new SQLException(e);
            }

        }

        return CONEXION;
    }

    public static void closeConnection() throws SQLException {
        try {
            if (CONEXION != null) {
                CONEXION.close();
                CONEXION = null;
            }

        } catch (SQLException e) {
            //Integracion Log4J
            throw new SQLException(e);
        }

    }

    public long tamanio;

    public boolean escribir(int id) throws FileNotFoundException, IOException {

        RandomAccessFile Esquema
                = new RandomAccessFile("Esquemasid10.txt", "rw");

        tamanio = Esquema.length();
        Esquema.seek(tamanio);
        Esquema.writeInt(id);

        return true;
    }

    public boolean escribir2(int id) throws FileNotFoundException, IOException {

        RandomAccessFile Esquema
                = new RandomAccessFile("Tablasid10.txt", "rw");

        tamanio = Esquema.length();
        Esquema.seek(tamanio);
        Esquema.writeInt(id);

        return true;
    }

    public int leer() throws IOException, ClassNotFoundException {

        RandomAccessFile Esquema
                = new RandomAccessFile("Esquemasid10.txt", "rw");

        tamanio = Esquema.length();
        int numeroIteraciones = (int) tamanio / 4;
        Esquema.seek(0);
        int temp = 0;
        for (int i = 0; i < numeroIteraciones; i++) {
            temp = Esquema.readInt();;
        }

        return temp;
    }

    public int leer2() throws IOException, ClassNotFoundException {

        RandomAccessFile Esquema
                = new RandomAccessFile("Tablasid10.txt", "rw");

        tamanio = Esquema.length();
        int numeroIteraciones = (int) tamanio / 4;
        Esquema.seek(0);
        int temp = 0;
        for (int i = 0; i < numeroIteraciones; i++) {
            temp = Esquema.readInt();;
        }

        return temp;
    }

}
