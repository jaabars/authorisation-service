package kg.megacom.authorisationservice.dao;

import kg.megacom.authorisationservice.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByAccount_IdIs(Long id);
}
