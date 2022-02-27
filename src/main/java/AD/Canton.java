/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

import java.io.Serializable;

/**
 *
 * @author moig1
 */
public class Canton implements Serializable{
   
    private int IdCanton;
    private String Nombre;
    private String CodCanton;
    
    public int getIdCanton() {
        return IdCanton;
    }
    
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getCodCanton() {
        return CodCanton;
    }
    public void setCodCanton(String codCanton) {
        this.CodCanton = codCanton;
    }
    public String toString() {
      return "Canton { "
             + ", Nombre: " + Nombre
             + ", Codigo: " + CodCanton
             +" }";
   }
    
 
}

