package entities;
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

