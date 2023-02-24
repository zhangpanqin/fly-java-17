package com.mflyyou.java;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@MapperConfig
public interface BaseMapperConfig<T extends BaseEntity, E> {

    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "createdBy")
    T domainToEntity(E source);
}