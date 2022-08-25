/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.java.api.rest.tpuser.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

/**
 *
 * @author RAISA
 */
@Entity
@Table(name="utilisateurs")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastname;
    private String firstname;
    private String role;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    public User() {
        
    }

    public User(String lastname, String firstname, String role, String email, String password) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public void copy(User userData) {
     
        if (userData.getLastname()!= null) {
            this.setLastname(userData.getLastname());
        }
          if (userData.getEmail()!= null) {
            this.setEmail(userData.getEmail());
        }
          if (userData.getFirstname()!= null) {
            this.setFirstname(userData.getFirstname());
        }
        if (userData.getRole()!=null) {
            this.setRole(userData.getRole());
        }
         if (userData.getPassword()!= null) {
            this.setPassword(userData.getPassword());
        }
           
    }
}
