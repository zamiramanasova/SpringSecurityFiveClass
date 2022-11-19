package com.example.springsecurityfivecass.repository;

import com.example.springsecurityfivecass.entity.securemodel.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
}
