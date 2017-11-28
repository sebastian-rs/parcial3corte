/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vo;

import Controlador.ViemElement;

/**
 *
 * @author JCBOT
 */
public class ViemContainer extends ViemElement{
    
    public boolean isLandMark;
    public boolean isDefault;
    public boolean isXOR;
    public boolean Protected;
    
    
    public ViemContainer(String name) {
        super(name);
    }

    public ViemContainer() {
    
    }

    public boolean isIsLandMark() {
        return isLandMark;
    }

    public void setIsLandMark(boolean isLandMark) {
        this.isLandMark = isLandMark;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean isIsXOR() {
        return isXOR;
    }

    public void setIsXOR(boolean isXOR) {
        this.isXOR = isXOR;
    }

    public boolean isProtected() {
        return Protected;
    }

    public void setProtected(boolean Protected) {
        this.Protected = Protected;
    }
    
    
    
   
    
    
    
}
