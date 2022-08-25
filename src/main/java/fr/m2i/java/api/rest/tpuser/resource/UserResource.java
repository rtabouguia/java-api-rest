/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tpuser.resource;

import fr.m2i.java.api.rest.tp.*;
import fr.m2i.java.api.rest.tpuser.util.SessionHelper;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public List<Object> getUsers(@Context HttpServletRequest request) {
        SessionHelper.getEntityManager();
        return null;
    }
}