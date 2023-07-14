package esercizio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

		Libri libro1 = new Libri("Titolo1", "Autore1", "fantasy", "12kdk92", 2019, 305);
		Riviste riviste1 = new Riviste("Riv3", Type.Semestrale, "123jcnaks753", 2010, 115);
		Libri libro2 = new Libri("Titolo2", "Autore2", "Horror", "456jgfd567", 2021, 295);
		Riviste riviste2 = new Riviste("Riv2", Type.Mensile, "12asd3", 2015, 137);
		ld.save(libro1);
		ld.save(libro2);
		rd.save(riviste1);
		rd.save(riviste2);

//		User u = ud.findById(4);
//		System.out.println(u.getDocument());
//
//		Document d = dd.findById(3);
//		System.out.println(d.getUser());

		em.close();
		emf.close();
	}

}
