package kg.megacom.authorisationservice.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(value = "id, start_date, user")
public class SessionDto {

    private Long id;

    private String token;

    private Date start_date;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date end_date;

    private UserDto user;
}
