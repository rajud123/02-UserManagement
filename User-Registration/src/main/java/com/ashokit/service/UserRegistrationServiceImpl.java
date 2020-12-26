package com.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ashokit.bo.Countries;
import com.ashokit.bo.States;
import com.ashokit.bo.UserBO;
import com.ashokit.dto.UserDTO;
import com.ashokit.repo.CitiesRepo;
import com.ashokit.repo.CountriesRepo;
import com.ashokit.repo.IUserRegistrationDAO;
import com.ashokit.repo.StatesRepo;

public class UserRegistrationServiceImpl implements IUserRegistrationService {
	@Autowired
	private IUserRegistrationDAO regRepo;

	@Autowired
	private CountriesRepo countriesRepo;

	@Autowired
	private StatesRepo statesRepo;

	@Autowired
	private CitiesRepo citiesRepo;

	@Override
	public Map<Integer, String> findCountries() {
		// create map of countries
		Map<Integer, String> countries = new HashMap<Integer, String>();

		// use countriesRepo
		List<Countries> list = countriesRepo.findAll();
		list.forEach(country -> {
			countries.put(country.getCountryId(), country.getCountryName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {

		// create map object
		Map<Integer, String> states = new HashMap<Integer, String>();

		// use states repo
		List<Object[]> list = statesRepo.findStatesByCountryId(countryId);

		list.forEach(array -> {
			states.put((Integer) array[0], (String) array[1]);
		});
		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {

		// create map object
		Map<Integer, String> cities = new HashMap<Integer, String>();

		// use repo
		List<Object[]> list = citiesRepo.findCitiesByStateId(stateId);

		list.forEach(array -> {
			cities.put((Integer) array[0], (String) array[1]);
		});
		return cities;
	}

	public boolean isEmailUnique(String email) {
		int count = regRepo.isEmailUniqueVerification(email);
		if (count != 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveUser(UserDTO dto) {
		boolean flag = false;
		try {
			UserBO bo = new UserBO();
			Long randomPass = new Random().nextLong();
			bo.setPassword(randomPass.toString());
			bo.setState("LOCKED");
			BeanUtils.copyProperties(dto, bo);
			if (this.isEmailUnique(bo.getEmail()) == true) {
				UserBO bo2 = regRepo.save(bo);
			}
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean isTempPasswordValid(String email, String tempPwd) {
		// use repo
		int count = regRepo.validateTempPwd(email, tempPwd);
		if (count == 1) {
			return true;
		}
		return false;
	}

	public boolean unlockAccount(String email, String tempPwd, String newPwd) {
		boolean flag = false;
		try {
			flag = this.isTempPasswordValid(email, tempPwd);
			if (flag == true) {
				UserDTO dto = new UserDTO();
				dto.setPassword(newPwd);
				UserBO bo = new UserBO();
				BeanUtils.copyProperties(dto, bo);
				regRepo.save(bo);

			}
			flag = true;
		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	@Override
	public String loginCheck(String email, String password) {
		UserBO user = regRepo.findByEmailAndPassword(email, password);
		if (user != null) {
			if (user.getState().equalsIgnoreCase("LOCKED")) {
				return "ACCOUNT_LOCKED";
			} else {
				return "LOGIN_SUCCESS";
			}
		}

		return "INVALID_CREDENTIALS";
	}

	@Override
	public String forgotPassword(String email) {
		String password = null;
		try {
			password = regRepo.getPasswordByUserName(email);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return password;
	}

}
