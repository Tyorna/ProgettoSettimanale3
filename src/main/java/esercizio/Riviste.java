package esercizio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Riviste extends Catalogo {

	@Enumerated(EnumType.STRING)
	protected Type periodicita;

	public Riviste(String title, Type periodicita, int ISBN, LocalDate annoPubbl, int numeroPagine) {
		super(ISBN, title, annoPubbl, numeroPagine);
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Riviste [ISBN=" + ISBN + ", title=" + title + ", periodicita=" + periodicita + ", annoPubbl="
				+ annopubbl
				+ ", numeroPagine=" + numeroPagine + "]" + "\n";
	}
}
