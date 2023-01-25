package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "concerti")
@PrimaryKeyJoinColumn(name = "evento_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Concerto extends Evento {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genere")
	private Genere genere;

	@Column(name = "in_streaming")
	private boolean inStreaming;
	
}