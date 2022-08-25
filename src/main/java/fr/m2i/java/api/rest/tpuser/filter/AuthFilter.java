/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tpuser.filter;


import fr.m2i.java.api.rest.tpuser.model.User;
import fr.m2i.java.api.rest.tpuser.util.BasicAuth;
import java.io.IOException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {
    
  @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // On récupère le couple identifiant / mot de passe depuis le header
        String auth = requestContext.getHeaderString("Authorization");

        // Vérifie que le couple identifiant / mot de passe est bien envoyé par le client
        if (auth == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("You must be connected")
                            .build()
            );
        }
        
        // lap -> login and password
        String[] lap = BasicAuth.decode(auth);

        // On véréfie que lap est au bon format
        if (lap == null || lap.length != 2) {
            throw new WebApplicationException(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("You must be connected")
                            .build()
            );
        }
        
        // Véréfie les identifiants envoyés
        User authentified = checkUser(lap[0], lap[1]);

        if (authentified == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("You must be connected")
                            .build()
            );
        }
    }

    public User checkUser(String email, String password) {
        User admin = new User("Super", "Admin", "SUPER_ADMIN", "super@admin.com", "admin");

        if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
            return admin;
        }

        return null;
    }
    
}
