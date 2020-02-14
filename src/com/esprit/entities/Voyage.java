/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jawha
 */
public class Voyage {
    private int id_Voyage;
    private int temps;
    private String DebutVoyage;
    private float prixVoyage;
    private String Destination;   
    

    public Voyage() {
    }

    public Voyage(String DebutVoyage, float prixVoyage, String Destination) {
        this.DebutVoyage = DebutVoyage;
        this.prixVoyage = prixVoyage;
        this.Destination = Destination;
    }
    
        public Voyage( int temps , float prixVoyage, String Destination) {
        this.temps=temps;
        this.prixVoyage = prixVoyage;
        this.Destination = Destination;
    }
    
    

    
    public int getTemps() {
        return temps;
    }

    public String getDestination() {
        return Destination;
    }

    public int getId_Voyage() {
        return id_Voyage;
    }

    public float getPrixVoyage() {
        return prixVoyage;
    }

    public void setTemps(int Temps) {
        this.temps = temps;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public void setId_Voyage(int id_Voyage) {
        this.id_Voyage = id_Voyage;
    }
    

    public void setPrixVoyage(float prixVoyage) {
        this.prixVoyage = prixVoyage;
    }

    public String getDebutVoyage() {
        return DebutVoyage;
    }

    public void setDebutVoyage(String DebutVoyage) {
        this.DebutVoyage = DebutVoyage;
    }


    
    
    
    
    
    
    
}
