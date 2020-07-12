package kg.megacom.authorisationservice.exceptions;

public class UserExist extends RuntimeException {
    public UserExist(String message) {
        super(message);
    }
}
