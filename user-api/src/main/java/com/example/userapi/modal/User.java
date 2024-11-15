package com.example.userapi.modal;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {

    private String fname;
    private String lname;
    private String email;

    public User(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;

    }

}
