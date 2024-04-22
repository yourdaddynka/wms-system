package com.letishal.pushdataaftersecuritycontrol.configurations.security.repository;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends EntityRepository<Role, Long> {
}
