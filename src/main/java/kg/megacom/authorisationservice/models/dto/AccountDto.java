package kg.megacom.authorisationservice.models.dto;

import lombok.Data;

@Data
public class AccountDto {

    private Long id;
    private String login;
    private String password;
    private boolean is_active;
}
