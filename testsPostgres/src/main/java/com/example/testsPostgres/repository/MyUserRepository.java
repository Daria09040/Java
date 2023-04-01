package com.example.testsPostgres.repository;

import com.example.testsPostgres.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    List<MyUser> findAllByRoleID(Long roleID);
}
