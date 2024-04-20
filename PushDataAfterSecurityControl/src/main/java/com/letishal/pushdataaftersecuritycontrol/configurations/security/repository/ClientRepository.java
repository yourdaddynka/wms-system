package com.letishal.pushdataaftersecuritycontrol.configurations.security.repository;

import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends EntityRepository<Client,Long> {
}
