package kg.megacom.authorisationservice.services;

import kg.megacom.authorisationservice.models.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    boolean deleteUser(Long id);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
}
