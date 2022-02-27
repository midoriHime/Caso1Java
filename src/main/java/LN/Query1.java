/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LN;
import java.sql.*;
/**
 *
 * @author Kelly Villalobos
 * Clase extendida de la clase Thread que permite realizar las ejecuciones de cada consulta
 * en un hilo distinto y medir los tiempos utilizando las propiedadas heredadas de Thread
 */
public class Query1 extends Thread{
    
    //Intancia de la clase ConexionPool que realiza la conexion a BD 
    AD.Conexion conexion;
    
    // Constructor de clase que recibe el nombre dado al hilo el cual corresponde al 
    // canton a consultar
    public Query1(String nombre)
    {
       //asigna el nombre a su extencion
        super(nombre);
        //crea la conexion al la capa AD
       conexion = new AD.Conexion();      
       
    }
    /*
    Se sobre escribe el metodo run Thread para que realice la accion destinada de la consulta
    */
    @Override
    public void run()
    {
         try
         {
             
           //Define variables para control del tiempo  
            long duracion,inicio,fin;
            //toma el tiempo de inicio de proceso
            inicio= System.currentTimeMillis();
            //realiza llamada a AD para ejecutar la consulta
            ResultSet resultado = conexion.query1(getName());
             //toma el tiempo final de ejecucion de consulta
            fin= System.currentTimeMillis();
            //hace al diferencia para tomar el tiempo de duracion
            duracion=fin-inicio;
            //Verifica que existan datos
           if (!resultado.wasNull())
                {
                    //Variable que almacena los resultados a imprimir en pantalla
                    //esto para evitar que se sobrepongan los datos de los otros hilos
                    String salida ="Terminado canton " + getName() + " Tiempo: " + String.valueOf(duracion);
                   //Recorre el resultset
                    while (resultado.next())
                    {
                        //Define las variables de datos para mayor claridad de codigo
                        String partido, descripcion,ente,kpi;
                        //Asigna el nombre del partido
                        partido=resultado.getString(1);
                        //Asigna la descripcion de entregable
                        descripcion=resultado.getString(3);
                        //asigna el valor del KPI
                        kpi= resultado.getString(4);
                        //Asigna el valor del ente de KPI
                        ente=resultado.getString(5);
                        //Construuye la salida
                        salida = salida + "\n"+partido + "\t"+descripcion+"\t"+kpi+"\t"+ente;
                    }
                    //Imprime en pantalla la salida
                    System.out.println(salida);
                }
                else
                {
                    System.out.println("No se encontraron entregables");
                }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }    
   
}
