package com.diplomna2m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplomna2m.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{
	
}
