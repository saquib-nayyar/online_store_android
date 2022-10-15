package com.example.onlinestore;

public class DetailedDataModel {

    private String Id;
    private String Name;
    private String Email;
    private String Token;

    public DetailedDataModel(String id, String name, String email, String token) {
        this.Id = id;
        this.Name = name;
        this.Email = email;
        this.Token = token;
    }

    public String getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public String getEmail() {
        return Email;
    }
    public String getToken() {
        return Token;
    }


}
