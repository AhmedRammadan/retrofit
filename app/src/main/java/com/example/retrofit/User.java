package com.example.retrofit;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private int phoneNumber;
    private int nationalID;
    private int area_id;
    private int city_id;
    private int country_id;
    private int state_id;




    public User(String firstName, String lastName, String email, String password, String address, int phoneNumber, int nationalID, int area_id, int city_id, int country_id, int state_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.nationalID = nationalID;
        this.area_id = area_id;
        this.city_id = city_id;
        this.country_id = country_id;
        this.state_id = state_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getNationalID() {
        return nationalID;
    }

    public int getArea_id() {
        return area_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public int getState_id() {
        return state_id;
    }
}
