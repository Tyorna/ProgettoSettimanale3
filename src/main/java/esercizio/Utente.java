package esercizio;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
		@GeneratedValue
		@Column(name = "n_Tessera")
		protected Long nTessera;

		@OneToMany(mappedBy = "utente")
		private Set<Prestito> prestito;

		public Utente(String nome, String cognome, LocalDate dataNascita, Long nTessera) {
			this.nome = nome;
			this.cognome = cognome;
			this.dataNascita = dataNascita;
			this.nTessera = nTessera;
		}

		@Override
		public String toString() {
			return "Utente [nome=" + nome + ", cognome=" + cognome + ", data di nascita=" + dataNascita
					+ ", numero Tessera=" + nTessera + "]" + "\n";
		}
}
