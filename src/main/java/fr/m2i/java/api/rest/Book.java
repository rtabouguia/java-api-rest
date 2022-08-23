/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest;

import com.fasterxml.jackson.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RAISA
 */
@JsonPropertyOrder({"isbn" , "name"}) 
@XmlRootElement(name = "book")
public class Book {
    
    @JsonProperty("book_name")
    private String name;
    
     @JsonProperty("book_isbn")
    private String isbn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
    
}
