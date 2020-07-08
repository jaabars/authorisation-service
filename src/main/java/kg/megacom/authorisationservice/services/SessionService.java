package kg.megacom.authorisationservice.services;

import kg.megacom.authorisationservice.models.dto.SessionDto;

public interface SessionService {
    SessionDto signIn(String login,String password);
    boolean logOut(String auth);
    boolean checkSession(String auth);
}
