package kg.megacom.authorisationservice.dao;

import kg.megacom.authorisationservice.models.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
    Session findByToken(String token);
}
