package com.gchengc.ff.service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;
import java.util.List;

public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    @PersistenceUnit(unitName = "MySql_FF")
    private EntityManagerFactory emf;

    private static EntityManager em;


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public String create(T entity) {
        System.out.println("Estoy en service");
        try {
            if (entity != null) {
                System.out.println("Creando conexion");
                em = getEntityManager();
                //System.out.println("Creando transaccion");
                // em.getTransaction().begin();
                System.out.println("insertando data");
                em.persist(entity);
                System.out.println("joinTransacction");
                em.joinTransaction();
                //System.out.println("Commit");
                //em.getTransaction().commit();
                System.out.println("ok");
            }
            System.out.println("respuesta");
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "ERROR: " + e.getMessage();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<T> findAll() {
        em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    public T find(Object id) {
        System.out.println("Creando conexion");
        em = getEntityManager();
        return em.find(entityClass, id);
    }

    public String edit(T entity) {
        try {
            em = getEntityManager();
            em.merge(entity);
            em.joinTransaction();
            return "SUCCESS";
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        } finally {
            if (em != null) em.close();
        }
    }

    public String remove(T entity) {
        try {
            EntityManager em = getEntityManager();

            em.remove(em.merge(entity));
            em.joinTransaction();
            return "SUCCESS";
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }
}
