package kg.megacom.authorisationservice.mappers;

import kg.megacom.authorisationservice.models.dto.SessionDto;
import kg.megacom.authorisationservice.models.entity.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SessionMapper {

    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    Session sessionDtoToSession(SessionDto sessionDto);
    SessionDto sessionToSessionDto(Session session);

    List<SessionDto> sessionListToSessionDtoList(List<Session> sessionList);
}
