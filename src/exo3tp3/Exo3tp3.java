/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3tp3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.ChefDeProjet;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTacheId;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author hp
 */
public class Exo3tp3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     
       ProjetService projetService = new ProjetService();
        TacheService tacheService = new TacheService();
        EmployeService employeService = new EmployeService();
        EmployeTacheService employeTacheService = new EmployeTacheService();
        
        //Creer les employes 
            Employe e1 = new Employe("emp1","emp1","0661359278");
            employeService.create(e1);
            Employe e2 = new Employe("emp2","emp","06687502078");
            employeService.create(e2);
            
            
            //creer un chef de projet
            ChefDeProjet chef = new ChefDeProjet("c1", "chef1", "0652986797");
            employeService.create(chef);
         //Creer des projets
        
            Projet projet = new Projet("Gestion de stock", dateFormat.parse("15/10/2024"), dateFormat.parse("20/10/2024"));
            projet.setChefDeProjet(chef);
            projetService.create(projet);
         //Creer les taches
            Tache t1 = new Tache("Teste", 1000.0 ,dateFormat.parse("10/10/2024"),dateFormat.parse("19/12/2024"));
            t1.setProjet(projet);
            tacheService.create(t1);

            Tache t2 = new Tache("Développement",20000.0,dateFormat.parse("26/06/2024"), dateFormat.parse("17/10/2024"));
            t2.setProjet(projet);
            tacheService.create(t2);

            Tache t3 = new Tache("securite",30000.0, dateFormat.parse("05/07/2024"),dateFormat.parse("25/09/2024"));
            t3.setProjet(projet);
            tacheService.create(t3);
         //Creer employeTache
            EmployeTache et1 = new EmployeTache(dateFormat.parse("10/10/2024"),dateFormat.parse("19/12/2024"),e1, t1);
            et1.setPk(new EmployeTacheId(e1.getId(), t1.getId()));
            employeTacheService.create(et1);
            System.out.println("EmployeTache créé : " + e1.getNom() + " - " + t1.getNom());

            EmployeTache et2 = new EmployeTache(dateFormat.parse("26/06/2024"), dateFormat.parse("17/10/2024"),e1, t2);
            et2.setPk(new EmployeTacheId(e1.getId(), t2.getId()));
            employeTacheService.create(et2);
            System.out.println("EmployeTache créé : " + e1.getNom() + " - " + t2.getNom());
    
       
           //  Liste des tâches réalisées par un employé
            System.out.println("\n Liste des tâches réalisées par un employé :");
            List<Tache> tachesRealisees = employeService.getTachesRealisees(e1);
            for (Tache tache : tachesRealisees) {
                System.out.println(" - " + tache.getNom());
            }

       
         //Liste des projets gérés par un employé (chef de projet)
            System.out.println("\n Liste des projets gérés par un employé (chef de projet) :");
            List<Projet> projetsGeres = employeService.getProjetsGeres(chef);
            for (Projet p : projetsGeres) {
                System.out.println(" - " + p.getNom());
            }
         //Liste des taches planifiees pour un projet         
            System.out.println("\nListe des tâches planifiées pour un projet :");
            List<Tache> tachesPlanifiees = projetService.getTachesPlanifiees(projet);
            for (Tache tache : tachesPlanifiees) {
                System.out.println(" - " + tache.getNom() + " (du " + dateFormat.format(tache.getDateDebut()) + " au " + dateFormat.format(tache.getDateFin()) + ")");
            }

         // Liste des tâches réalisées dans un projet
          System.out.println("\nListe des tâches réalisées dans un projet :");
          System.out.println("\nProjet: " +projet.getId()+"   Nom : "+projet.getNom()+"    Date Début :"+ dateFormat.format(projet.getDateDebut()) + ")");
            List<Tache> tachesRealiseesDansProjet = projetService.getTachesRealisees(projet);
            for (Tache tache : tachesRealiseesDansProjet) {
                System.out.println( "\n -Nom: " + tache.getNom() +"    Date Début Réelle : "+tache.getDateDebut()+"   Date Fin réelle : "+tache.getDateFin());
            }
        
            
          //Liste des tâches dont le prix est supérieur à 1000 DH
         System.out.println("\nListe des tâches dont le prix est supérieur à 1000 DH :");
            List<Tache> tachesPrixSuperieur = tacheService.getTachesPrixSuperieur1000();
            for (Tache tache : tachesPrixSuperieur) {
                System.out.println(" - " + tache.getNom() + " (Prix : " + tache.getPrix() + " DH)");
            }           
            
            //Liste des tâches réalisées entre deux dates
            System.out.println("\nListe des tâches réalisées entre deux dates :");
            Date debut = dateFormat.parse("01/06/2024");
            Date fin = dateFormat.parse("31/12/2024");
            List<Tache> tachesPeriode = tacheService.getTachesRealiseesPeriode(debut, fin);
            for (Tache tache : tachesPeriode) {
                System.out.println(" - " + tache.getNom());
            }
   }
    
    }
    

