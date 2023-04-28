package edu.guilford;

public class Individual {
    //Three attributes for name, email, and phone
    private String name;
    private String email;
    private String phone;

    //Constructor that gives default data
    public Individual() {
        name = "John Doe";
        email = "jdoe@guilford";
        phone = "555-555-5555";
    }

    //Constructor that takes the parameters
    public Individual(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    //Getters and setters for the attributes
    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //Check to make sure the name is not null
        if (name != null) {
            this.name = name;
        }
    }

    //Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //Check to make sure the email is not null
        if (email != null) {
            this.email = email;
        }
    }

    //Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        //Check to make sure the phone is not null
        if (phone != null) {
            this.phone = phone;
        }
    }

    //toString method
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone;
    }



}
