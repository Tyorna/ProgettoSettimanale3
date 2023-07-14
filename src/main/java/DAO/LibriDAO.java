package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.Libri;

public class LibriDAO {

	private final EntityManager em;

	public LibriDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Libri e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Salvato!");
	}

	public Libri findById(long id) {
		Libri trova = em.find(Libri.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Libri non trovato");
		}
		return trova;
	}

	public void delete(long id) {
		Libri trova = em.find(Libri.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Libro eliminato");
		} else {
			System.out.println("Libro non trovato");
		}
	}

	public void refresh(long id) {
		Libri trova = em.find(Libri.class, id);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
