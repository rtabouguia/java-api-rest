/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author RAISA
 */
@Path("/content-books")
public class BookContentResource {
    
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Book getContentBookXML(){
        System.out.println("Endpoint : getContentBookXML");
        
        Book book = new Book();
        book.setName("Harry potter");
        book.setIsbn("1-111111-11");
        return book;
    }
    
    @PUT
    @Path("/xml")
    @Consumes(MediaType.APPLICATION_XML)
    public void updateContentBookXML(Book book){
        System.out.println("Endpoint : getContentBookXML");
        System.out.println("Les modifications apportées - name : " +
                book.getName() + ", isbn :" + book.getIsbn());
        
    }
    
     @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getContentBookJSON(){
        System.out.println("Endpoint : getContentBookJSON");
        
        Book book = new Book();
        book.setName("Harry potter");
        book.setIsbn("1-111111-11");
        return book;
    }
    
    @PUT
    @Path("/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateContentBookJSON(Book book){
        System.out.println("Endpoint : getContentBookJSON");
        System.out.println("Les modifications apportées - name : " +
                book.getName() + ", isbn :" + book.getIsbn());
        
    }
    
     // URI : content-books/jsonxml
    @GET
    @Path("/jsonxml")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book getContentBookJSONAndXML() {
        System.out.println("Endpoint : getContentBookJSONAndXML");

        Book book = new Book();
        book.setName("JSON or XML Potter");
        book.setIsbn("1-111111-11");

        return book;
    }
    
     // URI : content-books/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllContentBookJSON() {
        System.out.println("Endpoint : getAllContentBookJSON");

        Book book1 = new Book();
        book1.setName("JSON Potter");
        book1.setIsbn("9-999999-99");

        Book book2 = new Book();
        book2.setName("Harry Potter");
        book2.setIsbn("1-111111-11");

        Book book3 = new Book();
        book3.setName("GOT");
        book3.setIsbn("3-123456-99");

        return Arrays.asList(book1, book2, book3);
    }
    
    
}
