/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

/**
 *
 * @author moig1
 */
public class Accion {
    
    private int IdAccion;
    private PlanDG Plan;
    private String Descripcion;
    
   
    public int getIdAccion() {
        return IdAccion;
    }
    public PlanDG getPlanDG() {
        return Plan;
    }
    public void setPlanDG(PlanDG plan) {
        this.Plan = plan;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }  
    
}
