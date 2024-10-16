## Exercice 3 - Gestion de projets et tâches

## 1. Création des entités
Dans ce projet, vous allez modéliser des projets et des tâches :

-Projet : Représente un projet avec un nom, une date de début et une date de fin.

-Tache : Représente une tâche associée à un projet, avec un nom, un prix, une date de début et de fin.

-Employe : Représente un employé qui peut être associé à plusieurs tâches via EmployeTache.

-ChefDeProjet : Représente un employé qui est responsable de plusieurs projets.

## 2. Configuration Hibernate
Comme précédemment, créez un fichier hibernate.cfg.xml pour configurer les interactions avec MySQL.

## 3. Interface et Service
-Créez l’interface IDao qui définira les opérations CRUD.

-Créez des services comme ProjetService, TacheService, et EmployeService. Ces services seront responsables de l’ajout, la mise à jour, la suppression et la récupération des entités.

## 4. Méthodes spécifiques
Ajoutez des méthodes pour gérer les tâches et les projets :

-Liste des tâches réalisées par un employé : Cette méthode récupère les tâches terminées par un employé.

-Liste des projets gérés par un chef de projet : Retourne tous les projets supervisés par un chef de projet.

-Liste des tâches planifiées pour un projet : Permet d’afficher les tâches qui sont encore à faire dans un projet.

-Tâches avec un prix supérieur à 1000 DH : Filtrez les tâches selon leur prix.

## 5. Tests
Dans la classe de test, initialisez des employés, projets et tâches, puis testez les différentes fonctionnalités comme l’affichage des tâches réalisées, les projets gérés, et les tâches planifiées.

