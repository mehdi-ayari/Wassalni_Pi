/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

/**
 *
 * @author user
 */
public class Reclamation {
    private int id;
    private String titre;
    private String description;
    private int idclt;

    public Reclamation(int id, String titre, String description, int idclt) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.idclt = idclt;
    }

    public Reclamation() {
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getIdclt() {
        return idclt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdclt(int idclt) {
        this.idclt = idclt;
    }

    public Reclamation(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", idclt=" + idclt + '}';
    }
    
}
