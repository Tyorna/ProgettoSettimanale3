package esercizio;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestiti")
@Getter
@Setter
@NoArgsConstructor
public class Prestito {
	@Id
	@SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	protected Long id;
	protected String elementoPrestato;
	protected LocalDate dataInizioPrestito;
	protected LocalDate dataRestituzione;
	protected LocalDate dataRestituzioneEffettiva;

	@ManyToOne
	@JoinColumn(name = "utente_n_tessera", referencedColumnName = "n_Tessera", nullable = false)
	private Utente utente;

	@OneToMany(mappedBy = "prestito")
	private Set<Catalogo> catalogo;

	public Prestito(String elementoPrestato, LocalDate dataRestituzioneEffettiva, Utente utente) {
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = LocalDate.now();
		this.dataRestituzione = this.dataInizioPrestito.plusDays(30);
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elemento Prestato =" + elementoPrestato + ", data Inizio Prestito="
				+ dataInizioPrestito + ", dataRestituzione=" + dataRestituzione + ", data di Restituzione="
				+ dataRestituzione + "]" + "\n";
	}

}
