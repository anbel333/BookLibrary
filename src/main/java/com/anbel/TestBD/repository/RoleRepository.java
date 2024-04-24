package com.anbel.TestBD.repository;

import com.anbel.TestBD.entity.ERole;
import com.anbel.TestBD.entity.Role;
import com.anbel.TestBD.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
