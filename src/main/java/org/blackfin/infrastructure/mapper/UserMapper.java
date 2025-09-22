package org.blackfin.infrastructure.mapper;

import org.blackfin.domain.User;
import org.blackfin.infrastructure.persistence.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserEntity entity);
    UserEntity toEntity(User domain);
}