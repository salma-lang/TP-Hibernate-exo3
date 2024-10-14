/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employe {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      protected int id;
      protected String nom;
      protected String prenom;
      protected String telephone;
      
      
       
        @OneToMany(mappedBy = "employe")
     private List<EmployeTache>EmployeTaches;

    public Employe() {
    }
    
        

    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    

    public List<EmployeTache> getEmployeTaches() {
        return EmployeTaches;
    }

    public void setEmployeTaches(List<EmployeTache> EmployeTaches) {
        this.EmployeTaches = EmployeTaches;
    }
    
                
    

    
    
}
