package kg.megacom.authorisationservice.services.impl;

import kg.megacom.authorisationservice.dao.UserRepository;
import kg.megacom.authorisationservice.exceptions.UserNotFound;
import kg.megacom.authorisationservice.mappers.UserMapper;
import kg.megacom.authorisationservice.models.dto.UserDto;
import kg.megacom.authorisationservice.models.entity.Account;
import kg.megacom.authorisationservice.models.entity.User;
import kg.megacom.authorisationservice.services.UserService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.save(user);
        userDto = UserMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        Account account = user.getAccount();
        account.set_active(false);
        user.setAccount(account);
        userRepository.save(user);
        user = userRepository.findById(user.getId()).orElse(null);
        if(!user.getAccount().is_active()){
            return true;
        }else{
            throw new UserNotFound("Пользователь не найден ");
        }
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = UserMapper.INSTANCE.userListToUserDtoList(userList);
        return userDtoList;
    }
}
