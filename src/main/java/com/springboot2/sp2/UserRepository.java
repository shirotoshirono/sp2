package com.springboot2.sp2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    List<User> findByUsername(String username);
    List<User> findByPasswordAndUsername(String password, String username);
}
