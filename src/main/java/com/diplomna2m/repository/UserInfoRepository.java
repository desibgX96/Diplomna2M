package com.diplomna2m.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diplomna2m.model.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository< UserInfo, Integer>{

	@Query("Select u from UserInfo as u where  u.userName LIKE :username  AND u.password LIKE :password")
	List<UserInfo> findUserProfile(@Param(value = "username") String username, @Param(value = "password") String password);
	
	public Optional<UserInfo> findByEmail(String email);
}
