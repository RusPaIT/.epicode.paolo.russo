package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "partite_di_calcio")
@PrimaryKeyJoinColumn(name = "evento_id")
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
