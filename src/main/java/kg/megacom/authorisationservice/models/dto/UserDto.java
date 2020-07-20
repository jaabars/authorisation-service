package kg.megacom.authorisationservice.models.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String address;

    private AccountDto account;

    private RoleDto role;

}
