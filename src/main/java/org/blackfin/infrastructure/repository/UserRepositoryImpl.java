package org.blackfin.infrastructure.repository;

import org.blackfin.application.port.UserRepository;
import org.blackfin.domain.User;
import org.blackfin.infrastructure.mapper.UserMapper;
import org.blackfin.infrastructure.persistence.UserEntity;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    @Inject
    UserMapper mapper;

    @Override
    public Multi<User> findAll() {
        return UserEntity.find("status", true)
                .list()
                .onItem().transformToMulti(userEntities -> Multi.createFrom().iterable(userEntities))
                .onItem().transform(item -> (UserEntity) item)
                .onItem().transform(mapper::toDomain);
    }
}