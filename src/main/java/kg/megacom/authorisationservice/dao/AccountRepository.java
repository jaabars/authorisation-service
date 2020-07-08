package kg.megacom.authorisationservice.dao;

import kg.megacom.authorisationservice.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByLogin(String login);
}
