package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.bo.Countries;

public interface CountriesRepo extends JpaRepository<Countries, Integer> {

}
