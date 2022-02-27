/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

/**
 *
 * @author moig1
 */
public class Provincia {
    
    
    private int IdProvincia;
    private String Nombre;
    private String CodProvincia;
    private AD.Canton[] Cantones;
   
    public int getIdProvincia() {
        return IdProvincia;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getCodProvincia() {
        return CodProvincia;
    }
    public void setCodProvincia(String CodProvincia) {
        this.CodProvincia = CodProvincia;
    }
    public  Canton[] getCantones()
    {
        return this.Cantones;
    }
    
    public void setCantones(Canton[] lista)
    {
        this.Cantones=lista;
    }
 
}
