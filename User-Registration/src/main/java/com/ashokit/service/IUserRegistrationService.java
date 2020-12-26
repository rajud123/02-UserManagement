package com.ashokit.service;

import java.util.Map;

import com.ashokit.bo.UserBO;
import com.ashokit.dto.UserDTO;

public interface IUserRegistrationService {
	//Registration Page operation
	public Map<Integer, String> findCountries();
	
	public Map<Integer, String> findStates(Integer countryId);
	
	public Map<Integer, String> findCities(Integer stateId);
	
	public boolean isEmailUnique(String email);
	
	public boolean saveUser(UserDTO dto);

	public boolean isTempPasswordValid(String email,String tempPwd);

	public boolean unlockAccount(String email, String tempPass, String newPass);

	public String loginCheck(String email, String password);

	public String forgotPassword(String email);
}
