package com.example.demo;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
class Users {

    private @Id @GeneratedValue Long id;
    private String name;
    private String email;
    private String pass;
    Users(){}

    Users(String email, String pass) {

        this.email = email;
        this.pass = pass;
    }

    Users(String name, String email, String pass) {

        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {


        this.pass = pass;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Users))
            return false;
        Users user = (Users) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name)
                && Objects.equals(this.email, user.email)  && Objects.equals(this.pass, user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.email,this.pass);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + '}';
    }
}