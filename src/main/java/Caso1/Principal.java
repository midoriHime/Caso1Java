/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Caso1;

/**
 *
 * @author Kelly Villalobos Baez
 */
public class Principal {
    
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
            Thread[] hilosCreados = new Thread[10];
            for (int i = 0; i < 10; i++) {
                LN.Query2 hilo = new LN.Query2("Hilo "+ Integer.toString(i));                   
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
    
    public static void main(String[] args){
    try
    {
        //HACER LLAMADA A QUERY 1 USANDO 10 HILOS
        query1();
       // query2();
       
        
    }
    catch(Exception e)
    {
    }
  }
}
