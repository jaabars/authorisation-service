package kg.megacom.authorisationservice.mappers;

import kg.megacom.authorisationservice.models.dto.AccountDto;
import kg.megacom.authorisationservice.models.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountDtoToAccount(AccountDto accountDto);
    AccountDto accountToAccountDto(Account account);

    List<AccountDto> accountListToAccountDtoList(List<Account> accountList);
}
