package com.ashokit.bindig;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@XmlRootElement
@Data
public class User {
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
