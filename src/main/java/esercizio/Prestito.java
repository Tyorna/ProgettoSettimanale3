package esercizio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	protected String utente;
	protected String elementoPrestato;
	protected LocalDate dataInizioPrestito;
	protected LocalDate dataRestituzione;
	protected LocalDate dataRestituzioneEffettiva;

	public Prestito(String utente, String elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzione,
			LocalDate dataRestituzioneEffettiva) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzione = dataRestituzione;
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elemento Prestato =" + elementoPrestato + ", data Inizio Prestito="
				+ dataInizioPrestito + ", dataRestituzione=" + dataRestituzione + ", data di Restituzione="
				+ dataRestituzione + "]" + "\n";
	}

}
