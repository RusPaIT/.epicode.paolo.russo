package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    private entities.Periodicità periodicità;
    public enum Periodicità { SETTIMANALE, MENSILE, SEMESTRALE }
    
	public void setPeriodicita(entities.Periodicità periodicità) {
		this.periodicità = periodicità;
	}
}

