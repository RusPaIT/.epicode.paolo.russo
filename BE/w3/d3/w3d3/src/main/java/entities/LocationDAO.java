package entities;

import utils.JpaUtil;

public class LocationDAO {

    public void save(Location location) {
        JpaUtil.t.begin();
        JpaUtil.em.persist(location);
        JpaUtil.t.commit();
    }

    public Location getById(int id) {
        return JpaUtil.em.find(Location.class, id);
    }

    public void delete(int id) {
        JpaUtil.t.begin();
        Location location = JpaUtil.em.find(Location.class, id);
        JpaUtil.em.remove(location);
        JpaUtil.t.commit();
    }

    public void refresh(Location location) {
        JpaUtil.em.refresh(location);
    }
}