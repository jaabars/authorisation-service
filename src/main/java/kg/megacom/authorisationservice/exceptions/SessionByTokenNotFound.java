package kg.megacom.authorisationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class SessionByTokenNotFound extends RuntimeException{
    public SessionByTokenNotFound(String message) {
        super(message);
    }
}
