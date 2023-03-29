package com.example.xyzt.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    @NotBlank(message = "name not bank")
    private String fullName;
    private String userName;
    private String email;
    private String phoneNumber;


}
