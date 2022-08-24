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
    
   private List<Personne> personnes;
    private Long nextId;

    public AnnuaireDAO() {
        this.personnes = new ArrayList();
        this.nextId = 1L;
    }

    public Personne create(Personne personne) {
        personne.setId(nextId);
        personnes.add(personne);

        nextId++;

        return personne;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }
    
    
    //Afficher une personne specifique en recherchant via l'id
    public Personne getPersonneById(Long id){
        Personne personneToFind = new Personne();
        for(Personne inscrit: personnes){
            if(inscrit.getId().equals(id)){
                personneToFind.setId(id);
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
    public void deletepersonne(Long id){
        for (Personne inscrit : personnes){
            if(inscrit.getId().equals(id)){
                personnes.remove(inscrit);
            }
        }
       
         
    }
    
    
}
