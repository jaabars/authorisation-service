package kg.megacom.authorisationservice.dao;

import kg.megacom.authorisationservice.models.entity.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByAccount_IdIs(Long id);

    @Query("Select u from users u where u.account.login=?1")
    User getLoginByNativeQuery(String login);

}
