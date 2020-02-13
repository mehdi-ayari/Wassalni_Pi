/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.implement;
import com.esprit.Iservice.IService;
import com.esprit.entities.News;
import com.esprit.utilities.DataBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.PdfWriter;
import doryan.windowsnotificationapi.fr.Notification;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class ServiceNews implements IService<News> {

    String tri = " ORDER BY titre " ;
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
        tri = " ORDER BY titre ";
        }
  /*  public void triByDateDebut() { 
        tri = " ORDER BY dateD ";
        }
    public void triByDateFin() { 
        tri = " ORDER BY dateF ";
        }
   */
    private Connection con;
    private Statement ste;

    public ServiceNews() {
        con = DataBase.getInstance().getConnection();

    }
   
    @Override
    public void ajouter(News t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `wassalni`.`news` (`titre`, `desc`, `comm`, `image`) VALUES ('" + t.getTitre() + "', '" + t.getDesc() + "', '" + t.getComm() + "', '" + t.getImage() + "');";
        ste.executeUpdate(requeteInsert);   
    }
    public void ajouter1(News n) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `wassalni`.`news` ( `titre`, `desc`, `comm`, `image`) VALUES ( ?, ?, ?, ?);");
    pre.setString(1, n.getTitre());
    pre.setString(2, n.getDesc());
    pre.setString(3, n.getComm());
    pre.setString(4, n.getImage());
    pre.executeUpdate();
    }
            

    @Override
    public boolean delete(News t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `wassalni`.`news` WHERE titre=? ;");
                 pre.setString(1, t.getTitre());
                 if (pre.executeUpdate()!=0 )
                 {System.out.println ("NEWS Deleted");
            try {
                Notification.sendNotification("module News", "NEWS DELETED ",TrayIcon.MessageType.INFO);
            } catch (AWTException | MalformedURLException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            }
                         return true ;
                         }
                 System.out.println("Titre News not found!!!");
                 return false ;
    }

    public boolean update(String titre,String image) throws SQLException, AWTException, MalformedURLException {
    PreparedStatement pre=con.prepareStatement("UPDATE `wassalni`.`news` SET IMAGE = ? WHERE titre=? ;");
            pre.setString(1,image);
            pre.setString(2,titre);
             if (pre.executeUpdate()!=0 )
                 {System.out.println ("News Updated");
                 Notification.sendNotification("module News", "NEWS UPDATED ",TrayIcon.MessageType.INFO);
                         return true ;
                         }
                 System.out.println("TITRE NEWS not found!!!");
                 return false ;
    }

    @Override
    public List<News> readAll() throws SQLException {
    List<News> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from news"+ tri + ordre);
     while (rs.next()) {                
               int id_news=rs.getInt(1);
               String titre=rs.getString("titre");
               String desc=rs.getString("desc");
               String comm=rs.getString("comm");
               String image=rs.getString("image");
               News n=new News(titre, desc, comm, image);
     arr.add(n);
     }
    return arr;
    }
     @Override
    public boolean update(News t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
