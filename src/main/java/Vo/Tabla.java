/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vo;

/**
 *
 * @author JCBOT
 */
public class Tabla {

    private int IdTabla;
    private String NameTabla;
    private int Desicion;

    public Tabla(int IdTabla, String NameTabla, int Desicion) {
        this.IdTabla = IdTabla;
        this.NameTabla = NameTabla;
        this.Desicion = Desicion;
    }

    public Tabla() {
    }

    public int getIdTabla() {
        return IdTabla;
    }

    public void setIdTabla(int IdTabla) {
        this.IdTabla = IdTabla;
    }

    public String getNameTabla() {
        return NameTabla;
    }

    public void setNameTabla(String NameTabla) {
        this.NameTabla = NameTabla;
    }

    public int getDesicion() {
        return Desicion;
    }

    public void setDesicion(int Desicion) {
        this.Desicion = Desicion;
    }

}
