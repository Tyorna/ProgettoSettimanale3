package esercizio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Libri extends Catalogo {

	protected String autore;
	protected String genere;

	public Libri(String title, String autore, String genere, int ISBN, LocalDate annoPubbl, int numeroPagine) {
		super(ISBN, title, annoPubbl, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", title=" + title + ", autore=" + autore + ", genere=" + genere + ", annoPubbl="
				+ annopubbl + ", numeroPagine=" + numeroPagine + "]" + "\n";
	}
}
