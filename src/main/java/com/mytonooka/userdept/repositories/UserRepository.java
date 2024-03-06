package com.mytonooka.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytonooka.userdept.entities.User;

public interface UserRepository extends JpaRepository<User , Long>  {

}
