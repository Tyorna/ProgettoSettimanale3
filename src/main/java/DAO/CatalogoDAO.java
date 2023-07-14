package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

	public Catalogo findById(int ISBN) {
		Catalogo trova = em.find(Catalogo.class, ISBN);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Elemento del catalogo non trovato");
		}
		return trova;
	}


	public List<Catalogo> findByAnno(int annopubbl) {
		TypedQuery<Catalogo> query = em.createQuery(
				"SELECT a FROM Catalogo a WHERE YEAR(a.annopubbl) = :anno",
				Catalogo.class);
		query.setParameter("anno", annopubbl);
		return query.getResultList();
	}

	public List<Catalogo> findByTitolo(String title) {
		TypedQuery<Catalogo> query = em.createQuery("SELECT a FROM Catalogo a WHERE a.title like :title",
				Catalogo.class);
		query.setParameter("title", title);
		return query.getResultList();
	}



	public Catalogo delete(int ISBN) {
		Catalogo elimina = em.find(Catalogo.class, ISBN);
		if (elimina != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(elimina);
			t.commit();
			System.out.println("Elemento eliminato dal catalogo");
			return elimina;
		} else {
			System.out.println("Elemento del catalogo non trovato");
		}
		return elimina;
	}

	public void refresh(int ISBN) {
		Catalogo trova = em.find(Catalogo.class, ISBN);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
