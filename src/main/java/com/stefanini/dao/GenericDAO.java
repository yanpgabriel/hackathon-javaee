package com.stefanini.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAO<T, I>  {

    @PersistenceContext(unitName = "PU")
    EntityManager em;
    
    Class<T> clazz;

    public GenericDAO() {
        clazz = ((Class) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Transactional
    public T save(T t){
        em.persist(t);
        return t;
    }

    public T findById(I id){
        return em.find(clazz, id);
    }

    public List<T> listAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        query.from(clazz);
        return em.createQuery(query).getResultList();
    }

    @Transactional
    public T update(T t){
        return em.merge(t);
    }

    @Transactional
    public void delete(I id){
        T t = findById(id);
        em.remove(t);
    }

    public TypedQuery<T> createQuery(String query) {
        return em.createQuery(query, clazz);
    }

    public Query createNativeQuery(String query) {
        return em.createNativeQuery(query, clazz);
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
