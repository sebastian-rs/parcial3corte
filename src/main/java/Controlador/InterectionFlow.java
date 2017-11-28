/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vo.ParameterBinding;

/**
 *
 * @author JCBOT
 */
public abstract class InterectionFlow {
    
    private ViemElement name;
    private ParameterBinding id;
    protected String TypeEvent;

    public InterectionFlow(ViemElement name, ParameterBinding id, String TypeEvent) {
        this.name = name;
        this.id = id;
        this.TypeEvent = TypeEvent;
    }

    public ViemElement getName() {
        return name;
    }

    public void setName(ViemElement name) {
        this.name = name;
    }

    public ParameterBinding getId() {
        return id;
    }

    public void setId(ParameterBinding id) {
        this.id = id;
    }

    public String getTypeEvent() {
        return TypeEvent;
    }

    public void setTypeEvent(String TypeEvent) {
        this.TypeEvent = TypeEvent;
    }

  


 
    
    
}
