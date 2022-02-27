/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

/**
 *
 * @author moig1
 */
public class PlanDG {
    
    private int IdPlan;
    private Partido PartidoP;
    private String Descripcion;
    
   
    public int getIdPlan() {
        return IdPlan;
    }
    public Partido getPartidoP() {
        return PartidoP;
    }
    public void setPartido(Partido partido) {
        this.PartidoP = partido;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }  
    
}
