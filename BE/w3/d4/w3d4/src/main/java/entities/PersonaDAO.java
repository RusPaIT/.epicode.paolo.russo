package entities;

import java.util.List;

import utils.JpaUtil;

public class PersonaDAO {

    public void save(Persona persona) {
        JpaUtil.t.begin();
        JpaUtil.em.persist(persona);
        JpaUtil.t.commit();
    }

    public Persona getById(int id) {
        return JpaUtil.em.find(Persona.class, id);
    }

    public void delete(int id) {
        JpaUtil.t.begin();
        Persona persona = JpaUtil.em.find(Persona.class, id);
        JpaUtil.em.remove(persona);
        JpaUtil.t.commit();
    }

    public void refresh(Persona persona) {
        JpaUtil.em.refresh(persona);
    }
    
}

