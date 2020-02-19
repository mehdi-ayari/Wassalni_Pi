/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.implement;

import com.esprit.entities.Reclamation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ReclamationService {
    
    private Connection con;
    private Statement ste;
     public void ajouter(Reclamation R) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `wassalnipi`.`reclamations` (`id`, `titre`, `description`, `idclt`) VALUES (NULL, '" + R.getTitre() + "', '" + R.getDescription() + "', '" + R.getIdclt() + "');";
        ste.executeUpdate(requeteInsert);
    }
     
        public void ModifierReclamation(Reclamation R) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "UPDATE reclamations SET titre ='"+R.getTitre()+"',description='"+R.getDescription()+"' WHERE reclamation.id='"+R.getId()+"';";
        ste.executeUpdate(requeteInsert);
    }
        
           public void SupprimerReclamation(Reclamation R) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "DELETE FROM reclamations  WHERE reclamation.id='"+R.getId()+"'; ";
        ste.executeUpdate(requeteInsert);
    }
                   public List<Reclamation> AfficherReclamation(Reclamation R) throws SQLException {
       List<Reclamation> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reclamations");
     while (rs.next()) {                
               int id=rs.getInt("id");
               String titre=rs.getString("titre");
               String prenom=rs.getString("description");
               
               Reclamation p=new Reclamation(id, titre, prenom);
     arr.add(p);
     }
    return arr;
    }
    }  

