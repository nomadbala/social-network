package kz.runamicon.socialnetwork.mapper;

import kz.runamicon.socialnetwork.dto.RegisterRequest;
import kz.runamicon.socialnetwork.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public User registerRequestToUser(RegisterRequest request);
}
