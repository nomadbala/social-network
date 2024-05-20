package kz.runamicon.socialnetwork.mapper;

import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    User registerRequestToUser(RegisterRequest request);
}
