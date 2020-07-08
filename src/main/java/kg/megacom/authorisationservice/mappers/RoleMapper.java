package kg.megacom.authorisationservice.mappers;

import kg.megacom.authorisationservice.models.dto.RoleDto;
import kg.megacom.authorisationservice.models.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleDtoToRole(RoleDto roleDto);
    RoleDto roleToRoleDto(Role role);

    List<RoleDto> roleListToRoleDtoList(List<Role> roleList);
}
