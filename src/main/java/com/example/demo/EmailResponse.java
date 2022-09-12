package com.example.demo;

//mvnw clean spring-boot:run
public class EmailResponse {
    EmailResponse(int status){
        this.status = status;

    }
    int status;
    // In order for Spring to serialize Coffee objects, we need
    // to define getter and setter methods for each attribute
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    // we will use the toString method in later examples
    public String toString() {
        return "[" + String.valueOf(status)  + "]";
    }



}
