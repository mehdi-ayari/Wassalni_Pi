/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

/**
 *
 * @author ASUS
 */
public class Promo {
    int id_promo;
    String code_promo;
    float pourc;
    String dateD;
    String dateF;

    public Promo(String code_promo, float pourc, String dateD, String dateF) {
        //this.id_promo = id_promo;
   
        this.code_promo = code_promo;
        this.pourc = pourc;
        this.dateD = dateD;
        this.dateF = dateF;
    }

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public String getCode_promo() {
        return code_promo;
    }

    public void setCode_promo(String code_promo) {
        this.code_promo = code_promo;
    }

    public float getPourc() {
        return pourc;
    }

    public void setPourc(float pourc) {
        this.pourc = pourc;
    }

    public String getDateD() {
        return dateD;
    }

    public void setDateD(String dateD) {
        this.dateD = dateD;
    }

    public String getDateF() {
        return dateF;
    }

    public void setDateF(String dateF) {
        this.dateF = dateF;
    }
    

}