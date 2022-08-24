/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tp;

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
@Path("/annuaire")
public class AnnuaireRessource {
    
    private AnnuaireDAO annuaire;
    

 // URI : /
    @POST
    @Path("/inscription")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Personne createPersonne(Personne personne, @Context HttpServletRequest request) {
        System.out.println("Endpoint : createPersonne");

        // Récupérer l'annuaire stocké dans les attributs de la Session
        AnnuaireDAO annuaire = (AnnuaireDAO) request.getSession().getAttribute("annuaire");

        // Dans le cas où mon annuaire est null, je l'instancie
        if (annuaire == null) {
            annuaire = new AnnuaireDAO();
        }

        // Ajout de la personne dans la liste
        Personne created = annuaire.create(personne);

        // Créer / met à jour mon annuaire en Session
        request.getSession().setAttribute("annuaire", annuaire);

        return created;
    }

    // URI : /
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getPersonnes(@Context HttpServletRequest request) {
        System.out.println("Endpoint : getPersonnes");

        // Récupérer l'annuaire stocké dans les attributs de la Session
        AnnuaireDAO annuaire = (AnnuaireDAO) request.getSession().getAttribute("annuaire");

        if (annuaire == null) {
            return new ArrayList();
        }

        return annuaire.getPersonnes();
    }


@GET
@Path("/inscrits")
@Produces(MediaType.APPLICATION_JSON)
public List<Personne> getPersonnesFromAnnuaire(@Context HttpServletRequest request){
     HttpSession session = request.getSession(true);
     if(request.getSession(true).getAttribute("annuaire")==null){
            annuaire = new AnnuaireDAO();
             request.getSession().setAttribute("annuaire", annuaire);
        }
     AnnuaireDAO annuary =(AnnuaireDAO)session.getAttribute("annuaire");
     return annuary.getPersonnes();
    }

@GET
@Path("/personne")
@Produces(MediaType.APPLICATION_JSON)
public Personne getPersonneById(@Context HttpServletRequest request, @QueryParam("id") Long id){
     HttpSession session = request.getSession(true);
     if(request.getSession(true).getAttribute("annuaire")==null){
            annuaire = new AnnuaireDAO();
             request.getSession().setAttribute("annuaire", annuaire);
        }
     AnnuaireDAO annuary =(AnnuaireDAO)session.getAttribute("annuaire");
     
     return annuary.getPersonneById(id);
    }

@DELETE
@Path("/suppression")
public Response deletePersonne(@Context HttpServletRequest request, 
        @QueryParam("id") Long id){
    HttpSession session = request.getSession(true);
     if(request.getSession(true).getAttribute("annuaire")==null){
            annuaire = new AnnuaireDAO();
             request.getSession().setAttribute("annuaire", annuaire);
        }
     AnnuaireDAO annuary =(AnnuaireDAO)session.getAttribute("annuaire");
     annuary.deletepersonne(id);
        // Créer / met à jour mon annuaire en Session
        request.getSession().setAttribute("annuaire", annuaire);
     return  Response.status(Response.Status.OK).entity("la personne avec l'id ="+ id + "a été modifiée").build();
}

@PUT
@Path("/miseajour")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Personne updatePersonne(Personne personne, @Context HttpServletRequest request){
    HttpSession session = request.getSession(true);
     if(request.getSession(true).getAttribute("annuaire")==null){
            annuaire = new AnnuaireDAO();
             request.getSession().setAttribute("annuaire", annuaire);
        }
     AnnuaireDAO annuary =(AnnuaireDAO)session.getAttribute("annuaire");
     annuary.updatePersonne(personne);
        // Créer / met à jour mon annuaire en Session
        request.getSession().setAttribute("annuaire", annuaire);
     return personne;
    }
}