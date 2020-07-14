package kg.megacom.authorisationservice.controllers;

import kg.megacom.authorisationservice.models.dto.UserDto;
import kg.megacom.authorisationservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserDto save (@RequestHeader("auth") String auth, @RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping("/update")
    public UserDto update(@RequestHeader("auth") String auth,@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@RequestHeader("auth") String auth,@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/find/{id}")
    public UserDto getById(@RequestHeader("auth") String auth,@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<UserDto> findAllUsers(@RequestHeader("auth") String auth){
        return userService.getAllUsers();
    }
}
