package com.example.xyzt.data.dto.request;

import com.example.xyzt.exception.ValidationEmail;
import com.example.xyzt.exception.ValidationPhoneNumber;
import com.example.xyzt.exception.ValidationUsername;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserRequestDTO {
    @NotEmpty(message = "full name not blank")
    private String fullName;
    @ValidationUsername
    private String userName;
    @ValidationEmail
    private String email;
    @ValidationPhoneNumber
    private String phoneNumber;

    public UserRequestDTO(String fullName, String userName, String email, String phoneNumber) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
