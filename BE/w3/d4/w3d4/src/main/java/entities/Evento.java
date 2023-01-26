package entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;
    
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<Partecipazione> partecipazioni = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
   
}


