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
public class Columna {
    
    private int IdColumna;
    protected String NameColumna;
    protected String Type;
    protected int size;
    private String defaultValue;
    private boolean isRequired;
    private boolean accepNull;
    protected String alias;
    protected String comment;
    protected String helpmessage;
    private int Desicion;

    public Columna(int IdColumna, String NameColumna, String Type, int size, String defaultValue, boolean isRequired, boolean accepNull, String alias, String comment, String helpmessage, int Desicion) {
        this.IdColumna = IdColumna;
        this.NameColumna = NameColumna;
        this.Type = Type;
        this.size = size;
        this.defaultValue = defaultValue;
        this.isRequired = isRequired;
        this.accepNull = accepNull;
        this.alias = alias;
        this.comment = comment;
        this.helpmessage = helpmessage;
        this.Desicion = Desicion;
    }

    public Columna() {
    }
    
    
    public int getIdColumna() {
        return IdColumna;
    }

    public void setIdColumna(int IdColumna) {
        this.IdColumna = IdColumna;
    }

    public String getNameColumna() {
        return NameColumna;
    }

    public void setNameColumna(String NameColumna) {
        this.NameColumna = NameColumna;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isIsRequired() {
        return isRequired;
    }

    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public boolean isAccepNull() {
        return accepNull;
    }

    public void setAccepNull(boolean accepNull) {
        this.accepNull = accepNull;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHelpmessage() {
        return helpmessage;
    }

    public void setHelpmessage(String helpmessage) {
        this.helpmessage = helpmessage;
    }

    public int getDesicion() {
        return Desicion;
    }

    public void setDesicion(int Desicion) {
        this.Desicion = Desicion;
    }

    
    
    
    
    
}
