package kg.megacom.authorisationservice.models.dto;


import lombok.Data;

@Data
public class PhoneDto {

    private Long id;
    private String phone;
    private boolean is_active;
    private UserDto user;

}
