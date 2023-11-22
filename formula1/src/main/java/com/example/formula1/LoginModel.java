package com.example.formula1;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {
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

    @NotNull
    @Size(min=5)
    private String email;

    @NotNull
    @Size(min=5)
    private String password;

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginModel() {
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof LoginModel){
            LoginModel toCompare = (LoginModel) o;
            return this.email.equals(toCompare.getEmail()) && this.password.equals(toCompare.getPassword());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
