package kg.megacom.authorisationservice.services.impl;

import kg.megacom.authorisationservice.dao.AccountRepository;
import kg.megacom.authorisationservice.dao.SessionRepository;
import kg.megacom.authorisationservice.dao.UserRepository;
import kg.megacom.authorisationservice.exceptions.AccountNotFound;
import kg.megacom.authorisationservice.exceptions.IncorrectPassword;
import kg.megacom.authorisationservice.exceptions.SessionByTokenNotFound;
import kg.megacom.authorisationservice.mappers.SessionMapper;
import kg.megacom.authorisationservice.models.dto.SessionDto;
import kg.megacom.authorisationservice.models.entity.Account;
import kg.megacom.authorisationservice.models.entity.Session;
import kg.megacom.authorisationservice.models.entity.User;
import kg.megacom.authorisationservice.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public SessionDto signIn(String login, String password) {

        Account account = accountRepository.findByLogin(login);

        if(account.equals(null)) throw new AccountNotFound("Аккаунт с именем: "+login+" не существует");

        if (!account.getPassword().equals(password)) throw new IncorrectPassword("Неверный пароль");

        Session session = new Session();

        session.setStart_date(new Date());
        Date end_date = Date.from(session.getStart_date().toInstant().plusSeconds(600l));
        session.setEnd_date(end_date);
        session.setUser(userRepository.findByAccount_IdIs(account.getId()));
        String token = UUID.randomUUID().toString();
        session.setToken(token);

        session = sessionRepository.save(session);

        SessionDto sessionDto = SessionMapper.INSTANCE.sessionToSessionDto(session);

        return sessionDto;
    }

    @Override
    public boolean logOut(String auth) {
        Session session = sessionRepository.findByToken(auth);
        if(session.equals(null)) throw new SessionByTokenNotFound("Такой сессии не сущесуствует");
        if(session.getEnd_date().getTime()<new Date().getTime()){
            return false;
        }else {
        return true;
        }
    }

    @Override
    public boolean checkSession(String auth) {
        Session session = sessionRepository.findByToken(auth);
        if(session.equals(null)) throw new SessionByTokenNotFound("Такой сессии не сущесуствует");
        if(session.getEnd_date().getTime()>new Date().getTime()){
            return true;
        }else {
            return false;
        }
    }
}
