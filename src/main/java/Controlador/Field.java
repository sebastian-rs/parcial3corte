/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vo.Form;

/**
 *
 * @author JCBOT
 */
public abstract class Field {

    protected Form Name;
    protected String Type;
    protected String helpmessage;
    protected String comment;
    public String initialValue;

    public Field(Form Name, String Type, String helpmessage, String comment, String initialValue) {
        this.Name = Name;
        this.Type = Type;
        this.helpmessage = helpmessage;
        this.comment = comment;
        this.initialValue = initialValue;
    }

    public Field() {
    }
    
    

    public Form getName() {
        return Name;
    }

    public void setName(Form Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getHelpmessage() {
        return helpmessage;
    }

    public void setHelpmessage(String helpmessage) {
        this.helpmessage = helpmessage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }
    
    


 
    
    

}
