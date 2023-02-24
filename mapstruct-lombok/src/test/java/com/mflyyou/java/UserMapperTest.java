package com.mflyyou.java;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static com.mflyyou.java.Constants.ID;
import static com.mflyyou.java.Constants.NAME;
import static com.mflyyou.java.Constants.VERSION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserMapperTest {
    UserMapper mapper;

    @BeforeEach
    void each() {
        mapper = Mappers.getMapper(UserMapper.class);
    }

    @Test
    void to_entity() {
        var entity = mapper.toEntity(User.builder()
            .id(ID)
            .name(NAME)
            .version(VERSION)
            .build());

        assertThat(entity)
            .returns(ID, UserEntity::getId)
            .returns(NAME, UserEntity::getName)
            .returns(VERSION, UserEntity::getVersion);
    }

    @Test
    void to_domain() {
        var user = mapper.toUser(buildUserEntity());

        assertThat(user)
            .returns(ID, User::getId)
            .returns(NAME, User::getName)
            .returns(VERSION, User::getVersion);
    }

    public static UserEntity buildUserEntity() {
        var entity = new UserEntity();
        entity.setName(NAME);
        entity.setId(ID);
        entity.setVersion(VERSION);
        return entity;
    }
}