package kg.megacom.authorisationservice.services.impl;

import kg.megacom.authorisationservice.dao.UserRepository;
import kg.megacom.authorisationservice.exceptions.UserExist;
import kg.megacom.authorisationservice.exceptions.UserNotFound;
import kg.megacom.authorisationservice.mappers.UserMapper;
import kg.megacom.authorisationservice.models.dto.AccountDto;
import kg.megacom.authorisationservice.models.dto.UserDto;
import kg.megacom.authorisationservice.models.entity.User;
import kg.megacom.authorisationservice.services.AccountService;
import kg.megacom.authorisationservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserDto userDto) {

        User checkLogin = userRepository.getLoginByNativeQuery(userDto.getAccount().getLogin());
        if (!checkLogin.equals(null)) throw new UserExist("Такой логин уже существует");

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.save(user);
        userDto = UserMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user.equals(null)) throw  new UserNotFound("Пользователь не найден");
        user.set_active(false);
        userRepository.save(user);
        return true;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user.equals(null)) throw new UserNotFound("Пользователь не найден");
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = UserMapper.INSTANCE.userListToUserDtoList(userList);
        return userDtoList;
    }
}
