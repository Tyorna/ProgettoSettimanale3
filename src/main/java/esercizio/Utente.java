package esercizio;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
		protected String nome;
		protected String cognome;
		protected LocalDate dataNascita;
		@Id
		@SequenceGenerator(name = "sequence2", sequenceName = "sequence2", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence2")
		@Column(name = "n_Tessera")
		protected int nTessera;

		@OneToMany(mappedBy = "utente")
		private Set<Prestito> prestito;

		public Utente(String nome, String cognome, LocalDate dataNascita) {
			this.nome = nome;
			this.cognome = cognome;
			this.dataNascita = dataNascita;
		}

		@Override
		public String toString() {
			return "Utente [nome=" + nome + ", cognome=" + cognome + ", data di nascita=" + dataNascita
					+ ", numero Tessera=" + nTessera + "]" + "\n";
		}
}
