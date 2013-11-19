package fr.pomcompot.sample.webapp.daos;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<T> {
    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public abstract void init();
    
    public void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @SuppressWarnings("unchecked")
	public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }
}
