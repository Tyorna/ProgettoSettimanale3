package DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

	public List<Prestito> findPrestitoTessera(int nTessera) {
		TypedQuery<Prestito> query = em.createQuery(
				"SELECT a FROM Prestito a WHERE utente_n_tessera = :numeroTessera", Prestito.class);
		query.setParameter("numeroTessera", nTessera);
		return query.getResultList();
	}

	// METODO CERCA PRESTITI SCADUTI
	public List<Prestito> findPrestitoScaduti() {
		LocalDate today = LocalDate.now();
		TypedQuery<Prestito> query = em.createQuery(
				"SELECT b FROM Prestito b WHERE dataRestituzione < :today AND dataRestituzioneEffettiva IS NULL",
				Prestito.class);
		query.setParameter("today", today);
		return query.getResultList();
	}

	public void refreshPrestito(long id) {
		Prestito trova = em.find(Prestito.class, id);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
