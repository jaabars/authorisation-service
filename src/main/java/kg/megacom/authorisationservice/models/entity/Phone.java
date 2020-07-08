package kg.megacom.authorisationservice.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phone;
    private boolean is_active;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
