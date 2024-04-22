package com.letishal.pushdataaftersecuritycontrol.security.repository;
import com.letishal.pushdataaftersecuritycontrol.security.model.Client;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends EntityRepository<Client, Long> {
    Optional<Client> findByUserNickName(String username);
}
