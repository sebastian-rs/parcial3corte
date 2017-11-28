/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vo;

import Controlador.Field;

/**
 *
 * @author JCBOT
 */
public class SelectionField extends Field {

    public boolean isMultiSelection;

    public SelectionField(Form Name, String Type, String helpmessage, String comment, String initialValue) {
        super(Name, Type, helpmessage, comment, initialValue);
    }

    public SelectionField() {
  
    }

    public boolean isIsMultiSelection() {
        return isMultiSelection;
    }

    public void setIsMultiSelection(boolean isMultiSelection) {
        this.isMultiSelection = isMultiSelection;
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
