package kg.megacom.authorisationservice.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    private Date start_date;
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
