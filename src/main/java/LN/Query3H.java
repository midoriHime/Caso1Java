/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LN;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
/**
 *
 * @author moig1
 */
public class Query3H {
    
        // Leer el archivo hibernate.cfg.xml
        Configuration cfg = new Configuration().configure();
        // Establecer SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
    
}
