package com.example.demo.repositories;

import com.example.demo.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<AppRole, Integer> {

    AppRole findByRoleName(String rolName);

}
