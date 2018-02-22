package com.example.android.book_hub;

/**
 * Created by Hiral on 09-04-2017.
 */

public class UserInfo {

    private String dbId;
    private String email;
    private String username;
    private String bio;
    private String gender;
    private String photoid;

    public UserInfo(){

    }

    public UserInfo(String dbId, String email, String username, String bio, String gender, String photoid) {
        this.dbId = dbId;
        this.email = email;
        this.username = username;
        this.bio = bio;
        this.gender = gender;
        this.photoid = photoid;
    }

    public String getDbId() {
        return dbId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getGender() {
        return gender;
    }

    public String getPhotoid() {
        return photoid;
    }
}
