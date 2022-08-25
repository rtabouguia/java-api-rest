/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tp.tpuser.dao;

import fr.m2i.java.api.rest.tpuser.model.User;
import fr.m2i.java.api.rest.tpuser.util.SessionHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author RAISA
 */
public class UserDAO {
     private final EntityManager entityManager;

    public UserDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    //findAll
public List<User> findAll() {
        Query findAllQuery = entityManager.createQuery("select a from User a");
        return findAllQuery.getResultList();
    }

public void addUser(User userToCreate){
     if (userToCreate == null) {
            System.out.println("L'objet user ne peut pas être null");
            return;
        }
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(userToCreate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                // Une erreur est survenue, on discard les actions entamés dans la transaction
                tx.rollback();
            }
        }
}

public void updateUser(int id, User userData) throws Exception{
   User userToUpdate = entityManager.find(User.class, id);

        if (userToUpdate == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("L'utilisateur avec l'id:" + id + " n'existe pas en base")
                            .build() );
        }
        
        //userToUpdate.copy(userData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(userToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
}
public void deleteUser(int id) throws Exception{
    User userToDelete = entityManager.find(User.class, id);

        if (userToDelete == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("L'utilisateur avec l'id:" + id + " n'existe pas en base")
                            .build() );
        }
        EntityTransaction tx = null;
         try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.remove(userToDelete);
            System.out.println("*******Suppression réussie*********");

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la suppression");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
}

public User getUserById(int id){
    User userToReturn = entityManager.find(User.class, id);

        if (userToReturn == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("L'utilisateur avec l'id:" + id + " n'existe pas en base")
                            .build() );
        }
        
        return userToReturn;
}
}
