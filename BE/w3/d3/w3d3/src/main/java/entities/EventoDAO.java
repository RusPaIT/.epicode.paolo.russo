package entities;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import utils.JpaUtil;



public class EventoDAO {

	 public void save(Evento evento) {
		 
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

}

