package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashokit.bo.Cities;

public interface CitiesRepo extends JpaRepository<Cities, Integer> {

	@Query("SELECT  cityId,cityName FROM com.ashokit.bo.Cities WHERE stateId=:id")
	public List<Object[]> findCitiesByStateId(@Param("id")Integer stateId);

	
}
