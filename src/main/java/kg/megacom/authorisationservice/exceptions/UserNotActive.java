package kg.megacom.authorisationservice.exceptions;

public class UserNotActive extends RuntimeException {
    public UserNotActive(String message) {
        super(message);
    }
}
