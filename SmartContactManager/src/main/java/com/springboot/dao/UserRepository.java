package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
	
}