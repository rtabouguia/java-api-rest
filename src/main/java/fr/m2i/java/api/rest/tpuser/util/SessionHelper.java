/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tpuser.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RAISA
 */
public class SessionHelper {
     private static EntityManager entityManager;

    public static EntityManager getEntityManager() {

        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_rest_pu");
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }
    
}
