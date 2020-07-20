package kg.megacom.authorisationservice.services.impl;

import kg.megacom.authorisationservice.dao.SessionRepository;
import kg.megacom.authorisationservice.dao.UserRepository;
import kg.megacom.authorisationservice.exceptions.AccountNotFound;
import kg.megacom.authorisationservice.exceptions.IncorrectPassword;
import kg.megacom.authorisationservice.exceptions.SessionByTokenNotFound;
import kg.megacom.authorisationservice.exceptions.UserNotActive;
import kg.megacom.authorisationservice.mappers.SessionMapper;
import kg.megacom.authorisationservice.mappers.UserMapper;
import kg.megacom.authorisationservice.models.dto.SessionDto;
import kg.megacom.authorisationservice.models.dto.UserDto;
import kg.megacom.authorisationservice.models.entity.Session;
import kg.megacom.authorisationservice.models.entity.User;
import kg.megacom.authorisationservice.services.SessionService;
import org.mapstruct.ap.shaded.freemarker.template.utility.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public SessionDto signIn(String login, String password) {

        User user = userRepository.getLoginByNativeQuery(login);

        if(user.getAccount().equals(null)) throw new AccountNotFound("Аккаунт с именем: "+login+" не существует");
        if (!user.getAccount().getPassword().equals(password)) throw new IncorrectPassword("Неверный пароль");
        if (!user.is_active()) throw new UserNotActive("Пользователь не активен");

        Session session = new Session();

        String token = UUID.randomUUID().toString();
        session.setToken(token);
        session.setStart_date(new Date());
        session.setEnd_date(Date.from(session.getStart_date().toInstant().plusSeconds(600l)));
        session.setUser(user);

        session = sessionRepository.save(session);

        SessionDto sessionDto = SessionMapper.INSTANCE.sessionToSessionDto(session);

        return sessionDto;
    }

    @Override
    public boolean logOut(String auth) {
        Session session = sessionRepository.findByToken(auth);
        if(session.equals(null)) throw new SessionByTokenNotFound("Такой сессии не сущесуствует");

        session.setEnd_date(new Date());
        sessionRepository.save(session);
        return true;
    }

    @Override
    public UserDto checkSession(String auth) {

        Session session = sessionRepository.findByToken(auth);

        if(session.equals(null)) throw new SessionByTokenNotFound("Такой сессии не сущесуствует");

        if(session.getEnd_date().getTime()>new Date().getTime()){
            session.setEnd_date(Date.from(session.getEnd_date().toInstant().plusSeconds(300l)));
            sessionRepository.save(session);
            User user = session.getUser();
            UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);
            return userDto;
        }else {
            return null;
        }
    }
}
