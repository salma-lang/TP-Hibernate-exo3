/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EmployeTache {
    
     @EmbeddedId
    private EmployeTacheId pk;
     
     
      @Temporal(TemporalType.DATE)
    private Date dateDebutReelle;
      
        @Temporal(TemporalType.DATE)
    private Date dateFinReelle;
      
        @ManyToOne
     @JoinColumn(name = "employeId", insertable = false, updatable = false)
     private Employe employe;
    
    @ManyToOne
     @JoinColumn(name = "TacheId", insertable = false, updatable = false)
    private Tache tache;

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle, Employe employe, Tache tache) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public EmployeTacheId getPk() {
        return pk;
    }

    public void setPk(EmployeTacheId pk) {
        this.pk = pk;
    }

   

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
    
    
}
