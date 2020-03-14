package com.bridgelabz.fundoonotesapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.bridgelabz.fundoonotesapi.model.User;

public interface UserRepository extends JpaRepository<User,Object>{
	User findByEmail(String email);
}
