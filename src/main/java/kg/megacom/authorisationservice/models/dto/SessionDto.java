package kg.megacom.authorisationservice.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SessionDto {

    private Long id;

    private String token;

    private Date start_date;
    private Date end_date;

    private UserDto user;
}
