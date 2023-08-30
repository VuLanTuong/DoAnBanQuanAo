package com.example.doanbanquanao.controller;


import com.example.doanbanquanao.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String username;
    private String password;
    private String fullName;
    private Contact contact;
    private boolean gender;







}
