package kg.megacom.authorisationservice.controllers;

import kg.megacom.authorisationservice.models.dto.SessionDto;
import kg.megacom.authorisationservice.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value="/v1/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/auth")
    public SessionDto auth(@RequestParam String login, @RequestParam String password){
       return sessionService.signIn(login,password);
    }

    @GetMapping("/out")
    public boolean logOut(@RequestHeader("auth") String auth){
        return sessionService.logOut(auth);
    }

    public boolean checkSession(@RequestHeader("auth") String auth){
        return sessionService.checkSession(auth);
    }
}
