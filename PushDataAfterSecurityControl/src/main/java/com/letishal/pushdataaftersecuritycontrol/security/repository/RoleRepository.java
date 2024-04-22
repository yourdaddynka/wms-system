package com.letishal.pushdataaftersecuritycontrol.security.repository;
import com.letishal.pushdataaftersecuritycontrol.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.security.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends EntityRepository<Role, Long> {
    Optional<Role> findByName(String role);
}
