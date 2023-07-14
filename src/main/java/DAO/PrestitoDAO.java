package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.Prestito;

public class PrestitoDAO {
	private final EntityManager em;

	public PrestitoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Prestito e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Prestito salvato!");
	}

	public Prestito findByIdPrestito(long id) {
		Prestito trova = em.find(Prestito.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Prestito non trovato");
		}
		return trova;
	}

	public void deletePrestito(long id) {
		Prestito trova = em.find(Prestito.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Prestito eliminato");
		} else {
			System.out.println("Prestito non trovato");
		}
	}

	public void refreshPrestito(long id) {
		Prestito trova = em.find(Prestito.class, id);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
