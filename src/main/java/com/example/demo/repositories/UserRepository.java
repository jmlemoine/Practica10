package com.example.demo.repositories;

import com.example.demo.entity.AppRole;
import com.example.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByRolSet(Set<AppRole> rol);
    AppUser findByUsername(String name);
    AppUser findByPassword(String password);
    AppUser findByUserId(int id);

    List<AppUser> findAllByEnabled(Boolean enabled);

}
