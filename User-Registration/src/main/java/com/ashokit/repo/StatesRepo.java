package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashokit.bo.States;

public interface StatesRepo extends JpaRepository<States, java.lang.Integer> {

	@Query("SELECT  stateId,stateName FROM com.ashokit.bo.States WHERE countryId=:id")
	public List<Object[]> findStatesByCountryId(@Param("id")Integer countryId);
}
