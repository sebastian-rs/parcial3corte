/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author JCBOT
 */
public abstract class ViemElement {
    
    private String name;

    public ViemElement(String name) {
        this.name = name;
    }

    public ViemElement() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
