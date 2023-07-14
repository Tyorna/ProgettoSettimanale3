package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.Catalogo;

public class CatalogoDAO {

	private final EntityManager em;

	public CatalogoDAO (EntityManager em) {
		this.em = em;
	}

	public void save(Catalogo e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Salvato!");
	}

	public Catalogo findById(long id) {
		Catalogo trova = em.find(Catalogo.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Catalogo non trovato");
		}
		return trova;
	}

	public void delete(long id) {
		Catalogo trova = em.find(Catalogo.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Catalogo eliminato");
		} else {
			System.out.println("Catalogo non trovato");
		}
	}

	public void refresh(long id) {
		Catalogo trova = em.find(Catalogo.class, id);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
