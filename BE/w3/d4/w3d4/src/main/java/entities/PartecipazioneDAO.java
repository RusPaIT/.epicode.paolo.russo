package entities;

import utils.JpaUtil;

public class PartecipazioneDAO {

    public void save(Partecipazione partecipazione) {
        JpaUtil.t.begin();
        JpaUtil.em.persist(partecipazione);
        JpaUtil.t.commit();
    }

    public Partecipazione getById(int id) {
        return JpaUtil.em.find(Partecipazione.class, id);
    }

    public void delete(int id) {
        JpaUtil.t.begin();
        Partecipazione partecipazione = JpaUtil.em.find(Partecipazione.class, id);
        JpaUtil.em.remove(partecipazione);
        JpaUtil.t.commit();
    }

    public void refresh(Partecipazione partecipazione) {
        JpaUtil.em.refresh(partecipazione);
    }
    
    public void savePartecipazioneWithPersonAndEvent(Persona persona, Evento evento) {
        JpaUtil.t.begin();
        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setPersona(persona);
        partecipazione.setEvento(evento);
        partecipazione.setStato(Stato.DA_CONFERMARE);
        JpaUtil.em.persist(partecipazione);
        JpaUtil.t.commit();
    }

}
    
