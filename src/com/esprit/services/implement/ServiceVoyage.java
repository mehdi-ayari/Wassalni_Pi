/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.implement;

/**
 *
 * @author jawha
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.esprit.entities.Voyage;
import com.esprit.utilities.DataBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import doryan.windowsnotificationapi.fr.Notification;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jawha
 */
public class ServiceVoyage {

   
    private Connection con;
    private Statement ste;
    String tri = " ORDER BY PrixVoyage " ;
    String ordre = " ASC" ;
    public void ordreASC () {
        ordre = " ASC" ; 
    }
     public void ordreDESC () {
        ordre = " DESC" ; 
    }
    
   /* public void triByPrix() { 
        tri = " ORDER BY prix ";
        }
    */
     public void triByTitre() { 
        tri = " ORDER BY PrixVoyage ";
        }

    public ServiceVoyage() {
        con=DataBase.getInstance().getConnection();
    }

    public void AjouterVoyage(Voyage V) throws SQLException{
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `wassalni`.`voyage` ( `DebutVoyage` ,`prixVoyage`,`Destination`) VALUES (SYSDATE() , '" + V.getPrixVoyage() + "', '" +V.getDestination()+ "');";
        ste.executeUpdate(requeteInsert);
    }

    public void SupprimerVoyage(Voyage V) throws SQLException{
        ste = con.createStatement();
        String requeteDelete = "DELETE FROM `wassalni`.`voyage` WHERE `Destination` = '"+V.getDestination()+"';" ;
        ste.executeUpdate(requeteDelete);
    }
    
public boolean update(String Destination,float prixVoyage) throws SQLException, AWTException, MalformedURLException {
    PreparedStatement pre=con.prepareStatement("UPDATE wassalni.`voyage` SET prixVoyage = ? WHERE Destination =? ;");
            pre.setFloat(1,prixVoyage);
            pre.setString(2,Destination);
             if (pre.executeUpdate()!=0 )
                 {System.out.println ("Price Updated");
                 Notification.sendNotification("module Voyage", "Voyage modifier ",TrayIcon.MessageType.INFO);
                         return true ;
                         }
                 System.out.println("Destination not found!!!");
                 return false ;
    }
    
        public List<Voyage> readAll() throws SQLException {
    List<Voyage> Voy=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from Voyage"+ tri + ordre);
     while (rs.next()) {                
               String DebutVoy = rs.getString("DebutVoyage");
               float prix=rs.getFloat("prixVoyage");
               String Dest=rs.getString("Destination");
               Voyage V=new Voyage( DebutVoy , prix,Dest);
     Voy.add(V);
     }
    return Voy;
    }
        public void pdf() throws DocumentException
    {
        try {
            String file_name ="C:\\Users\\jawha\\OneDrive\\Bureau\\jawhar.pdf";
            Document document = new Document();
            //file_name.setReadable(true,false);
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            PreparedStatement pt = con.prepareStatement("select * from voyage");
            ResultSet rs = pt.executeQuery();
            
            while (rs.next()) { 
                Paragraph para=new Paragraph("voyage [ id_voyage: " +rs.getInt(1) + " DebutVoyage : " + rs.getString(2) + " prixVoyage: " + rs.getFloat(3)+" Destination: " + rs.getString(4)+"]");
                //System.out.println("garage [ id_garage: " +rs.getInt(1) + " name : " + rs.getString(2) + " Address: " + rs.getString(3)+" id_service: " + rs.getInt(4)+"]");
                document.add(para);
                document.add(new Paragraph(" "));
            }
            document.close();
        } catch (SQLException | DocumentException | FileNotFoundException ex) {
            Logger.getLogger(Voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
}}

    

