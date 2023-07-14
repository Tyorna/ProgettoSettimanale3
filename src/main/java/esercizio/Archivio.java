package esercizio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import DAO.CatalogoDAO;
import DAO.LibriDAO;
import DAO.RivisteDAO;
import util.JpaUtil;

public class Archivio {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = emf.createEntityManager();
		LibriDAO ld = new LibriDAO(em);
		RivisteDAO rd = new RivisteDAO(em);
		CatalogoDAO cd = new CatalogoDAO(em);

//		Libri libro1 = new Libri("Titolo1", "Autore1", "fantasy", 325243, LocalDate.of(2019, 02, 13), 305);
//		Riviste riviste1 = new Riviste("Riv3", Type.Semestrale, 872154, LocalDate.of(2019, 04, 13), 115);
//		Libri libro2 = new Libri("Titolo2", "Autore2", "Horror", 847654, LocalDate.of(2019, 05, 13), 295);
//		Riviste riviste2 = new Riviste("Riv2", Type.Mensile, 2345678, LocalDate.of(2019, 05, 13), 137);
//		ld.save(libro1);
//		ld.save(libro2);
//		rd.save(riviste1);
//		rd.save(riviste2);

		// Cancella elemento con ISBN
//		Catalogo delete1 = cd.delete(872154);
//		System.out.println(delete1);

		// Trova libro o rivista attraverso ISBN.
		Catalogo find = cd.findById(87654);
		System.out.println(find);

		// Trova libro
		Libri find1 = ld.findByIdLibro(87654);
		System.out.println(find1);

		// Trova rivista
		Riviste find2 = rd.findByIdRivista(872154);
		System.out.println(find2);

		// Trova libro o rivista con l'anno.
		List<Catalogo> findAnno = cd.findByAnno(2019);
		for (Catalogo elementi : findAnno) {
			System.out.println("Elementi con l'anno cercato:" + elementi);
		}
		// Ricerca per autore
		List<Libri> findAutore = ld.findByAutore("Autore1");
		for (Libri elementi : findAutore) {
			System.out.println("Autori trovati" + elementi);
		}
		// Ricerca per titolo o parte di esso
		
		List<Catalogo> findTitolo = cd.findByTitolo("to");
		for (Catalogo elementi : findTitolo) {
			System.out.println("Titoli trovati" + elementi);
		}
			
		// Ricerca degli elementi attualmente in prestito dato un numero di tessera
		// Ricerca di tutti i prestiti scaduti e non ancora restituiti

		em.close();
		emf.close();
	}

}
