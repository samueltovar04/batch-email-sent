package org.blackfin.application.port;

import io.smallrye.mutiny.Multi;
import org.blackfin.domain.User;


public interface UserRepository {
    Multi<User> findAll();
}
