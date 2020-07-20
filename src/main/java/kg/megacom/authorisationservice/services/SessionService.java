package kg.megacom.authorisationservice.services;

import kg.megacom.authorisationservice.models.dto.SessionDto;
import kg.megacom.authorisationservice.models.dto.UserDto;

public interface SessionService {
    SessionDto signIn(String login,String password);
    boolean logOut(String auth);
    UserDto checkSession(String auth);
}
