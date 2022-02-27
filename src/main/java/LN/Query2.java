/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LN;

import AD.ConexionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kelly Villalobos
 * Clase extendida de la clase Thread que permite realizar las ejecuciones de cada consulta
 * en un hilo distinto y medir los tiempos utilizando las propiedadas heredadas de Thread
 */
public class Query2 extends Thread{
    
    //Intancia de la clase ConexionPool que realiza la conexion a BD utilizando un pool 
    // de conexiones definido
     AD.ConexionPool conexion;
    
    // Constructor de clase que recibe el nombre dado al hilo
    public Query2(String nombre)
    {
        //asigna el nombre a su extencion
       super(nombre);
       //crea la conexion al la capa AD con la cantidad de POOL  de conexiones
       conexion = new ConexionPool(2);      
       
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
            
            ResultSet res = conexion.query2();
            //toma el tiempo final de ejecucion de consulta
            fin= System.currentTimeMillis();
            //hace al diferencia para tomar el tiempo de duracion
            duracion=fin-inicio;
            
            
            //Variable que almacena los resultados a imprimir en pantalla
            //esto para evitar que se sobrepongan los datos de los otros hilos
            String salida;
            //Asigna el encabezado
            salida="Listado de entregables por canton para el 25% de partidos " + getName()
                    +"Tiempo: "+Long.toString(duracion);
            //recorre el resulset para listar los resultados
            while (res.next()) {
                    String canton = res.getString(0);
                    String entregable = res.getString(1);
                    salida = salida+"\n" + canton+"\t"+entregable;
            }	
            //imprime en pantalla
            System.out.println(salida);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
		
    }
    
}
