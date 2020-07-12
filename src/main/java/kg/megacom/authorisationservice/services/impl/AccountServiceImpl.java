package kg.megacom.authorisationservice.services.impl;

import kg.megacom.authorisationservice.dao.AccountRepository;
import kg.megacom.authorisationservice.mappers.AccountMapper;
import kg.megacom.authorisationservice.models.dto.AccountDto;
import kg.megacom.authorisationservice.models.entity.Account;
import kg.megacom.authorisationservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public AccountDto saveAccount(AccountDto accountDto) {

        Account account = AccountMapper.INSTANCE.accountDtoToAccount(accountDto);

        account= accountRepository.save(account);

        accountDto = AccountMapper.INSTANCE.accountToAccountDto(account);

        return accountDto;
    }
}
