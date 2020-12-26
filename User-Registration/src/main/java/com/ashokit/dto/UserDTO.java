package com.ashokit.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
private Integer userId;
private String firstName;
private String lastName;
private String email;
private LocalDate dob;
private String gender;
private String country;
private String state;
private String city;
private String password;
private String status;
	
}
