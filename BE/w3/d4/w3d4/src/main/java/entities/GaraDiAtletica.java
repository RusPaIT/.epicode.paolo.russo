package entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import utils.JpaUtil;

@Entity
@Table(name = "gare_di_atletica")
@PrimaryKeyJoinColumn(name = "evento_id")
public class GaraDiAtletica extends Evento {
	
	@ManyToMany
	@JoinTable(name = "atleti_per_gara",
	    joinColumns = @JoinColumn(name = "gara_id"),
	    inverseJoinColumns = @JoinColumn(name = "atleta_id")
	)
	private Set<Persona> atleti = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "vincitore_id")
	private Persona vincitore;
	
    public void addAtleti(List<Persona> atleti) {
        this.atleti.addAll(atleti);
    }
    
    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    public void save() {
      
        JpaUtil.em.getTransaction().begin();
        JpaUtil.em.persist(this);
        JpaUtil.em.getTransaction().commit();
    }

}

