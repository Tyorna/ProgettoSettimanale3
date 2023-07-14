package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.Utente;

public class UtenteDAO {
	private final EntityManager em;

	public UtenteDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Utente e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println(" Utente salvata!");
	}

	public Utente findByIdUtente(long id) {
		Utente trova = em.find(Utente.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Utente non trovato");
		}
		return trova;
	}

	public void deleteUtente(long id) {
		Utente trova = em.find(Utente.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Utente eliminato");
		} else {
			System.out.println("Utente non trovato");
		}
	}

	public void refreshUtente(long id) {
		Utente trova = em.find(Utente.class, id);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
