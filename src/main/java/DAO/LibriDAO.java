package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
		System.out.println("Libro salvato!");
	}

	public Libri findByIdLibro(int ISBN) {
		Libri trova = em.find(Libri.class, ISBN);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Libro non trovato");
		}
		return trova;
	}

	public void deleteLibro(int ISBN) {
		Libri trova = em.find(Libri.class, ISBN);
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

	public List<Libri> findByAutore(String autore) {
		TypedQuery<Libri> query = em.createQuery("SELECT a FROM Libri a WHERE a.autore = :autore",
				Libri.class);
		query.setParameter("autore", autore);
		return query.getResultList();
	}

	public void refreshLibro(int ISBN) {
		Libri trova = em.find(Libri.class, ISBN);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
