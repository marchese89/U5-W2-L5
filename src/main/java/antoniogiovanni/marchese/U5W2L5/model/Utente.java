package antoniogiovanni.marchese.U5W2L5.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    @OneToMany(mappedBy = "utente")
    @JsonManagedReference
    private List<Dispositivo> dispositivoList;
}
