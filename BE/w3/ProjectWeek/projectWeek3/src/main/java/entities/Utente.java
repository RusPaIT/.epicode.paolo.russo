package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Utente {
    @Id
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String numeroTessera;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;
}