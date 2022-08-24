/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tp;

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
    

@POST
@Path("/inscription")
public Response createInscritInAnnuaire(@Context HttpServletRequest request, 
        @QueryParam("nom") String nom, @QueryParam("prenom") String prenom){
          if (nom == null || prenom==null) { 
            throw new BadRequestException();
        }
          HttpSession session = request.getSession(true);
           if(request.getSession().getAttribute("annuaire")==null){
            annuaire = new AnnuaireDAO();
            session.setAttribute("annuaire", annuaire);
        }
           AnnuaireDAO annuary =(AnnuaireDAO)session.getAttribute("annuaire");
            annuary.addPersonne(nom,prenom);
     return Response.status(Response.Status.OK).entity(nom + " a été rajoutée à la base").build();
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
     return annuary.getAllInscrits();
    }

@GET
@Path("/personne")
@Produces(MediaType.APPLICATION_JSON)
public Personne getPersonneById(@Context HttpServletRequest request, @QueryParam("id") int id){
     HttpSession session = request.getSession(true);
     if(request.getSession(true).getAttribute("annuaire")==null){
            annuaire = new AnnuaireDAO();
             request.getSession().setAttribute("annuaire", annuaire);
        }
     AnnuaireDAO annuary =(AnnuaireDAO)session.getAttribute("annuaire");
     
     return annuary.getPersonneById(id);
    }
}