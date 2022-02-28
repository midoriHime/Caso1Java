/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author moig1
 */
public class Consultas {
    
     /**
     * Realiza la ejecucion del stored procedura del query1 y retorna el resultado
     * como un resultset
     * Parametros: Nombre del canton a consultar
    */
    public  ResultSet query1(String canton)
    {
        Connection conn = null;
        ConexionPool pool = new ConexionPool(1);
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
    
      public ResultSet query2(ConexionPool pool)
       {

         //Crea el string de ejecucion de procedimiento con el canton especificado
       String sql = "DECLARE @TOTAL INT " 
                   +"SELECT @TOTAL = COUNT(ID_PARTIDO) FROM PARTIDO "
                   +"SELECT  B.NOMBRE AS CANTON,"
                   +"COUNT(A.ID_CANTON)AS ENTREGABLES "
                   +"FROM ENTREGABLE A"
                   +"     INNER JOIN"
                   +"     CANTON B ON A.ID_CANTON = B.ID_CANTON "
                   +"GROUP BY B.NOMBRE "
                   +"HAVING @TOTAL * 0.25 >= COUNT(DISTINCT A.ID_PARTIDO) "
                   +"ORDER BY 1,2";

       ResultSet resultSet = null;
       Connection conn = null;
      //ConexionPool pool = new ConexionPool(2);
       try
       {
           conn = pool.getConnection();
           Statement statement = conn.createStatement();
           resultSet = statement.executeQuery(sql);
           pool.liberaConexion(conn);
           return resultSet;
       }                
       catch (SQLException e) {
           System.out.println(e.getMessage());
           return null;
       }       


   }
      
      
    
}
