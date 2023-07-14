package esercizio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Prestito {
	@Id
	@GeneratedValue
	protected Long id;
	protected String elementoPrestato;
	protected LocalDate dataInizioPrestito;
	protected LocalDate dataRestituzione;
	protected LocalDate dataRestituzioneEffettiva;

	@ManyToOne
	@JoinColumn(name = "utente_n_Tessera", referencedColumnName = "n_Tessera", nullable = false)
	private Utente utente;

	public Prestito(Utente utente, String elementoPrestato, LocalDate dataRestituzioneEffettiva) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = LocalDate.now();
		this.dataRestituzione = this.dataInizioPrestito.plusDays(30);
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elemento Prestato =" + elementoPrestato + ", data Inizio Prestito="
				+ dataInizioPrestito + ", dataRestituzione=" + dataRestituzione + ", data di Restituzione="
				+ dataRestituzione + "]" + "\n";
	}

}
