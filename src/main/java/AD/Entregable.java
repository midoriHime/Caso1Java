/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
/**
 *
 * @author Kelly Villalobos Baez
 */
public class Entregable implements Serializable{
    
    private int IdEntregable;
    private Accion Accion;
    private Partido Partido;
    private Canton  Canton;
    private String Descripcion;
    private String FechaEntrega;
    private int Kpi;
    private String Ente;
   
    public int getIdEntregable() {
        return IdEntregable;
    }
    public Accion getAccion() {
        return Accion;
    }
    public void setAccion(Accion accion) {
        this.Accion = accion;
    }
    public Partido getPartido() {
        return Partido;
    }
    public void setPartido(Partido partido) {
        this.Partido = partido;
    }  
    public Canton getCanton()
    {
        return Canton;
    }
    public void setCanton(Canton canton)
    {
        this.Canton=canton;
    }
      public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }  
    public String getFechaEntrega()
    {
        //Fecha en formato SHORT: 6/10/12
        DateFormat formateadorFechaCorta = DateFormat.getDateInstance(DateFormat.SHORT);
        return formateadorFechaCorta.format(FechaEntrega);
    }
    public void setFechaEntrega(String fecha)
    {
        this.FechaEntrega=fecha;
    }
    public int getKpi()
    {
        return Kpi;
    }
    public void setKpi(int kpi)
    {
        this.Kpi=kpi;
    }
    public String getEnte()
    {
        return Ente;
    }
    public void setEnte(String Ente)
    {
        this.Ente=Ente;
        
    }
    @Override
    public String toString() {
      return "Entregable { "
             + " Accion: " + this.Accion.getDescripcion()
             + ", Canton: " + this.Canton.getNombre()
             + ", Partido: " + this.Partido.getNombre()
             + ", Entregable: " + this.Descripcion
             + ", Fecha de Entrega: " + this.FechaEntrega
             + ", KPI: " + this.Kpi
             + ", Ente: " + this.Ente
             +" }";
   }
    
}
