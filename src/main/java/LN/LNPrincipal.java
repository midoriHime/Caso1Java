/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LN;

/**
 *
 * @author Kelly Villalobos Baez
 * Controla las llamadas 
 */
public class LNPrincipal {
    
    public static void query1()
    {
        try
        {
             String[] listaCantones = new String[] { "BAGASES", "ESCAZU", "BARVA" , "LA UNION", "LIMON", "PURISCAL" };
                Thread[] hilosCreados = new Thread[listaCantones.length];
                for (int i = 0; i < listaCantones.length-1; i++) {
                    LN.Query1 hilo = new LN.Query1(listaCantones[i]);                   
                    hilosCreados[i] = hilo;
                }  
                
                for(int i = 0; i < listaCantones.length-1; i++) 
                {
                    hilosCreados[i].start();
                }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void query2()
    {
       try
        {
            AD.ConexionPool conn= new AD.ConexionPool(2);
            Thread[] hilosCreados = new Thread[10];
            for (int i = 0; i < 10; i++) {
                LN.Query2 hilo = new LN.Query2("Hilo "+ Integer.toString(i),conn);                   
                hilosCreados[i] = hilo;
            }  

            for(int i = 0; i < 10; i++) 
            {
                hilosCreados[i].start();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }  
    }
    
}
