package com.stefanini.dao;

import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.*;
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
    public void save(T t){
        em.persist(t);
    }

    public T findById(I id){
        return em.find(clazz, id);
    }

    public <T> List<T> listAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = (CriteriaQuery<T>) builder.createQuery(clazz);
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

    public <T> TypedQuery<T> createQuery(String query) {
        return (TypedQuery<T>) em.createQuery(query, clazz);
    }

    public Query createNativeQuery(String query) {
        return em.createNativeQuery(query, clazz);
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
