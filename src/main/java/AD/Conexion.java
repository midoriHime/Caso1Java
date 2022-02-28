/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

import java.sql.*;

/**
 *
 * @author moig1
 */
public class Conexion {

    //Define como variable de clase la conexion a base de datos
    private Connection conexion;
    
    
    
    public void  ConectarBD()
    {
     try
     {
         <add name="ConnectioName" connectionString="data source=TAVOPC;initial catalog=PoolDemo;integrated security=True;MultipleActiveResultSets=True;App=EntityFramework;
Connection Lifetime=120; Max Pool Size=20; Min Pool Size = 1; Pooling=True;" providerName="System.Data.SqlClient" />


         //Define la cadena de conexion a BD
         String connectionUrl =
                "jdbc:sqlserver://NEWPORT\\SQLEXPRESS01:55860; "
                        + "database=ASENI;"
                        + "user=sa;"
                        + "password=1234;"
           //             + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;"; 
                        + "user=sa;"
                        + "password=1234;"
           //             + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;"; 
                        
        //asigna la conexion a base de datos
        conexion = DriverManager.getConnection(connectionUrl);          
                    
    }
    catch (SQLException ex)
    {
        System.out.println("Ha ocurrido un error conectandose a la Base de Datos." + ex.getMessage());
    }
    }
   
    
    
}
