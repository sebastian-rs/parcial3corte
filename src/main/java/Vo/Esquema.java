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
public class Esquema {
    
    private int IdEsquema;
    private String NameEsquema;
    private int Desicion;

    public Esquema(int IdEsquema, String NameEsquema,int Desicion) {
        this.IdEsquema = IdEsquema;
        this.NameEsquema = NameEsquema;
        this.Desicion=Desicion;
    }

    public Esquema() {
        
        
    }

    public int getIdEsquema() {
        return IdEsquema;
    }

    public void setIdEsquema(int IdEsquema) {
        this.IdEsquema = IdEsquema;
    }

    public String getNameEsquema() {
        return NameEsquema;
    }

    public void setNameEsquema(String NameEsquema) {
        this.NameEsquema = NameEsquema;
    }

    public int getDesicion() {
        return Desicion;
    }

    public void setDesicion(int Desicion) {
        this.Desicion = Desicion;
    }
    
    
    
    
    
    
    
}
