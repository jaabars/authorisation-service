package kg.megacom.authorisationservice.mappers;

import kg.megacom.authorisationservice.models.dto.UserDto;
import kg.megacom.authorisationservice.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);

    List<UserDto> userListToUserDtoList(List<User> userList);
}
