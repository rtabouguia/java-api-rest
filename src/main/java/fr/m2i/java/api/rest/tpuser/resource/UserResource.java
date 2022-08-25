/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tpuser.resource;

import fr.m2i.java.api.rest.tp.*;
import fr.m2i.java.api.rest.tp.tpuser.dao.UserDAO;
import fr.m2i.java.api.rest.tpuser.model.User;
import fr.m2i.java.api.rest.tpuser.util.SessionHelper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

/**
 *
 * @author RAISA
 */
@Path("/users")
public class UserResource {

 // URI : /
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
         UserDAO users = new UserDAO();
        return users.findAll();      
    }
    
    @POST
    @Path("/creation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user){
        
        if(user.getRole()==null || user.getFirstname()==null || user.getLastname()==null || user.getEmail()==null ||
                user.getPassword()==null){
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("Une erreur s'est produite!\nVeuillez entrer toutes informations requises: lastname, firsname, email, password et role")
                            .build() );
        }
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(user);
        
        return Response.status(Response.Status.CREATED)
                                  .entity("l'utilisateur a bien été créé")
                                  .build();
    }
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user, @QueryParam("id") int id) throws Exception{
        if (id<=0){
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("Une erreur s'est produite! l'Id entré donné en paramètre est incorrect")
                            .build() );        }
         UserDAO userDAO = new UserDAO();
         userDAO.updateUser(id, user);

         return Response.status(Response.Status.OK)
                                  .entity("l'utilisateur a bien été modifié")
                                  .build();
    }
    
    @DELETE
    @Path("/delete")
    public Response deleteUser(@QueryParam("id") int id)throws Exception{
        if (id<=0){
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("Une erreur s'est produite! l'Id donné en paramètre est incorrect")
                            .build() );        }        
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(id);
        
        return Response.status(Response.Status.OK)
                                  .entity("l'utilisateur a bien été supprimé")
                                  .build();
    }
    
    @GET
    @Path("/findUser")
    public Response getUserById(@QueryParam("id") int id)throws Exception{
        if (id<=0){
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("Une erreur s'est produite! l'Id donné en paramètre est incorrect")
                            .build() );        }        
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(id);
        return Response.status(Response.Status.OK).entity(user).type(MediaType.APPLICATION_JSON).build();
    }
    
    

}