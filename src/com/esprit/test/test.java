/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.entities.News;
import com.esprit.services.implement.ServiceNews;
import java.awt.AWTException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class test {
    public static void main(String[] args) throws AWTException, MalformedURLException {
        ServiceNews ser = new ServiceNews();
//        ServicePromo ser2 = new ServicePromo();
        
  //      Promo p1= new Promo("reduction",25);
       News n1 = new News("AAAAD", "Fel blassa flenia", "Merci al commm","img");
       News n2 = new News("ZZAA", "F route X", "comm ekher","immmg");
       News n3 = new News("RAAAA", "F route X", "comm ekher","immmg");
        try {
//         
         //ser.ajouter1(n2);
       //   ser.delete(n2); 
          //ser.ajouter(n3);
          ser.update("Farah","BB");
           // ser2.ajouter(p1);
          ser.triByTitre();
          ser.ordreASC();
           System.out.println(ser.readAll());
            List<News> list = ser.readAll();
           // List<Promo> list2 = ser2.readAll();
         System.out.println(list);
           // System.out.println(list);
          
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
