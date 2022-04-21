/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Livres;

import java.io.Serializable;

/**
 *
 * @author khayatti
 */
    public class livres implements Serializable{
    private String code;
    private String titre;
    private String auteur;    

 public livres(String code,String titre,String auteur) {
        this.code = code;
        this.titre = titre;
        this.auteur = auteur;        
    }
 public String getCode() {return this.code;}

 public String getTitre() {return this.titre;}

 public String getAuteur() {return this.auteur;}
  
}

