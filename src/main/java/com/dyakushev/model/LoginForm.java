package com.dyakushev.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class LoginForm
{

    @NotBlank(message = "username can not be blank")
    @Size(min = 4, max = 128)
    private String username;

    @NotBlank
    @Size(min = 4, max = 128)
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
