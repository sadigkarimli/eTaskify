package com.etaskify.app.repository;

import com.etaskify.app.model.Role;
import com.etaskify.app.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRoleName(RoleName roleName);
}
