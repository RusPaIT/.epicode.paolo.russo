package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partite_di_calcio")
@PrimaryKeyJoinColumn(name = "evento_id")
@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInCasa",
query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraCasa")
@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInTrasferta",
query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
@NamedQuery(name = "PartitaDiCalcio.getPartitePareggiate",
query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraCasa = p.numeroGolSquadraOspite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PartitaDiCalcio extends Evento {
	
	@Column(name = "squadra_casa")
	private String squadraCasa;

	@Column(name = "squadra_ospite")
	private String squadraOspite;

	@Column(name = "squadra_vincente", nullable = true)
	private String squadraVincente;

	@Column(name = "numero_gol_squadra_casa")
	private int numeroGolSquadraCasa;

	@Column(name = "numero_gol_squadra_ospite")
	private int numeroGolSquadraOspite;
}
