/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

/**
 *
 * @author moig1
 */
public class Partido {
    
    private int IdPartido;
    private String Nombre;
    private String Acronimo;
    private String Bandera;
    
   
    public int getIdPartido() {
        return IdPartido;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getAcronimo() {
        return Acronimo;
    }
    public void setAcronimo(String acronimo) {
        this.Acronimo = acronimo;
    }
    public  String getBandera()
    {
        return this.Bandera;
    }
    
    public void setBandera(String bandera)
    {
        this.Bandera=bandera;
    }
}
