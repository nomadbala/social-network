package kz.runamicon.socialnetwork.mapper;

import kz.runamicon.socialnetwork.dto.authentication.RegisterRequest;
import kz.runamicon.socialnetwork.dto.user.UserDto;
import kz.runamicon.socialnetwork.entity.Role;
import kz.runamicon.socialnetwork.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.password()))")
    @Mapping(target = "roles", expression = "java(java.util.Collections.singleton(role))")
    User registerRequestToUser(RegisterRequest request, PasswordEncoder passwordEncoder, Role role);

    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDtos(List<User> users);
}
