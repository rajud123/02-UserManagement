package com.ashokit.repo;

import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ashokit.bo.UserBO;
@Repository
public interface IUserRegistrationDAO extends JpaRepository<UserBO, Integer> {

	@Query("SELECT COUNT(*) from com.nt.bo.UserBO where email:=email AND password:=pwd ")
	public int validateTempPwd(@Param("email") String email, @Param("pwd") String tempPwd);
	
	public UserBO findByEmailAndPassword(String email,String password);
	

	@Query("SELECT COUNT(*) from com.nt.bo.UserBO where email:=email")
	public int isEmailUniqueVerification(@Param("email") String email);
	
	
	@Query("SELECT COUNT(*) from com.nt.bo.UserBO where email:=email,password:=pwd")
	public int loginInOperation(@Param("email") String email,@Param("pwd") String pass);
	
	@Query("SELECT password from com.nt.bo.UserBO WHERE email:=email")
	public String getPasswordByUserName(@Param("email") String email);
}
