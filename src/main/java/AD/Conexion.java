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
         //Define la cadena de conexion a BD
         String connectionUrl =
                "jdbc:sqlserver://NEWPORT\\SQLEXPRESS01:55860; "
                        + "database=ASENI;"
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
    /**
     * Realiza la ejecucion del stored procedura del query1 y retorna el resultado
     * como un resultset
     * Parametros: Nombre del canton a consultar
    */
    public  ResultSet query1(String canton)
    {
        ConectarBD();
        //Crea el string de ejecucion de procedimiento con el canton especificado
        String sql = "EXEC dbo.ListarEntregablesXCanton @canton = N'" + canton + "'; ";
        //Inicializa la variable de resultados
        ResultSet resultado = null;

        try
        {
            //Crea la instruccion a ejecutar
            Statement instruccion = conexion.createStatement();
            //Ejecuta la instruccion y asigna el valor a resultado
            resultado = instruccion.executeQuery(sql);
            //retorna el resultado
            return resultado;
        }                
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    
}
