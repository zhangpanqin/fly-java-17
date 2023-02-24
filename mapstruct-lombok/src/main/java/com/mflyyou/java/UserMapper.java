package com.mflyyou.java;

import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface UserMapper {
    UserEntity toEntity(User user);

    User toUser(UserEntity entity);
}