package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.Riviste;

public class RivisteDAO {

	private final EntityManager em;

	public RivisteDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Riviste e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Rivista salvata!");
	}

	public Riviste findByIdRivista(int ISBN) {
		Riviste trova = em.find(Riviste.class, ISBN);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Rivista non trovata");
		}
		return trova;
	}

	public void deleteRivista(int ISBN) {
		Riviste trova = em.find(Riviste.class, ISBN);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Rivista eliminata");
		} else {
			System.out.println("Rivista non trovata");
		}
	}

	public void refreshRivista(int ISBN) {
		Riviste trova = em.find(Riviste.class, ISBN);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
