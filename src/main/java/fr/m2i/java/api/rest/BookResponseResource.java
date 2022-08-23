/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author RAISA
 */
@Path("/response-books")
public class BookResponseResource {

    // URI : /ok/without-response
    @GET
    @Path("/ok/without-response")
    public String getBookWithoutResonse() {
        System.out.println("Endpoint : getBookWithoutResonse");
        return "Java 8 doc";
    }

    // URI : /ok
    @GET
    @Path("/ok")
    public Response getBook() {
        System.out.println("Endpoint : getBook");
        return Response.status(Response.Status.OK).entity("Java 8 doc").build();
    }
}
