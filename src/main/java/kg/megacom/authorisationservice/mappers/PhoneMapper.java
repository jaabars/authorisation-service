package kg.megacom.authorisationservice.mappers;

import kg.megacom.authorisationservice.models.dto.PhoneDto;
import kg.megacom.authorisationservice.models.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone phoneDtoToPhone(PhoneDto phoneDto);
    PhoneDto phoneToPhoneDto(Phone phone);

    List<PhoneDto> phoneListToPhoneDtoList(List<Phone> phoneList);
}
