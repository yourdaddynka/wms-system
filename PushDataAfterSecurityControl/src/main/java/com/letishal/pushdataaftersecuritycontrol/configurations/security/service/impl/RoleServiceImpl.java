package com.letishal.pushdataaftersecuritycontrol.configurations.security.service.impl;


import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Role;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.repository.EntityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl extends EntityServiceImpl<Role, Long> {
    public RoleServiceImpl(EntityRepository<Role, Long> repository) {
        super(repository);
    }
}
