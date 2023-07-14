package esercizio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import DAO.CatalogoDAO;
import DAO.LibriDAO;
import DAO.PrestitoDAO;
import DAO.RivisteDAO;
import DAO.UtenteDAO;
import util.JpaUtil;

public class Archivio {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = emf.createEntityManager();
		LibriDAO ld = new LibriDAO(em);
		RivisteDAO rd = new RivisteDAO(em);
		CatalogoDAO cd = new CatalogoDAO(em);
		UtenteDAO ud = new UtenteDAO(em);
		PrestitoDAO pd = new PrestitoDAO(em);

//		Libri libro1 = new Libri("Titolo1", "Autore1", "fantasy", 325243, LocalDate.of(2019, 02, 13), 305);
//		Riviste riviste1 = new Riviste("Riv3", Type.Semestrale, 872154, LocalDate.of(2019, 04, 13), 115);
//		Libri libro2 = new Libri("Titolo2", "Autore2", "Horror", 847654, LocalDate.of(2019, 05, 13), 295);
//		Riviste riviste2 = new Riviste("Riv2", Type.Mensile, 2345678, LocalDate.of(2019, 05, 13), 137);
//		ld.save(libro1);
//		ld.save(libro2);
//		rd.save(riviste1);
//		rd.save(riviste2);

		Utente ut1 = new Utente("B", "G", LocalDate.of(1993, 05, 28));
		Utente ut2 = new Utente("C", "A", LocalDate.of(1988, 07, 06));
		ud.save(ut1);
		ud.save(ut2);

		Prestito prest1 = new Prestito("CIao", LocalDate.of(2023, 06, 13), ut1);
		pd.save(prest1);
		Prestito prest2 = new Prestito("CIao2", LocalDate.of(2023, 12, 13), ut2);
		pd.save(prest2);

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

		List<Prestito> findTessera = pd.findPrestitoTessera(1);
		for (Prestito elementi : findTessera) {
			System.out.println("Prestiti trovati" + elementi);
		}
			
		List<Prestito> findPScaduti = pd.findPrestitoScaduti();
		for (Prestito elementi : findPScaduti) {
			System.out.println("Prestiti trovati" + elementi);
		}

		// Ricerca degli elementi attualmente in prestito dato un numero di tessera
		// Ricerca di tutti i prestiti scaduti e non ancora restituiti

		em.close();
		emf.close();
	}

}
