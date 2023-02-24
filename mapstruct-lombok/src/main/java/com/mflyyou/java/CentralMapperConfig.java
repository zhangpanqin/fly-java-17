package com.mflyyou.java;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseMapperConfig.class)
public interface CentralMapperConfig {
}