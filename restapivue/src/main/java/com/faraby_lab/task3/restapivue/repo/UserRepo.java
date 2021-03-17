package com.faraby_lab.task3.restapivue.repo;

import com.faraby_lab.task3.restapivue.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
