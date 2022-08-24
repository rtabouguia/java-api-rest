/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAISA
 */
public class AnnuaireDAO {
    
    public List <Personne> listInscrits;

    public AnnuaireDAO() {
        this.listInscrits = new ArrayList();
    }
    //ajouter une personne
    public void addPersonne(String nom, String prenom){
           if (nom==null || prenom==null) {
            System.out.println("La personne ne peut pas être créée");
            return;
        }
          Personne personne = new Personne();
          personne.setNom(nom);
          personne.setPrenom(prenom);
          for(Personne inscrit: listInscrits){
              if(inscrit.getNom().equals(nom) & inscrit.getPrenom().equals(prenom)){
                   System.out.println(nom + "est déjà enregistré dans l'annuaire");
                   break;
              }
          }
        this.listInscrits.add(personne);
    }
    
    //afficher la liste des personnes inscrites
    public List<Personne> getAllInscrits(){
        return listInscrits;
    }
    
    //Afficher une personne specifique en recherchant via l'id
    public Personne getPersonneById(int id){
        Personne personneToFind = new Personne();
        for(Personne inscrit: listInscrits){
            if(inscrit.getId()==id){
                personneToFind.setNom(inscrit.getNom());
                personneToFind.setPrenom(inscrit.getPrenom());
            }
        } return personneToFind;
    }
    
    //modifier une personne
    public void updatePersonne(Personne personne){
        
        Personne personneToUpdate = getPersonneById(personne.getId());
         if (personneToUpdate == null) {
            System.out.println("La personne avec l'id:" + personne.getId() + " n'existe pas");
            return;
        }
        personneToUpdate.setNom(personne.getNom());
        personneToUpdate.setPrenom(personne.getPrenom());
       
    }
    
    //supprimer une personne 
    public void deletepersonne(Personne personne){
        Personne personneToDelete = getPersonneById(personne.getId());
         if (personneToDelete == null) {
            System.out.println("La personne n'existe pas");
            return;
        }
         listInscrits.remove(personneToDelete);
    }
    
    
}
