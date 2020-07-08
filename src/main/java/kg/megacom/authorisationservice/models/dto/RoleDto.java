package kg.megacom.authorisationservice.models.dto;

import lombok.Data;

@Data
public class RoleDto {

    private Long id;
    private String name;
    private boolean is_active;
}
