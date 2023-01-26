package entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import utils.JpaUtil;

public class EventoDAO {

	public static void save(Evento evento) {

		JpaUtil.t.begin();
		JpaUtil.em.persist(evento);
		JpaUtil.t.commit();

	}

	public Evento getById(int id) {
		return JpaUtil.em.find(Evento.class, id);
	}

	public void delete(int id) {
		JpaUtil.t.begin();
		Evento evento = JpaUtil.em.find(Evento.class, id);
		JpaUtil.em.remove(evento);
		JpaUtil.t.commit();
	}

	public void refresh(Evento evento) {
		JpaUtil.em.refresh(evento);
	}

	public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
		CriteriaBuilder cb = JpaUtil.em.getCriteriaBuilder();
		CriteriaQuery<Concerto> cq = cb.createQuery(Concerto.class);
		Root<Concerto> root = cq.from(Concerto.class);
		cq.select(root).where(cb.equal(root.get("inStreaming"), inStreaming));
		return JpaUtil.em.createQuery(cq).getResultList();
	}

	public List<Concerto> getConcertiPerGenere(List<Genere> generi) {
		CriteriaBuilder builder = JpaUtil.em.getCriteriaBuilder();
		CriteriaQuery<Concerto> criteria = builder.createQuery(Concerto.class);
		Root<Concerto> root = criteria.from(Concerto.class);
		criteria.select(root).where(root.get("genere").in(generi));
		Query query = JpaUtil.em.createQuery(criteria);
		return query.getResultList();
	}

	public static void savePartite() {
		PartitaDiCalcio partita1 = new PartitaDiCalcio("Juventus", "Inter", "Juventus", 3, 2);
		PartitaDiCalcio partita2 = new PartitaDiCalcio("Napoli", "Roma", "Roma", 1, 2);
		PartitaDiCalcio partita3 = new PartitaDiCalcio("Milan", "Lazio", "Pareggio", 2, 2);

		save(partita1);
		save(partita2);
		save(partita3);
	}

	public List<PartitaDiCalcio> getPartiteVinteInCasa() {
		return JpaUtil.em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class)
				.getResultList();
	}

	public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
		return JpaUtil.em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class)
				.getResultList();
	}

	public List<PartitaDiCalcio> getPartitePareggiate() {
		return (List<PartitaDiCalcio>) JpaUtil.em.createNamedQuery("PartitaDiCalcio.getPartitePareggiate")
				.getResultList();
	}

	public void salvaGaraDiAtletica(GaraDiAtletica gara) {
	    JpaUtil.em.getTransaction().begin();
	    JpaUtil.em.persist(gara);
	    JpaUtil.em.getTransaction().commit();
	    JpaUtil.em.close();
	}
	
	/* public Set<GaraDiAtletica> getGareDiAtleticaPerVincitore(int id ){
	        Query query = JpaUtil.em.createQuery("SELECT g FROM GaraDiAtletica g JOIN g.partecipazioni p WHERE p.vincitore = :vincitore", GaraDiAtletica.class);
	        query.setParameter("vincitore",  id);
	        return new HashSet<>(query.getResultList());
	    }*/

}
