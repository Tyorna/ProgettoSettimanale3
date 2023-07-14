package esercizio;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipologia")
@Getter
@Setter
@NoArgsConstructor

public abstract class Catalogo {

	@Id
	protected int ISBN;
	protected String title;
	protected LocalDate annopubbl;
	protected int numeroPagine;


	public Catalogo(int ISBN, String title, LocalDate annoPubbl, int numeroPagine) {
		this.ISBN = ISBN;
		this.title = title;
		this.annopubbl = annoPubbl;
		this.numeroPagine = numeroPagine;
	}
}
